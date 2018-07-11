package movies.raemacias.com.movieappstage1.api;

import movies.raemacias.com.movieappstage1.BuildConfig;
import movies.raemacias.com.movieappstage1.model.MovieModel;
//import movies.raemacias.com.movieappstage1.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieInterface {

    //The interface defines the possible HTTP operations

    //define base URL
    String BASE_URL = "http://api.themoviedb.org/3/movie/";
    String API_KEY = BuildConfig.API_KEY;
    String POPULAR = "popular";
    String TOP_RATED = "top_rated";
    String POSTER_WIDTH = "w185/";
    String TITLE = "original_title";
    String PLOT = "overview";
    String RELEASE_DATE = "release_date";
    String POSTER_PATH = "poster_path";



    //http request - adds to end of base url
    //add a method - call <type> e.g. array would be list,
    // type of list, list of type movie
    //can name get anything I want

    @GET("original_title")
    Call<MovieModel> getOriginalTitle(
            @Query("api_key") String api_key);

    @GET("popular")
    Call<MovieModel> getPopularMovies(
                    @Query("api_key") String api_key);

    @GET("top_rated")
    Call<MovieModel> getVoteAverage(
            @Query("api_key") String api_key);

    @GET("overview")
    Call<MovieModel> getOverview(
            @Query("api_key") String api_key);

    @GET("release_date")
    Call<MovieModel> getReleaseDate(
            @Query("api_key") String api_key);

    @GET("poster_path")
    Call<MovieModel> getPosterPath(
            @Query("api_key") String api_key);

    }

