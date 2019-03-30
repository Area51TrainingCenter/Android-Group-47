package com.area51.claseencuesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etPregunta, etOpcion;
    private RadioButton rbResponder, rbOpcion;
    private Button btnGuardar, btnVisualizar;
    public static ArrayList<Pregunta> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPregunta = findViewById(R.id.etPregunta);
        etOpcion = findViewById(R.id.etOpcion);
        rbResponder = findViewById(R.id.rbResponder);
        rbOpcion = findViewById(R.id.rbOpcion);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnVisualizar = findViewById(R.id.btnVisualizar);

        etOpcion.setVisibility(View.GONE);

        lista = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pregunta = etPregunta.getText().toString();
                String opcion = etOpcion.getText().toString();
                boolean responderSeleccion = rbResponder.isChecked();
                boolean opcionSeleccion = rbOpcion.isChecked();

                Pregunta obj = new Pregunta();
                obj.setPregunta(pregunta);
                obj.setOpciones(opcion);
                obj.setResponderOpcion(responderSeleccion);

                lista.add(obj);

            }
        });
        rbOpcion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                etOpcion.setText("");
                if (b) {
                    etOpcion.setVisibility(View.VISIBLE);
                } else {
                    etOpcion.setVisibility(View.GONE);
                }
            }
        });
        rbResponder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                etOpcion.setText("");
                if (b) {
                    etOpcion.setVisibility(View.GONE);
                } else {
                    etOpcion.setVisibility(View.VISIBLE);
                }
            }
        });

        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        MainActivity.this, VisualizarActivity.class);
                startActivity(intent);

            }
        });
    }
}
