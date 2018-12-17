package com.example.marlo.trabalhoretrofit2marlon.Recursos;

import com.example.marlo.trabalhoretrofit2marlon.Modelos.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoResource {

    @GET("/photos")
    Call<List<Photos>> get();

    @GET("/photos/{id}")
    Call<List<Photos>> get(int id);
}
