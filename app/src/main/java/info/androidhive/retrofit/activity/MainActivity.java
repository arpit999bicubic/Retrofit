package info.androidhive.retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import info.androidhive.retrofit.R;
import info.androidhive.retrofit.adapter.MoviesAdapter;
import info.androidhive.retrofit.model.Stackoverflow;
import info.androidhive.retrofit.rest.ApiClient;
import info.androidhive.retrofit.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "497f9959b3579f25ecbf70281f6db0b8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       /* ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Stackoverflow> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<Stackoverflow>() {
            @Override
            public void onResponse(Call<Stackoverflow> call, Response<Stackoverflow> response) {
                int statusCode = response.code();
                List<Stackoverflow.ItemsBean> movies = response.body().getItems();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Stackoverflow> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });*/


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Stackoverflow> call = apiService.getTopRatedMovies();
        call.enqueue(new Callback<Stackoverflow>() {
            @Override
            public void onResponse(Call<Stackoverflow> call, Response<Stackoverflow> response) {
                int statusCode = response.code();
                List<Stackoverflow.ItemsBean> movies = response.body().getItems();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Stackoverflow> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });



    }
}
