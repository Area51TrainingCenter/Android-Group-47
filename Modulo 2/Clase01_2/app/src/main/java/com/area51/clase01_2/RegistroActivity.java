package com.area51.clase01_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.area51.clase01_2.entidades.Producto;

public class RegistroActivity extends AppCompatActivity {
    private EditText etMarca, etModelo, etCantidad, etDescripcion;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etMarca = findViewById(R.id.etMarca);
        etModelo = findViewById(R.id.etModelo);
        etCantidad = findViewById(R.id.etCantidad);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setTag("");

        if (getIntent().hasExtra("item")) {
            Producto producto = getIntent().getParcelableExtra("item");
            etMarca.setText(producto.getMarca());
            etModelo.setText(producto.getModelo());
            etCantidad.setText(String.valueOf(producto.getCantidad()));
            etDescripcion.setText(producto.getDescripcion());
            btnGuardar.setTag(producto.getId());
            btnGuardar.setText("Modificar");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String marca = etMarca.getText().toString();
                String modelo = etModelo.getText().toString();
                String cantidad = etCantidad.getText().toString();
                String descripcion = etDescripcion.getText().toString();

                MetodoRealm metodoRealm = new MetodoRealm();

                Producto producto = new Producto();
                producto.setCantidad(Integer.parseInt(cantidad));
                producto.setDescripcion(descripcion);
                producto.setMarca(marca);
                producto.setModelo(modelo);

                String id = (String) btnGuardar.getTag();
                if (!id.equals("")) {
                    producto.setId(id);
                }

                Producto respuesta = metodoRealm.guardarEditar(producto);
                if (respuesta != null && respuesta.getId() != null) {
                    finish();
                    if (!id.equals("")) {
                        Toast.makeText(RegistroActivity.this,
                                "Se modifico", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegistroActivity.this,
                                "Se registro", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegistroActivity.this,
                            "Ocurrio un error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
