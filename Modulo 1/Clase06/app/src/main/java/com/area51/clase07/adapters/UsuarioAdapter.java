package com.area51.clase07.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.area51.clase07.R;
import com.area51.clase07.RegistroActivity;
import com.area51.clase07.Usuario;
import com.area51.clase07.sqlite.MetodoSQLite;

import java.util.ArrayList;

public class UsuarioAdapter extends BaseAdapter {
    private ArrayList<Usuario> lista;
    private Context context;

    public UsuarioAdapter(ArrayList<Usuario> lista, Context context) {
        this.lista = lista;
        this.context = context;
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
                .inflate(R.layout.item_usuario, viewGroup, false);

        TextView tvUsuario = view.findViewById(R.id.tvUsuario);
        TextView tvNombre = view.findViewById(R.id.tvNombreCompleto);
        LinearLayout elemento = view.findViewById(R.id.elemento);

        final Usuario usuario = (Usuario) getItem(i);
        tvUsuario.setText(usuario.getUsuario());
        tvNombre.setText(usuario.getNombre() + " " + usuario.getApellido());

        elemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(context);
                builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(context, RegistroActivity.class);
                        intent.putExtra("item", usuario);
                        context.startActivity(intent);
                    }
                });
                builder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        MetodoSQLite sqLite = new MetodoSQLite(context);
                        sqLite.eliminar(usuario.getId());
                        lista.remove(usuario);
                        notifyDataSetChanged();
                    }
                });
                builder.show();

            }
        });

        return view;
    }
}
