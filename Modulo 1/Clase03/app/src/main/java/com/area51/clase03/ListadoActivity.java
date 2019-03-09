package com.area51.clase03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListadoActivity extends AppCompatActivity {
    private ListView lista;
    private UsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lista = findViewById(R.id.lvLista);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter = new UsuarioAdapter(this, AndroidApplication.lista);
        lista.setAdapter(adapter);
    }
}
