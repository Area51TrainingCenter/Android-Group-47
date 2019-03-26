package com.area51.clase03;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    private TextInputLayout tilNombre, tilApellido;
    private AppCompatEditText etNombre, etApellido;
    private AppCompatSpinner spGenero;
    private AppCompatButton btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        tilNombre = findViewById(R.id.tilNombre);
        tilApellido = findViewById(R.id.tilApellido);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        spGenero = findViewById(R.id.spGenero);
        btnRegistrar = findViewById(R.id.btnGuardar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String genero = spGenero.getSelectedItem().toString();

                if (nombre.equals("")) {
                    tilNombre.setError("El campo es requerido");
                    return;
                } else {
                    tilNombre.setError(null);
                }

                Persona persona = new Persona(nombre, apellido, genero);

                MetodoRealm metodoRealm = new MetodoRealm();
                Persona resultado = metodoRealm.registrar(persona);
                if (resultado != null && resultado.getId() != null) {
                    Toast.makeText(RegistroActivity.this,
                            "Se registro", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegistroActivity.this,
                            "No se registro", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
