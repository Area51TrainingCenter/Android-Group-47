package com.area51.clase03;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Persona> lista;
    private Context context;

    public PersonaAdapter(ArrayList<Persona> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    class PersonaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;
        TextView tvApellido;
        TextView tvGenero;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellido);
            tvGenero = itemView.findViewById(R.id.tvGenero);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_persona, viewGroup, false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        PersonaViewHolder personaViewHolder = (PersonaViewHolder) viewHolder;

        Persona persona = lista.get(i);
        personaViewHolder.tvNombre.setText(persona.getNombre());
        personaViewHolder.tvGenero.setText(persona.getGenero());
        personaViewHolder.tvApellido.setText(persona.getApellido());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
