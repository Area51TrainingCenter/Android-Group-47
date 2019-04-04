package com.area51.clasepost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText
            etNumDesc,
            etPass,
            etPrimerNombre,
            etSegundoNombre,
            etApellidoPaterno,
            etApellidoMaterno,
            etFecNac,
            etTelFijo,
            etTelCel,
            etEmailPrin,
            etDesDirec;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumDesc = findViewById(R.id.etNumeroDocumento);
        etPass = findViewById(R.id.etPass);
        etPrimerNombre = findViewById(R.id.etPrimerNombre);
        etSegundoNombre = findViewById(R.id.etSegundoNombre);
        etApellidoPaterno = findViewById(R.id.etApellidoPaterno);
        etApellidoMaterno = findViewById(R.id.etApellidoMaterno);
        etFecNac = findViewById(R.id.etFecNac);
        etTelFijo = findViewById(R.id.etTelefonoFijo);
        etTelCel = findViewById(R.id.etTelefonoCel);
        etEmailPrin = findViewById(R.id.etCorreo);
        etDesDirec = findViewById(R.id.etDesDire);
        btnRegistrar = findViewById(R.id.btnGuardar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numDocumento = etNumDesc.getText().toString();
                String contrasena = etPass.getText().toString();
                String primerNombre = etPrimerNombre.getText().toString();
                String segundoNombre = etSegundoNombre.getText().toString();
                String apellidoPaterno = etApellidoPaterno.getText().toString();
                String apellidoMaterno = etApellidoMaterno.getText().toString();
                String fecNac = etFecNac.getText().toString();
                String telFijo = etTelFijo.getText().toString();
                String telCel = etTelCel.getText().toString();
                String email = etEmailPrin.getText().toString();
                String direccion = etDesDirec.getText().toString();

                MetodoWS metodoWS =
                        Configuracion.obtenerConfiguracion().create(MetodoWS.class);
                Call<RegistroResponse> call = metodoWS.registrar(
                        "0",
                        "2",
                        numDocumento,
                        contrasena,
                        primerNombre,
                        segundoNombre,
                        apellidoPaterno,
                        apellidoMaterno,
                        "54",
                        fecNac,
                        telFijo,
                        telCel,
                        email,
                        direccion,
                        "1",
                        "127.0.0.1",
                        "I",
                        "PW"
                );
                call.enqueue(new Callback<RegistroResponse>() {
                    @Override
                    public void onResponse(Call<RegistroResponse> call, Response<RegistroResponse> response) {
                        RegistroResponse respuesta = response.body();
                        Toast.makeText(MainActivity.this,
                                respuesta.getDesRpta(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RegistroResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this,
                                "error " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
