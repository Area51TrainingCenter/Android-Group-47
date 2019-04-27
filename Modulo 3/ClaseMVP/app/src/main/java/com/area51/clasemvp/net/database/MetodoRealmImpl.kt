package com.area51.clasemvp.net.database

import com.area51.clasemvp.net.entidad.Usuario
import io.realm.Realm

class MetodoRealmImpl : MetodoRealm {
    override fun agregar(usuario: Usuario): Usuario? {
        val realm = Realm.getDefaultInstance()
        var respuesta: Usuario? = null
        try {
            realm.beginTransaction()

            respuesta = realm.copyToRealm(usuario)

            realm.commitTransaction()
        } catch (e: Exception) {
            realm.cancelTransaction()
        }
        return respuesta
    }

    override fun validarUsuario(usuario: String, contrasena: String): Usuario? {
        val realm = Realm.getDefaultInstance()
        return realm.where(Usuario::class.java)
                .equalTo("usuario", usuario)
                .equalTo("contrasena", contrasena)
                .findFirst()
    }
}