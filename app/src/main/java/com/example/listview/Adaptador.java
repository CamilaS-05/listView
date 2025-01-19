package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class Adaptador extends BaseAdapter {

    private ArrayList<Encapsulador> entradas;
    private int R_layout_IdView;
    private Context contexto;

    public Adaptador(Context contexto, int R_layout_IdView, ArrayList<Encapsulador> entradas) {
        super();
        this.contexto = contexto;
        this.entradas = entradas;
        this.R_layout_IdView = R_layout_IdView;
    }


    @Override
    public int getCount() {
        return entradas.size();
    }

    @Override
    public Object getItem(int posicion) {
        return entradas.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup pariente) {

        if (view == null) {
            LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R_layout_IdView, null); // Inflar el layout
        }

        onEntrada(entradas.get(posicion), view);

        return view;
    }

    public void onEntrada(Encapsulador entrada, View view) {

        ImageView imagen = view.findViewById(R.id.imagen);
        TextView titulo = view.findViewById(R.id.texto_titulo);
        TextView descripcion = view.findViewById(R.id.texto_datos);
        RadioButton radioButton = view.findViewById(R.id.boton);

        imagen.setImageResource(entrada.getIdImagen());
        titulo.setText(entrada.getTextoTitulo());
        descripcion.setText(entrada.getTextoContenido());
        radioButton.setChecked(entrada.isFavorito());
    }
}
