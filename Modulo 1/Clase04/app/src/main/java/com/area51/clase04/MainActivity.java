package com.area51.clase04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private FotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gvDatos);

        ArrayList<Foto> lista = new ArrayList<>();
        //Agregamos fotos a mostrar
        lista.add(
                new Foto("Imagen 1", "https://estaticos.muyinteresante.es/media/cache/760x570_thumb/uploads/images/article/5c3871215bafe83b078adbe3/perro.jpg")
        );
        lista.add(
                new Foto("Imagen 2", "https://media.aweita.larepublica.pe/678x508/aweita/imagen/2018/03/10/noticia-por-que-tu-perro-no-le-caen-ciertas-personas.png")
        );
        lista.add(
                new Foto("Imagen 3", "https://images.clarin.com/2019/01/18/RBBMxtqH5_1256x620__1.jpg")
        );
        lista.add(
                new Foto("Imagen 3", "res:/" + R.drawable.ic_derecha)
        );

        adapter = new FotoAdapter(this, 0, lista);
        gridView.setAdapter(adapter);
    }
}
