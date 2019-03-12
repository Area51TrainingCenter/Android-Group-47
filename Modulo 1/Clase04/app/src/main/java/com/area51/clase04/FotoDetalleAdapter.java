package com.area51.clase04;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FotoDetalleAdapter extends FragmentPagerAdapter {
    private ArrayList<Foto> lista;

    public FotoDetalleAdapter(FragmentManager fm, ArrayList<Foto> lista) {
        super(fm);
        this.lista = lista;
    }

    @Override
    public Fragment getItem(int position) {
        Foto foto = lista.get(position);

        FotoFragment fotoFragment = new FotoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("foto", foto);
        fotoFragment.setArguments(bundle);

        return fotoFragment;
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
