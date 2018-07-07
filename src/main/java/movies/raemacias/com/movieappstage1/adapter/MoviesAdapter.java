package movies.raemacias.com.movieappstage1.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import movies.raemacias.com.movieappstage1.DetailActivity;
import movies.raemacias.com.movieappstage1.R;
import movies.raemacias.com.movieappstage1.model.Result;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieListViewHolder> {

    // This code has been adapted from www.learn2crack.com
    // and Simplified Coding

    private Context context;
    private List<Result> results;

    public MoviesAdapter(Context context, List<Result> results) {
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
        String poster = "https://image.tmdb.org/t/p/w500" + results.get(position).getPosterPath();

        Picasso.get()
                .load(poster)
                .placeholder(R.drawable.popcorn)
                .into(holder.imageViewMovieListItem);
    }

    @Override
    public int getItemCount() {
        //We need the object model to be passed to this layer.
        return results.size();
    }

    class MovieListViewHolder extends RecyclerView.ViewHolder {

        TextView textViewOriginalTitle, textViewVoteAverage, textViewPlotSynopsis, textViewReleaseDate;
        ImageView imageViewMovieListItem, imageViewMoviethumb;
        CardView cardViewMovieList;
        LinearLayout linearLayout;

        public MovieListViewHolder(View viewItem) {
            super(viewItem);
            textViewOriginalTitle = viewItem.findViewById(R.id.original_title_tv);
            cardViewMovieList = viewItem.findViewById(R.id.card_view);
            imageViewMovieListItem = viewItem.findViewById(R.id.movie_poster_iv);
            textViewVoteAverage = viewItem.findViewById(R.id.vote_average_tv);
            imageViewMoviethumb = viewItem.findViewById(R.id.movie_thumb_iv);
            textViewPlotSynopsis = viewItem.findViewById(R.id.plot_synopsis_tv);
            textViewReleaseDate = viewItem.findViewById(R.id.release_tv);
            linearLayout = viewItem.findViewById(R.id.linear_layout);

            viewItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Result clickedDataItem = results.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        //I don't think String.valueOf is correct
//                        intent.putExtra("movies", clickedDataItem);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    }

