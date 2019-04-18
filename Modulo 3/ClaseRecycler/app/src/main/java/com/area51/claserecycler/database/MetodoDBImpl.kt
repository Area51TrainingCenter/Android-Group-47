package com.area51.claserecycler.database

import com.area51.claserecycler.entidades.Persona
import io.realm.Realm
import io.realm.RealmResults
import java.lang.Exception

class MetodoDBImpl : MetodoDB {
    override fun listar(): RealmResults<Persona>? {
        val realm = Realm.getDefaultInstance()
        return realm.where(Persona::class.java).findAll()
    }

    override fun registrar(item: Persona): Persona? {
        val realm = Realm.getDefaultInstance()
        var resultado: Persona? = null
        try {
            realm.beginTransaction()
            resultado = realm.copyToRealm(item)
            realm.commitTransaction()
        } catch (e: Exception) {
            realm.cancelTransaction()
        }
        return resultado
    }

}