package com.example.marlo.trabalhoretrofit2marlon.Atividades;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.marlo.trabalhoretrofit2marlon.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        System.out.println("Marlon Nogueira" + " INICIOOOO");




    }


    public void servicoTodos(View view) {

        Intent intent = new Intent(this, TodosActivity.class);
        startActivity(intent);


    }

    public void servicoPost(View view) {

        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
    }

    public void ServicoManipularPost(View view) {
        Intent intent = new Intent(this,ManipulationActivity.class);
        startActivity(intent);
    }

    public void ServicoManipularTodos(View view) {
        Intent intent = new Intent(this,ManipulationActivityTodos.class);
        startActivity(intent);
    }

    public void ServicoPhoto(View view) {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);

    }
}
