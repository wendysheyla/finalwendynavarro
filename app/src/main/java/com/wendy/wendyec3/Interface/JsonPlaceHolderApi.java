package com.wendy.wendyec3.Interface;

import com.wendy.wendyec3.ModelClothes.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Posts>> getPosts();
}
