package com.area51.clase02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario;
    private Button btnIniciar;
    private TextView tvRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        btnIniciar = findViewById(R.id.btnIniciar);
        tvRegistrar = findViewById(R.id.tvRegistrar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_eliminar:

                SharedPreferences.Editor editor =
                        getSharedPreferences("clase02", MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();

                Toast.makeText(this,
                        "se elimino los datos", Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valorUsuario = etUsuario.getText().toString();

                SharedPreferences preferences =
                        getSharedPreferences("clase02", MODE_PRIVATE);
                if (preferences.contains("usuario") &&
                        preferences.contains("nombre")) {

                    String usuario = preferences.getString("usuario", "");
                    if (usuario.equals(valorUsuario)) {
                        String nombre = preferences.getString("nombre", "");

                        Toast.makeText(MainActivity.this,
                                nombre, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this,
                                "Usuario no existe", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this,
                            "Usuario no existe", Toast.LENGTH_SHORT).show();
                }

            }
        });
        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        MainActivity.this, RegistroActivity.class);
                startActivity(intent);

            }
        });
    }
}
