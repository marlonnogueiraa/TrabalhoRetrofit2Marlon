package com.example.marlo.trabalhoretrofit2marlon.Atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marlo.trabalhoretrofit2marlon.R;
import com.example.marlo.trabalhoretrofit2marlon.Boostrap.APIClient;
import com.example.marlo.trabalhoretrofit2marlon.Modelos.Post;
import com.example.marlo.trabalhoretrofit2marlon.Recursos.PostResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ManipulationActivity extends AppCompatActivity {

    protected EditText titulo;
    protected EditText corpo;
    protected EditText busca;
    protected EditText complemento;
    int finalValor;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipulation);
        titulo = (EditText) findViewById(R.id.editTextTitulo);
        corpo = (EditText) findViewById(R.id.editTextCorpo);
        busca = (EditText) findViewById(R.id.editTextBusca);


        busca.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    busca.setText("");
                }
                return false;
            }
        });


    }

    public void ServicePost(View view) {


    }

    public void BuscarItem(View view) {
        //TextView userId = (TextView) view.findViewById(R.id.textuserid);
        String buscar = busca.getText().toString();
        finalValor = Integer.parseInt(buscar);
        Toast.makeText(ManipulationActivity.this, "O numero é: " + finalValor, Toast.LENGTH_LONG).show();

        //System.out.println("Numero buscado é: "+ busca.toString());

        //Pega a referencia do ENDPOIT e dp converter(gson)
        Retrofit retrofit = APIClient.getClient();

        //faz o 'bind' da instancia do retrofit com interface, que contém as operações (GET,POST,PUT,DELETE)
        PostResource postResource = retrofit.create(PostResource.class);

        //Faz a chamada do serviço
        Call<List<Post>> get = postResource.get();


        get.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                // Post lista = (Post) posts;

                // System.out.println(posts.size());
                //       System.out.println(posts.get(finalValor - 1).getTitle());
                titulo.setText(posts.get(finalValor).getTitle());
                corpo.setText(posts.get(finalValor).getBody());
                userId = posts.get(finalValor).getUserId();


                //  buscarDados(posts);


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }


    public void addDado(View view) {

        //if(titulo. || corpo!= null){
        //  Toast.makeText(ManipulationActivity.this, "OS CAMPOS 'TITULO' E 'CORPO' ESTA VAZIO!!", Toast.LENGTH_LONG).show();
        //}else{
        String userId, id, tituloReceb, corpoReceb;

        //   id = Integer.toString(101);
        tituloReceb = titulo.getText().toString();
        corpoReceb = corpo.getText().toString();


        Post post = new Post("1", null, tituloReceb, corpoReceb);


        //Pega a referencia do ENDPOIT e dp converter(gson)
        Retrofit retrofit = APIClient.getClient();

        //faz o 'bind' da instancia do retrofit com interface, que contém as operações (GET,POST,PUT,DELETE)
        PostResource postResource = retrofit.create(PostResource.class);

        //Faz a chamada do serviço
        Call<Post> postt = postResource.post(post);

        postt.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post p = response.body();
                Toast.makeText(getApplicationContext(), "UserId: " + p.getUserId() + "\n" + "ID: " + p.getId() + "Titulo: " + p.getTitle() + "Corpo: " + p.getBody(),
                        Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Toast.makeText(getApplicationContext(),
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();

            }
        });

        // }


    }

    public void alterarDado(View view) {
        String id, tituloReceb, corpoReceb;

        id = Integer.toString(finalValor);
        tituloReceb = titulo.getText().toString();
        corpoReceb = corpo.getText().toString();


        Post post = new Post("1", id, tituloReceb, corpoReceb);


        //Pega a referencia do ENDPOIT e dp converter(gson)
        Retrofit retrofit = APIClient.getClient();

        //faz o 'bind' da instancia do retrofit com interface, que contém as operações (GET,POST,PUT,DELETE)
        PostResource postResource = retrofit.create(PostResource.class);

        //Faz a chamada do serviço
        Call<Post> put = postResource.put(post);

        put.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post p = response.body();
                Toast.makeText(getApplicationContext(), "ID: " + p.getId() + "Titulo: " + p.getTitle() + "Corpo: " + p.getBody(),
                        Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Toast.makeText(getApplicationContext(),
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();

            }
        });
    }

}


