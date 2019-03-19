package com.area51.clase07.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.area51.clase07.R;
import com.area51.clase07.RegistroActivity;
import com.area51.clase07.Usuario;
import com.area51.clase07.adapters.UsuarioAdapter;
import com.area51.clase07.sqlite.MetodoSQLite;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuarioFragment extends Fragment {
    private ListView lvLista;
    private UsuarioAdapter adapter;
    private FloatingActionButton fab;

    public UsuarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usuario, container, false);

        lvLista = view.findViewById(R.id.lvLista);
        fab = view.findViewById(R.id.fab);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        MetodoSQLite sqLite = new MetodoSQLite(getContext());
        ArrayList<Usuario> lista = sqLite.obtenerUsuarios();
        adapter = new UsuarioAdapter(lista, getActivity());
        lvLista.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
