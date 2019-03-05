package com.area51.clase03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter(Context context, ArrayList<Usuario> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_usuario,
                        parent, false);

        TextView usuario, nombreCompleto, edad;
        ImageView imagen;

        usuario = convertView.findViewById(R.id.tvUsuario);
        nombreCompleto = convertView.findViewById(R.id.tvNombreCompleto);
        edad = convertView.findViewById(R.id.tvEdad);
        imagen = convertView.findViewById(R.id.ivImagen);

        Usuario obj = (Usuario) getItem(position);
        usuario.setText(obj.getUsuario());
        nombreCompleto.setText(obj.getNombre() + " " + obj.getApellido());
        edad.setText(String.valueOf(obj.getEdad()));
        if (obj.getGenero().equals("Masculino")) {
            imagen.setImageResource(R.drawable.ic_launcher_background);
        } else {
            imagen.setImageResource(R.drawable.ic_launcher_foreground);
        }

        return convertView;
    }
}
