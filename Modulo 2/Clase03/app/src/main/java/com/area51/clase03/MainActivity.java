package com.area51.clase03;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDatos;
    private FloatingActionButton fabAgregar;
    private PersonaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDatos = findViewById(R.id.rvDatos);
        fabAgregar = findViewById(R.id.fabAgregar);
    }

    @Override
    protected void onStart() {
        super.onStart();

        MetodoRealm metodoRealm = new MetodoRealm();
        ArrayList<Persona> lista = new ArrayList<>(metodoRealm.obtenerTodos());
        adapter = new PersonaAdapter(lista, this);
        rvDatos.setLayoutManager(new LinearLayoutManager(this));
        rvDatos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(
                                MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
