package movies.raemacias.com.movieappstage1;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;



public class DetailActivity extends AppCompatActivity {

    TextView textViewOriginalTitle, textViewVoteAverage, textViewPlotSynopsis, textViewReleaseDate ;
    ImageView imageViewMovieListItem, imageViewMovieThumb;

    Movie movie;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //add Toolbar
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        initCollapsingToolbar();

        textViewOriginalTitle = findViewById(R.id.original_title_tv);
        imageViewMovieListItem = findViewById(R.id.movie_poster_iv);
        imageViewMovieThumb = findViewById(R.id.movie_thumb_iv);
        textViewVoteAverage = findViewById(R.id.vote_average_tv);
        textViewPlotSynopsis = findViewById(R.id.plot_synopsis_tv);
        textViewReleaseDate = findViewById(R.id.release_tv);


        //have to test if it has data
        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity.hasExtra("movies")) {

            movie = getIntent().getParcelableExtra("movies");

//            thumbnail = movie.getPosterPath();
//            movieName = movie.getOriginalTitle();
//            synopsis = movie.getOverview();
//            rating = Double.toString(movie.getVoteAverage());
//            dateOfRelease = movie.getReleaseDate();
//            movie_id = movie.getId();

            String poster = "https://image.tmdb.org/t/p/w500";
//                    + thumbnail;


            Picasso.get()
                    .load(poster)
                    .placeholder(R.drawable.popcorn)
                    .into(imageViewMovieThumb);

//            textViewOriginalTitle.setText(movieName);
//            textViewVoteAverage.setText(rating);
//            textViewPlotSynopsis.setText(synopsis);
//            textViewReleaseDate.setText(dateOfRelease);

        } else {
            Toast.makeText(this, "Information not available.", Toast.LENGTH_SHORT).show();
        }
    }

//    private void initCollapsingToolbar() {
//    final CollapsingToolbarLayout collapsingToolbarLayout =
//    (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//    collapsingToolbarLayout.setTitle(" ");
//    AppBarlayout appBarLayout = (AppBarLayout)findViewById(R.id.appbar);
//    appBarLayout.setExpanded(true);
//
//    appBarLayout.addOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//        boolean isShow = false;
//        int scrollRange = -1;
//    @Override
//    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//        if (scrollRange == -1) {
//            scrollRange = appBarLayout.getTotalScrollRange();
//        }
//        if (scrollRange + verticalOffset == 0) {
//            collapsingToolbarLayout.setTitle(getString(R.string.movie_details));
//            isShow = true;
//        } else if (isShow) {
//            collapsingToolbarLayout.setTitle(" ");
//            isShow = false;
//        }
//     }
//    })

}

