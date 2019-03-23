package com.area51.clase01_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.area51.clase01_2.entidades.Producto;

import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Button btnAgregar;
    private ListView lvLista;
    private ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregar = findViewById(R.id.btnAgregar);
        lvLista = findViewById(R.id.lvLista);
    }

    @Override
    protected void onResume() {
        super.onResume();

        MetodoRealm metodoRealm = new MetodoRealm();
        RealmResults<Producto> lista = metodoRealm.listar();
        adapter = new ProductoAdapter(lista, this);
        lvLista.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
