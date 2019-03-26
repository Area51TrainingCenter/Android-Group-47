package com.area51.clase03;

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
                        .name("clase03")
                        .schemaVersion(1)
                        .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
