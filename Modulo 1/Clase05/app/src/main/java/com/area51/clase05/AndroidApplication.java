package com.area51.clase05;

import android.app.Application;

import java.util.ArrayList;

public class AndroidApplication extends Application {
    public static ArrayList<Persona> lista = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
