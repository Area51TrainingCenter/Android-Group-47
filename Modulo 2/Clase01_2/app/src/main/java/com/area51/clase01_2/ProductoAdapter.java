package com.area51.clase01_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.area51.clase01_2.entidades.Producto;

import java.util.ArrayList;

import io.realm.RealmResults;

public class ProductoAdapter extends BaseAdapter {
    private ArrayList<Producto> lista;
    private Context context;

    public ProductoAdapter(RealmResults<Producto> lista, Context context) {
        this.lista = new ArrayList<>();
        this.lista.addAll(lista);
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
        view = LayoutInflater.from(context).inflate(
                R.layout.item_producto, viewGroup, false
        );
        TextView tvModelo = view.findViewById(R.id.tvModelo);
        TextView tvMarca = view.findViewById(R.id.tvMarca);
        TextView tvCantidad = view.findViewById(R.id.tvCantidad);

        Producto producto = (Producto) getItem(i);
        tvModelo.setText(producto.getModelo());
        tvMarca.setText(producto.getMarca());
        tvCantidad.setText(String.valueOf(producto.getCantidad()));

        return view;
    }
}
