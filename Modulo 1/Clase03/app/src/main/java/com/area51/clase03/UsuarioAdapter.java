package com.area51.clase03;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_usuario,
                        parent, false);

        TextView usuario, nombreCompleto, edad;
        ImageView imagen;
        LinearLayout contenedor;

        usuario = convertView.findViewById(R.id.tvUsuario);
        nombreCompleto = convertView.findViewById(R.id.tvNombreCompleto);
        edad = convertView.findViewById(R.id.tvEdad);
        imagen = convertView.findViewById(R.id.ivImagen);
        contenedor = convertView.findViewById(R.id.contenedor);

        final Usuario obj = (Usuario) getItem(position);
        usuario.setText(obj.getUsuario());
        nombreCompleto.setText(obj.getNombre() + " " + obj.getApellido());
        edad.setText(String.valueOf(obj.getEdad()));
        if (obj.getGenero().equals("Masculino")) {
            imagen.setImageResource(R.drawable.ic_launcher_background);
        } else {
            imagen.setImageResource(R.mipmap.ic_launcher);
        }
        contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(context);
                builder.setTitle("Opciones");
                builder.setMessage("Seleccione Uno");
                builder.setPositiveButton("Modificar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

                                Intent intent = new Intent(
                                        context, MainActivity.class);
                                intent.putExtra("item", obj);
                                intent.putExtra("position", position);
                                context.startActivity(intent);

                            }
                        });
                builder.setNegativeButton("Eliminar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface,
                                                int i) {

                                lista.remove(obj);
                                notifyDataSetChanged();

                            }
                        });
                builder.show();
            }
        });

        return convertView;
    }
}
