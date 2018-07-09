package movies.raemacias.com.movieappstage1;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

import movies.raemacias.com.movieappstage1.api.MovieInterface;

public class DetailActivity extends AppCompatActivity {

    TextView textViewOriginalTitle, textViewVoteAverage, textViewPlotSynopsis, textViewReleaseDate ;
    ImageView imageViewMovieListItem, imageViewMovieThumb;


    private final AppCompatActivity activity = DetailActivity.this;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        initCollapsingToolbar();

        textViewOriginalTitle = findViewById(R.id.original_title_tv);
        imageViewMovieListItem = findViewById(R.id.movie_poster_iv);
        imageViewMovieThumb = findViewById(R.id.movie_thumb_iv);
        textViewVoteAverage = findViewById(R.id.vote_average_tv);
        textViewPlotSynopsis = findViewById(R.id.plot_synopsis_tv);
        textViewReleaseDate = findViewById(R.id.release_tv);

        Intent intent = getIntent();
        if (intent.hasExtra("original_title")) {

//            String thumbnail = getIntent().getExtras().getString("poster_path");
            String movieTitle = getIntent().getExtras().getString("original_title");
            String synopsis = getIntent().getExtras().getString("overview");
            String rating = getIntent().getExtras().getString("vote_average");
            String release = getIntent().getExtras().getString("release_date");

            String thumbnail = "https://image.tmdb.org/t/p/w500";

            Picasso.get()
                    .load(thumbnail)
                    .placeholder(R.drawable.popcorn)
                    .into(imageViewMovieThumb);

            textViewOriginalTitle.setText(movieTitle);
            textViewVoteAverage.setText(rating);
            textViewPlotSynopsis.setText(synopsis);
            textViewReleaseDate.setText(release);

            Toast.makeText(this, "Information not available.", Toast.LENGTH_SHORT).show();
        }
    }

//        private void initCollapsingToolbar() {
//        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
//        collapsingToolbarLayout.setTitle(" ");
//        AppBarLayout appBarLayout = findViewById(R.id.appbar);
//        appBarLayout.setExpanded(true);
//
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbarLayout.setTitle(getString(R.string.details));
//                    isShow = true;
//                } else if (isShow) {
//                    collapsingToolbarLayout.setTitle(" ");
//                    isShow = false;
//
//                }
//            }
//        });
//    }

}


