package com.example.marlo.trabalhoretrofit2marlon.Recursos;

import com.example.marlo.trabalhoretrofit2marlon.Modelos.Todos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface TodosResource {

    @GET("/todos")
    Call<List<Todos>> get();

    @GET("/todos/{id}")
    Call<List<Todos>> get (int id);




    @POST("/todos")
    Call<Todos> post(@Body Todos todos);


    @PUT("/todos")
    Call<Todos> put(@Body Todos todos);

}
