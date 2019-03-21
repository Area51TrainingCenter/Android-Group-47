package com.area51.clase01_2;

import com.area51.clase01_2.entidades.Producto;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MetodoRealm {
    public Producto guardarEditar(Producto entidad) {
        Producto producto = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            if (entidad.getId() == null) {
                entidad.setId(UUID.randomUUID().toString());
            }
            producto = realm.copyToRealmOrUpdate(entidad);

            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return producto;
    }

    public RealmResults<Producto> listar(/*String marca*/) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Producto.class)
                //.equalTo("marca", marca)
                .findAll();
    }

    public void eliminar(String id) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            Producto producto = realm.where(Producto.class)
                    .equalTo("id", id)
                    .findFirst();
            if (producto != null) {
                producto.deleteFromRealm();
            }

            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }
}
