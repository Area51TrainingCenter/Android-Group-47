package com.area51.clase03;

import android.app.Application;

import java.util.ArrayList;

public class AndroidApplication extends Application {
    public static ArrayList<Usuario> lista;

    @Override
    public void onCreate() {
        super.onCreate();

        lista = new ArrayList<>();
    }
}
