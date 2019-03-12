package com.area51.clase04;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FotoDetalleAdapter adapter;
    private ImageView ivDerecha, ivIzquierda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        viewPager = findViewById(R.id.viewPager);
        ivDerecha = findViewById(R.id.ivDerecha);
        ivIzquierda = findViewById(R.id.ivIzquierda);

        ArrayList<Foto> lista =
                getIntent()
                        .getParcelableArrayListExtra("lista");

        adapter =
                new FotoDetalleAdapter(
                        getSupportFragmentManager(), lista);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(
                getIntent().getIntExtra("posicion", 0));
    }

    @Override
    protected void onResume() {
        super.onResume();

        ivIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        ivDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
    }
}
