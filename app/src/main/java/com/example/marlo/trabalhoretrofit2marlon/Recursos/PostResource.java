package com.example.marlo.trabalhoretrofit2marlon.Recursos;

import com.example.marlo.trabalhoretrofit2marlon.Modelos.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PostResource {

    @GET("/posts")
    Call<List<Post>> get();

    @GET("/posts/{id}")
    Call<List<Post>> get (int id);




    @POST("/posts")
    Call<Post> post(@Body Post post);


    @PUT("/posts")
    Call<Post> put(@Body Post post);





}
