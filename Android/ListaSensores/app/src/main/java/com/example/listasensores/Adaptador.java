package com.example.listasensores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Entidad> listItems;

    public Adaptador(Context context, ArrayList<Entidad> listItems){
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Entidad Item = (Entidad) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.item, null);
        ImageView imgFoto = view.findViewById(R.id.imageView_imagen);
        TextView Titulo = view.findViewById(R.id.textView_superior);
        TextView Contenido = view.findViewById(R.id.textView_inferior);

        imgFoto.setImageResource(Item.get_idImagen());
        Titulo.setText(Item.get_textoEncima());
        Contenido.setText(Item.get_textoDebajo());

        return view;
    }
}
