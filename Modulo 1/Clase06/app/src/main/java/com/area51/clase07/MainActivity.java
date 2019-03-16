package com.area51.clase07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.area51.clase07.sqlite.MetodoSQLite;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etContrasenia;
    private Button btnIniciar;
    private TextView tvRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etContrasenia = findViewById(R.id.etContrasena);
        btnIniciar = findViewById(R.id.btnIniciar);
        tvRegistrar = findViewById(R.id.tvRegistrar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String contrasenia = etContrasenia.getText().toString();

                MetodoSQLite sqLite = new MetodoSQLite(MainActivity.this);
                Usuario datos = sqLite.validarUsuario(usuario, contrasenia);
                if (datos == null) {
                    Toast.makeText(MainActivity.this,
                            "Usuario y/o contraseña incorrectos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(
                            MainActivity.this,
                            MenuActivity.class);
                    intent.putExtra("item", datos);
                    startActivity(intent);
                }
            }
        });

        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(MainActivity.this,
                                RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
