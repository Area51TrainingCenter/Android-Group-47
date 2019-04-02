package com.area51.clasews;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class FotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Foto> lista;
    private Context context;

    public FotoAdapter(ArrayList<Foto> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    class FotoViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdvImagen;
        TextView tvTitulo;

        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);
            sdvImagen = itemView.findViewById(R.id.sdvImagen);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_foto, viewGroup, false);
        return new FotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        FotoViewHolder fotoViewHolder = (FotoViewHolder) viewHolder;

        Foto foto = lista.get(i);

        fotoViewHolder.sdvImagen.setImageURI(Uri.parse(foto.getThumbnailUrl()));
        fotoViewHolder.tvTitulo.setText(foto.getTitle());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
