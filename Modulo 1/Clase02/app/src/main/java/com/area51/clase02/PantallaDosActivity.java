package com.area51.clase02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaDosActivity extends AppCompatActivity {
    private TextView nombreCompleto;
    private Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

        nombreCompleto = findViewById(R.id.tvNombreCompleto);
        atras = findViewById(R.id.btnAtras);

        String nombre =
                getIntent().getStringExtra("v_nombre");
        String apellido =
                getIntent().getStringExtra("v_apellido");

        nombreCompleto.setText(
                nombre + " " + apellido
        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });
    }
}
