package com.area51.clasemapa;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.area51.clasemapa.realm.Ubicacion;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etDireccion, etLatitud, etLongitud;
    private Button btnGuardar, btnMostrar, btnBuscar;
    private SimpleDraweeView sdvImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDireccion = findViewById(R.id.etDireccion);
        etLatitud = findViewById(R.id.etLatitud);
        etLongitud = findViewById(R.id.etLongiud);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnBuscar = findViewById(R.id.btnBuscar);
        sdvImagen = findViewById(R.id.sdvImagen);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String direccion = etDireccion.getText().toString();

                Geocoder geocoder = new Geocoder(MainActivity.this);
                try {
                    List<Address> addresses = geocoder
                            .getFromLocationName(direccion, 1);
                    if (addresses != null &&
                            addresses.size() > 0) {
                        etLatitud.setText(String.valueOf(addresses.get(0).getLatitude()));
                        etLongitud.setText(String.valueOf(addresses.get(0).getLongitude()));

                        sdvImagen.setImageURI(Uri.parse(
                                "https://maps.googleapis.com/maps/api/staticmap?" +
                                        "center=" + addresses.get(0).getLatitude() +
                                        "," + addresses.get(0).getLongitude() +
                                        "&zoom=12&size=400x400&key=AIzaSyCoTqStVbCnqkliNPmoKgFYcA_ifspesdY"
                        ));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String direccion = etDireccion.getText().toString();
                String latitud = etLatitud.getText().toString();
                String longitud = etLongitud.getText().toString();

                Ubicacion ubicacion = new Ubicacion();
                ubicacion.setLatitud(Double.parseDouble(latitud));
                ubicacion.setLongitud(Double.parseDouble(longitud));
                ubicacion.setDireccion(direccion);

                MetodoRealm realm = new MetodoRealmImpl();
                Ubicacion respuesta = realm.registrar(ubicacion);
                if (respuesta != null) {
                    Toast.makeText(MainActivity.this,
                            "Se registro", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Ocurrio un error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
