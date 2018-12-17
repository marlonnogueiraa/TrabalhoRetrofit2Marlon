package com.example.marlo.trabalhoretrofit2marlon.Atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.marlo.trabalhoretrofit2marlon.R;
import com.example.marlo.trabalhoretrofit2marlon.Boostrap.APIClient;
import com.example.marlo.trabalhoretrofit2marlon.Modelos.Post;
import com.example.marlo.trabalhoretrofit2marlon.Modelos.PostAdapter;
import com.example.marlo.trabalhoretrofit2marlon.Recursos.PostResource;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //Pega a referencia do ENDPOIT e dp converter(gson)
        Retrofit retrofit = APIClient.getClient();

        //faz o 'bind' da instancia do retrofit com interface, que contém as operações (GET,POST,PUT,DELETE)

        PostResource postResource = retrofit.create(PostResource.class);

        //Faz a chamada do serviço
        Call<List<Post>> get = postResource.get();




        get.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //Se deu certo executa este metodo

                List<Post> posts = response.body();
                // posts.forEach(p-> Log.i("fasm",p.toString()));

                ArrayList<String>elementos = new ArrayList<>();

                if(posts == null){
                    System.out.println("ArrayESTA NULL");

                }else {


                    for (int i = 0; i < posts.size(); i++) {

                        elementos.add(posts.get(i).toString());
                    }
                    if (elementos.isEmpty()) {
                        System.out.print("Esta vazia");
                    } else {
                        System.out.println("Não est vazia");
                    }

                }
                ChamadaComponete(posts);


                // List<Post> todos = posts;


                //  ArrayList<String> todos = posts;


                // for(int i= 0; i < posts.size() ; i++ ){
                //    Log.i( "fasam", posts.get(i).toString());

                //System.out.print("fasam"+ "\n"+posts.toString());
                //  System.out.println("Marlon Nogueira" + " Fimmmmmm");
                //}



            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //se houver algum erro passará por aqui para tratar!!
            }
        });


    }

    private void ChamadaComponete(List<Post> variavel) {
        ListView lista = (ListView) findViewById(R.id.ListView);

       PostAdapter adapter = new PostAdapter(variavel, this);
       lista.setAdapter(adapter);

    }


}
