package com.area51.clase05;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListarFragment extends Fragment {
    private ListView lvLista;
    private PersonaAdapter adapter;

    public ListarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar, container, false);

        lvLista = view.findViewById(R.id.lvLista);

        adapter = new PersonaAdapter(getContext(), AndroidApplication.lista);
        lvLista.setAdapter(adapter);

        return view;
    }

}
