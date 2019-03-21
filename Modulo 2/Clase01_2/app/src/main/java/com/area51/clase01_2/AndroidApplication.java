package com.area51.clase01_2;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration =
                new RealmConfiguration.Builder()
                        .schemaVersion(1)
                        .name("clase1")
                        .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
