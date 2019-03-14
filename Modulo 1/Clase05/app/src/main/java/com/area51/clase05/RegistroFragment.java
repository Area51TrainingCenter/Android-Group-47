package com.area51.clase05;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroFragment extends Fragment {
    private EditText etNombre, etApellido;
    private Spinner spGenero;
    private Button btnRegistrar;

    public RegistroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro,
                container, false);
        etNombre = view.findViewById(R.id.etNombre);
        etApellido = view.findViewById(R.id.etApellido);
        spGenero = view.findViewById(R.id.spGenero);
        btnRegistrar = view.findViewById(R.id.btnRegistrar);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String genero = spGenero.getSelectedItem().toString();

                AndroidApplication.lista.add(
                        new Persona(nombre, apellido, genero)
                );

                Toast.makeText(getActivity(),
                        "Se registro.", Toast.LENGTH_SHORT).show();

                etNombre.setText("");
                etApellido.setText("");
                spGenero.setSelection(0);
            }
        });
    }
}
