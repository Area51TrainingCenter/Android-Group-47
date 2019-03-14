package com.area51.clase05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Persona> lista;

    public PersonaAdapter(Context context, ArrayList<Persona> lista) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context)
                .inflate(R.layout.item_persona, viewGroup, false);

        TextView tvNombre = view.findViewById(R.id.tvNombre);
        TextView tvApellido = view.findViewById(R.id.tvApellido);
        ImageView ivImagen = view.findViewById(R.id.ivImagen);

        Persona persona = (Persona) getItem(i);
        tvNombre.setText(persona.getNombre());
        tvApellido.setText(persona.getApellido());
        if (persona.getGenero().equals("Masculino"))
            ivImagen.setImageResource(R.drawable.ic_menu_camera);
        else
            ivImagen.setImageResource(R.drawable.ic_menu_gallery);

        return view;
    }
}
