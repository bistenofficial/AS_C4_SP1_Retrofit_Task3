package com.example.as_c4_sp1_retrofit_task3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi
{
    @GET("rovers/curiosity/photos?sol=10&api_key=h7gib0MogiVQqAA5jX6KejMTqZ6aEIyuKvMKXjxl")
    Call<List<Photo>> getPosts();
}
