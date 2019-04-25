package com.area51.claserecycler.database

import com.area51.claserecycler.entidades.PersonaEntidad
import io.realm.Realm
import io.realm.RealmResults
import java.lang.Exception

class MetodoDBImpl : MetodoDB {
    override fun eliminar(id: String) {
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()

            val persona = realm.where(PersonaEntidad::class.java)
                .equalTo("id", id)
                .findFirst()
            if (persona != null) {
                persona.deleteFromRealm()
                realm.commitTransaction()
            }
        } catch (e: Exception) {
            realm.cancelTransaction()
        }
    }

    override fun listar(): RealmResults<PersonaEntidad>? {
        val realm = Realm.getDefaultInstance()
        return realm.where(PersonaEntidad::class.java).findAll()
    }

    override fun registrar(item: PersonaEntidad): PersonaEntidad? {
        val realm = Realm.getDefaultInstance()
        var resultado: PersonaEntidad? = null
        try {
            realm.beginTransaction()
            resultado = realm.copyToRealmOrUpdate(item)
            realm.commitTransaction()
        } catch (e: Exception) {
            realm.cancelTransaction()
        }
        return resultado
    }

}