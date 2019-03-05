package com.area51.clase03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button listar, guardar;
    private EditText usuario, nombre, apellido;
    private RadioButton masculino, femenino;
    private Spinner edad;
    public static ArrayList<Usuario> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();

        listar = findViewById(R.id.btnListar);
        guardar = findViewById(R.id.btnGuardar);
        usuario = findViewById(R.id.etUsuario);
        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        masculino = findViewById(R.id.rbMasculino);
        femenino = findViewById(R.id.rbFemenino);
        edad = findViewById(R.id.spEdad);

        ArrayList<String> edades = new ArrayList<>();
        edades.add("Seleccione");
        for (int i = 18; i < 40; i++) {
            edades.add(String.valueOf(i));
        }
        ArrayAdapter adapter =
                new ArrayAdapter(
                        MainActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        edades
                );
        edad.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        ListadoActivity.class
                );
                startActivity(intent);
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obtener los datos los datos de los componentes
                String valorUsuario = usuario.getText().toString();
                String valorNombre = nombre.getText().toString();
                String valorApellido = apellido.getText().toString();
                String valorGenero = masculino.isChecked() ?
                        "Masculino" : (femenino.isChecked() ?
                        "Femenino" : "");
                /*
                String valor = "";
                if (masculino.isChecked()) {
                    valor = "Masculino";
                } else if (femenino.isChecked()) {
                    valor = "Femenino";
                }
                */
                String valorEdad = edad.getSelectedItem().toString();

                //Agregarlos a un objeto de tipo usuario
                Usuario obj = new Usuario(
                        valorUsuario,
                        valorNombre,
                        valorApellido,
                        valorGenero,
                        Integer.parseInt(valorEdad)
                );

                //Agregarlo a la lista
                lista.add(obj);
                Toast.makeText(MainActivity.this,
                        "Se guardo el usuario",
                        Toast.LENGTH_SHORT).show();

                //Limpiar datos
                usuario.setText("");
                nombre.setText("");
                apellido.setText("");
                masculino.setChecked(false);
                femenino.setChecked(false);
                edad.setSelection(0);
                usuario.requestFocus();

            }
        });
    }
}
