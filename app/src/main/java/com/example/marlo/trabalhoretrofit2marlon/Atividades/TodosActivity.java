package com.example.marlo.trabalhoretrofit2marlon.Atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.marlo.trabalhoretrofit2marlon.R;
import com.example.marlo.trabalhoretrofit2marlon.Boostrap.APIClient;
import com.example.marlo.trabalhoretrofit2marlon.Modelos.Todos;
import com.example.marlo.trabalhoretrofit2marlon.Modelos.TodosAdapter;
import com.example.marlo.trabalhoretrofit2marlon.Recursos.TodosResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TodosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);




        //Pega a referencia do ENDPOIT e dp converter(gson)
        Retrofit retrofit = APIClient.getClient();

        //faz o 'bind' da instancia do retrofit com interface, que contém as operações (GET,POST,PUT,DELETE)

        TodosResource todosResource = retrofit.create(TodosResource.class);

        //Faz a chamada do serviço
        Call<List<Todos>> get = todosResource.get();


        get.enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                // se deu certo executar este metodo
                List<Todos> todos = response.body();

                ChamadaComponete(todos);
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {

            }
        });





    }


    private void ChamadaComponete(List<Todos> variavel) {
        ListView lista = (ListView) findViewById(R.id.ListViewTodos);

        TodosAdapter adapter = new TodosAdapter(variavel, this);
        lista.setAdapter(adapter);
    }
}
