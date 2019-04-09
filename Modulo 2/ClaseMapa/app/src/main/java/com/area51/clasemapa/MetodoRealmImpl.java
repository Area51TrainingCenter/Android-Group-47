package com.area51.clasemapa;

import com.area51.clasemapa.realm.Ubicacion;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MetodoRealmImpl implements MetodoRealm {
    @Override
    public Ubicacion registrar(Ubicacion ubicacion) {
        Ubicacion resultado = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            ubicacion.setId(UUID.randomUUID().toString());
            resultado = realm.copyToRealm(ubicacion);

            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return resultado;
    }

    @Override
    public RealmResults<Ubicacion> obtener() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Ubicacion.class)
                .findAll();
    }
}
