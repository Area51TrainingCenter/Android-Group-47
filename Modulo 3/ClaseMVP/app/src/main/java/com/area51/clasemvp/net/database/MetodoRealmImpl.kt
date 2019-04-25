package com.area51.clasemvp.net.database

import com.area51.clasemvp.net.entidad.Usuario
import io.realm.Realm

class MetodoRealmImpl : MetodoRealm {
    override fun validarUsuario(usuario: String, contrasena: String): Usuario? {
        val realm = Realm.getDefaultInstance()
        return realm.where(Usuario::class.java)
                .equalTo("usuario", usuario)
                .equalTo("contrasena", contrasena)
                .findFirst()
    }
}