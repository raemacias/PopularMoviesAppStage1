package movies.raemacias.com.movieappstage1;

//this code was input and interpreted by watching tutorials
//from Delaroy Studios on YouTube. Also input from Android Basics
//Networking course and other student advice and input

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import movies.raemacias.com.movieappstage1.adapter.MoviesAdapter;
import movies.raemacias.com.movieappstage1.api.MovieInterface;
import movies.raemacias.com.movieappstage1.model.MovieModel;
import movies.raemacias.com.movieappstage1.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    GridLayoutManager layoutManager;
    RecyclerView recyclerView;
    List<Result> results;
    MoviesAdapter adapter;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        initViews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sort_popular) {
            Toast.makeText(MainActivity.this, "You clicked on popular sort", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.sort_top_rated) {
            Toast.makeText(MainActivity.this, "You clicked on top rated sort", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){
        results = new ArrayList<>();
        adapter = new MoviesAdapter(getApplicationContext(), results);

        //Set layout manager for recyclerview
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);

        //from whatever layout i have in xml - then create string array in onResponse
//        final TextView textView = findViewById(R.id.recyclerview);

        //call the methods
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //now we have our retrofit object

        //then we build the api and then call the api
        //the create takes the interface class
        MovieInterface movieInterface = retrofit.create(MovieInterface.class);

        //call the getMovies object from the api
        Call<MovieModel> call = movieInterface.getMovies(MovieInterface.API_KEY);

        //calling the api, takes a callback interface
        //type in new then hit control + space and it will do everything for me

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                //inside the response we want to get List type
                if (response.body() != null) {

                    List<Result> results = Arrays.asList(response.body().getResults());
                    layoutManager = new GridLayoutManager(MainActivity.this, 2);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(new MoviesAdapter(getApplicationContext(), results));

                    String[] movieNames = new String[results.size()];

                    //then run loop
                    for (int i = 0; i < results.size(); i++) {
                        movieNames[i] = results.get(i).getOriginalTitle();
                    }

                    //we can display all the movie info in the log
                    for (Result h : results) {
//
                        Log.d("poster_path", h.getPosterPath());
                        Log.d("overview", h.getOriginalTitle());
                        Log.d("release_date", h.getReleaseDate());
                        Log.d("original_title", h.getOriginalTitle());
//                Log.d("vote_average", h.getVoteAverage());

                    }

                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
    }
}











