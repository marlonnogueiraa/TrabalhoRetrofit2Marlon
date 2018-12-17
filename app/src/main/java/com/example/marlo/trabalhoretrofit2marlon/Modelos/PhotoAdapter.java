package com.example.marlo.trabalhoretrofit2marlon.Modelos;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marlo.trabalhoretrofit2marlon.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends BaseAdapter {
    private final List<Photos> lista;
    private final Activity act;

    public PhotoAdapter(List<Photos> lista, Activity act) {
        this.lista = lista;
        this.act = act;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View View, ViewGroup parent){

        View view = act.getLayoutInflater().inflate(R.layout.itensphoto,parent,false);


        Photos post = lista.get(position);

        //pegando as referencias das views

            TextView albumId = (TextView) view.findViewById(R.id.textViewAlbumID);
            TextView id = (TextView) view.findViewById(R.id.textViewID);
            TextView titulo = (TextView) view.findViewById(R.id.textViewTitulo);
        ImageView imageUrl = (ImageView) view.findViewById(R.id.imageViewURL);
        ImageView thumbnailUrl = (ImageView) view.findViewById(R.id.imageViewthumbnailUrl);
        TextView url = (TextView) view.findViewById(R.id.textViewURL);
        TextView outro = (TextView) view.findViewById(R.id.textViewOutro);




            //pulando as views

        //System.out.println("Esta null");

          //  System.out.println("Posição: " + post.getUserId());
        System.out.println(lista.size());
                System.out.println("PRIMEIRO: " );
                albumId.setText("UserId: " +post.getAlbumId());
                id.setText("ID: "+post.getId());
                titulo.setText("Titulo: "+post.getTitle());
                url.setText(("URL: " + post.getUrl()));
                outro.setText("thumbnailUrl: " + post.getThumbnailUrl());
        Picasso.with(act).
                load(post.getUrl()).
                resize(150 ,150).
               into(imageUrl);

        Picasso.with(act).
               load(post.getThumbnailUrl()).
                resize(150 ,150).
              into(thumbnailUrl);




            //    complemento.setText("Complemento: " +post.getBody());



        return view;
        }
}
