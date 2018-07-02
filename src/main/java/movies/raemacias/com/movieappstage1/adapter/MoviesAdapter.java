package movies.raemacias.com.movieappstage1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import movies.raemacias.com.movieappstage1.R;
import movies.raemacias.com.movieappstage1.model.MovieModel;
import movies.raemacias.com.movieappstage1.model.Result;
import retrofit2.Callback;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieListViewHolder> {


    // This code has been adapted from www.learn2crack.com
    // and Simplified Coding

    //    private final Callback<MovieModel> context;
    private Context context;
    private List<Result> results;

    public MoviesAdapter(Context context,List<Result> results) {
        this.context = context;
        this.results = results;
    }

    //    //This adapter code is based on Simplified Coding tutorials.
    @NonNull
    @Override
    public MoviesAdapter.MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_poster, null);

        MovieListViewHolder holder = new MovieListViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MovieListViewHolder holder, int position) {
        holder.textViewOriginalTitle.setText(results.get(position).getOriginalTitle());
//        String vote = Double.toString(results.get(position).getVoteAverage());
//        holder.textViewVoteAverage.setText(vote);
//        holder.textViewPlotSynopsis.setText(results.get(position).getOverview());
//        holder.textViewReleaseDate.setText(results.get(position).getReleaseDate());

//        String posterPath = "https://image.tmdb.org/t/p/w500" + results.get(position).getPosterPath();

        Picasso.with(context)
                .load(results.get(position).getPosterPath())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageViewMovieListItem);
    }

    @Override
    public int getItemCount() {
        //We need the object model to be passed to this layer.
        return results.size();
    }
    class MovieListViewHolder extends RecyclerView.ViewHolder {

        TextView textViewOriginalTitle, textViewVoteAverage,textViewPlotSynopsis, textViewReleaseDate;
        ImageView imageViewMovieListItem, imageViewMoviethumb;
        CardView cardViewMovieList;


        public MovieListViewHolder(View viewItem) {
            super(viewItem);
            textViewOriginalTitle = viewItem.findViewById(R.id.original_title_tv);
            cardViewMovieList = viewItem.findViewById(R.id.card_view);
            imageViewMovieListItem = viewItem.findViewById(R.id.movie_poster_iv);
            textViewVoteAverage = viewItem.findViewById(R.id.vote_average_tv);
            imageViewMoviethumb = viewItem.findViewById(R.id.movie_thumb_iv);
            textViewPlotSynopsis = viewItem.findViewById(R.id.plot_synopsis_tv);
            textViewReleaseDate = viewItem.findViewById(R.id.release_tv);
            }
    }
}

//        }
//
//
////        @Override
////        public void onClick(View v) {
////            mRViewClickListener.onClick(v, getAdapterPosition());
////        }
//    }
////        RvClickListener listener = new RvClickListener() {
////            @Override
////            public void onClick(View view, int i) {
////                Intent intent = new Intent(parent.getContext(), DetailActivity.class);
////                intent.putExtra(MOVIE_MODEL, (Serializable) movieList.get(i));
////                mContext.startActivity(intent);
////            }
////        };
//}
