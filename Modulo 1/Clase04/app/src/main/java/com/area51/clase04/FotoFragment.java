package com.area51.clase04;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {
    private TextView tvNombre;
    private SimpleDraweeView sdvImagen;

    public FotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto, container, false);

        tvNombre = view.findViewById(R.id.tvNombre);
        sdvImagen = view.findViewById(R.id.sdvImagen);

        Bundle bundle = getArguments();
        Foto foto = bundle.getParcelable("foto");
        tvNombre.setText(foto.getNombre());
        sdvImagen.setImageURI(Uri.parse(foto.getUrlFoto()));

        return view;
    }

}
