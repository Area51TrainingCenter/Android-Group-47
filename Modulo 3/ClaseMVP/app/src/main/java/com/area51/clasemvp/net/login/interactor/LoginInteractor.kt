package com.area51.clasemvp.net.login.interactor

import com.area51.clasemvp.net.database.MetodoRealmImpl
import com.area51.clasemvp.net.login.callback.LoginCallback

class LoginInteractor {
    fun validarUsuario(usuario: String,
                       contrasena: String,
                       callback: LoginCallback) {
        val realm = MetodoRealmImpl()
        val respuesta = realm.validarUsuario(usuario, contrasena)
        if (respuesta == null) {
            callback.onFailure()
        } else {
            callback.onSuccess(respuesta)
        }
    }
}