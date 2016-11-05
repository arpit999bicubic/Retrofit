package info.androidhive.retrofit.rest;

import info.androidhive.retrofit.model.MoviesResponse;
import info.androidhive.retrofit.model.Stackoverflow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    //    @GET("movie/top_rated")
//    Call<Stackoverflow> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("questions?order=desc&sort=creation&site=stackoverflow&tagged=android")
    Call<Stackoverflow> getTopRatedMovies();

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
