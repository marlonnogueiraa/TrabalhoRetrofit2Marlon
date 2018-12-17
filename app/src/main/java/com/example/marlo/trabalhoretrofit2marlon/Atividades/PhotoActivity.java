package com.example.marlo.trabalhoretrofit2marlon.Atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.marlo.trabalhoretrofit2marlon.R;
import com.example.marlo.trabalhoretrofit2marlon.Boostrap.APIClient;
import com.example.marlo.trabalhoretrofit2marlon.Modelos.PhotoAdapter;
import com.example.marlo.trabalhoretrofit2marlon.Modelos.Photos;
import com.example.marlo.trabalhoretrofit2marlon.Recursos.PhotoResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Retrofit retrofit = APIClient.getClient();


        PhotoResource photoResource= retrofit.create(PhotoResource.class);

        Call<List<Photos>> get = photoResource.get();


        get.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {

                List<Photos> photo = response.body();

                if(photo == null){
                    System.out.println("Array NULL");
                }else{
                    chamaComponete(photo);

                }

            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });





















    }

    private void chamaComponete(List<Photos> variavel){
        ListView lista = (ListView) findViewById(R.id.listViewPhoto);
        PhotoAdapter adapter = new PhotoAdapter(variavel, this);

        lista.setAdapter(adapter);

    }

    }

