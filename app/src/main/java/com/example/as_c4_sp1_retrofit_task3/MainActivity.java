package com.example.as_c4_sp1_retrofit_task3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textAPI;
    ArrayList<Photo> photos = new ArrayList<Photo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Context context;
        textAPI = findViewById(R.id.textView_Sol);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonApi json = retrofit.create(JsonApi.class);
        Call<List<Photo>> call = json.getPosts();
        context = this;
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if(!response.isSuccessful())
                {
                    textAPI.setText(response.code());
                    return;
                }
                List<Photo> posts = response.body();
                photos.addAll(posts);
                RecyclerView rvCountries = findViewById(R.id.recyclerView);
                // Create adapter passing in the sample user data
                CPhotosAdapter adapter = new CPhotosAdapter(photos, context);
                // Attach the adapter to the recyclerview to populate items
                rvCountries.setAdapter(adapter);
                // Set layout manager to position the items
                rvCountries.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
               // textAPI.setText(t.getMessage());
            }
        });
    }
}