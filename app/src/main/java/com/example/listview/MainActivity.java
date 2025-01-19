package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Encapsulador> datos;
    private RadioButton radioSeleccionado = null;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        textViewInfo = findViewById(R.id.textViewInfo);
        datos = new ArrayList<>();

        datos.add(new Encapsulador(R.drawable.sofa, "Sofá", "Cómodo para sentarse y relajarse.", false));
        datos.add(new Encapsulador(R.drawable.mesa, "Mesa", "Ideal para comer o trabajar.", false));
        datos.add(new Encapsulador(R.drawable.silla, "Silla", "Perfecta para sentarse.", false));
        datos.add(new Encapsulador(R.drawable.estanteria, "Estantería", "Útil para organizar libros y objetos.", false));
        datos.add(new Encapsulador(R.drawable.cama, "Cama", "Para descansar y dormir cómodamente.", false));
        datos.add(new Encapsulador(R.drawable.armario, "Armario", "Para guardar ropa y accesorios.", false));
        datos.add(new Encapsulador(R.drawable.mueble_tv, "Mueble de TV", "Soporte ideal para tu televisor.", false));
        datos.add(new Encapsulador(R.drawable.banco, "Banco", "Práctico para múltiples usos.", false));
        datos.add(new Encapsulador(R.drawable.comoda, "Cómoda", "Organiza ropa y accesorios pequeños.", false));
        datos.add(new Encapsulador(R.drawable.escritorio, "Escritorio", "Espacio perfecto para trabajar o estudiar.", false));

        Adaptador adaptador = new Adaptador(this, R.layout.entrada, datos) {
            @Override
            public void onEntrada(Encapsulador entrada, View view) {
                ImageView imagen = view.findViewById(R.id.imagen);
                TextView titulo = view.findViewById(R.id.texto_titulo);
                TextView descripcion = view.findViewById(R.id.texto_datos);
                RadioButton radioButton = view.findViewById(R.id.boton);

                imagen.setImageResource(entrada.getIdImagen());
                titulo.setText(entrada.getTextoTitulo());
                descripcion.setText(entrada.getTextoContenido());
                radioButton.setChecked(entrada.isFavorito());

                radioButton.setOnClickListener(v -> {

                    if (radioSeleccionado != null && radioSeleccionado != radioButton) {
                        radioSeleccionado.setChecked(false);
                    }

                    radioSeleccionado = radioButton;

                    textViewInfo.setText("MUEBLE SELECCIONADO: " + entrada.getTextoTitulo());

                    for (Encapsulador item : datos) {
                        item.setFavorito(false);
                    }
                    entrada.setFavorito(true);
                });
            }
        };

        listView.setAdapter(adaptador);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Encapsulador itemSeleccionado = datos.get(position);
            Toast.makeText(getApplicationContext(), "Seleccionaste: " + itemSeleccionado.getTextoTitulo(), Toast.LENGTH_SHORT).show();
        });
    }
}
