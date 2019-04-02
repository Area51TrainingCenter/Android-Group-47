package com.area51.clasews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvDatos);

        MetodoWS metodoWS =
                ConfiguracionRetrofit
                        .obtenerConfiguracion()
                        .create(MetodoWS.class);
        Call<ArrayList<Foto>> call =
                metodoWS.obtenerFotos();
        call.enqueue(new Callback<ArrayList<Foto>>() {
            @Override
            public void onResponse(Call<ArrayList<Foto>> call,
                                   Response<ArrayList<Foto>> response) {
                ArrayList<Foto> respuesta = response.body();

                FotoAdapter adapter = new FotoAdapter(respuesta, MainActivity.this);
                recyclerView.setLayoutManager(
                        new GridLayoutManager(
                                MainActivity.this, 2));
                recyclerView.setAdapter(adapter);


                /*for (Foto item : respuesta) {
                    Log.d("MainActivity", item.getTitle() +
                            " - " + item.getThumbnailUrl());
                }*/

            }

            @Override
            public void onFailure(Call<ArrayList<Foto>> call, Throwable t) {

            }
        });
    }
}
