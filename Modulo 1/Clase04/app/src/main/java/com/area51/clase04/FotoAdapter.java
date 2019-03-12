package com.area51.clase04;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class FotoAdapter extends ArrayAdapter {
    private ArrayList<Foto> lista;
    private Context context;

    public FotoAdapter(@NonNull Context context,
                       int resource, @NonNull ArrayList<Foto> objects) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_foto, parent, false);

        SimpleDraweeView sdvImagen =
                convertView.findViewById(R.id.sdvImagen);
        TextView tvNombre =
                convertView.findViewById(R.id.tvNombre);
        FrameLayout contenedor =
                convertView.findViewById(R.id.contenedor);

        Foto foto = (Foto) getItem(position);
        sdvImagen.setImageURI(Uri.parse(foto.getUrlFoto()));
        tvNombre.setText(foto.getNombre());
        contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        context, DetalleActivity.class
                );
                intent.putExtra("lista", lista);
                intent.putExtra("posicion", position);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
