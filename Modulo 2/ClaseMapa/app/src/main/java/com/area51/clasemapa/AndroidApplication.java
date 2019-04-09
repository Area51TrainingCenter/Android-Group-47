package com.area51.clasemapa;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Creación de base de datos realm
        Realm.init(this);
        RealmConfiguration configuration =
                new RealmConfiguration.Builder()
                        .schemaVersion(1)
                        .name("clase_mapa.realm")
                        .build();
        Realm.setDefaultConfiguration(configuration);

        Fresco.initialize(this);
    }
}
