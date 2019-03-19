package com.area51.clase07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.clase07.sqlite.MetodoSQLite;

public class RegistroActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etNombre;
    private EditText etApellido;
    private EditText etContrasenia;
    private EditText etRepContrasenia;
    private Spinner spGenero;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUsuario = findViewById(R.id.etUsuario);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etContrasenia = findViewById(R.id.etContrasena);
        etRepContrasenia = findViewById(R.id.etRepContrasena);
        spGenero = findViewById(R.id.spGenero);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setTag(0);

        Usuario datos = getIntent().getParcelableExtra("item");
        if (datos != null) {
            etUsuario.setText(datos.getUsuario());
            etNombre.setText(datos.getNombre());
            etApellido.setText(datos.getApellido());
            if (datos.getGenero().equals("Masculino")) {
                spGenero.setSelection(0);
            } else {
                spGenero.setSelection(1);
            }
            btnGuardar.setText("Modificar");
            btnGuardar.setTag(datos.getId());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = etUsuario.getText().toString();
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String genero = spGenero.getSelectedItem().toString();
                String contrasenia = etContrasenia.getText().toString();
                String repContrasenia = etRepContrasenia.getText().toString();

                if (usuario.equals("")) {
                    etUsuario.setError("El campo es requerido");
                    return;
                } else {
                    etUsuario.setError(null);
                }
                if (nombre.equals("")) {
                    etNombre.setError("El campo es requerido");
                    return;
                } else {
                    etNombre.setError(null);
                }
                if (apellido.equals("")) {
                    etApellido.setError("El campo es requerido");
                    return;
                } else {
                    etApellido.setError(null);
                }
                if (contrasenia.equals("")) {
                    etContrasenia.setError("El campo es requerido");
                    return;
                } else {
                    etContrasenia.setError(null);
                }
                if (repContrasenia.equals("")) {
                    etRepContrasenia.setError("El campo es requerido");
                    return;
                } else {
                    etRepContrasenia.setError(null);
                }

                if (!contrasenia.equals(repContrasenia)) {
                    etContrasenia.setError("Contraseñas no coinciden");
                    return;
                } else {
                    etContrasenia.setError(null);
                }

                MetodoSQLite sqLite = new MetodoSQLite(RegistroActivity.this);
                Usuario obj = new Usuario();
                obj.setUsuario(usuario);
                obj.setNombre(nombre);
                obj.setApellido(apellido);
                obj.setGenero(genero);
                obj.setContrasena(contrasenia);
                if ((int) btnGuardar.getTag() > 0) {
                    obj.setId((int) btnGuardar.getTag());
                    sqLite.actualizar(obj);
                    Toast.makeText(RegistroActivity.this,
                            "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    long resultado = sqLite.guardarUsuario(obj);
                    if (resultado == 0) {
                        Toast.makeText(RegistroActivity.this,
                                "Ocurrio un error", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegistroActivity.this,
                                "Registro exitoso", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }

        });
    }
}
