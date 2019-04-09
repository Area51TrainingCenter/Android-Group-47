package com.area51.clasemapa;

import com.area51.clasemapa.realm.Ubicacion;

import io.realm.RealmResults;

public interface MetodoRealm {
    Ubicacion registrar(Ubicacion ubicacion);

    RealmResults<Ubicacion> obtener();
}
