package com.area51.clase03;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MetodoRealm {
    public Persona registrar(Persona dato) {
        Persona resultado = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            dato.setId(UUID.randomUUID().toString());
            resultado = realm.copyToRealm(dato);

            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return resultado;
    }

    public RealmResults<Persona> obtenerTodos() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Persona.class).findAll();
    }
}
