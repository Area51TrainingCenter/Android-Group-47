package com.area51.clasemvp.net.registro.interactor

import com.area51.clasemvp.net.database.MetodoRealmImpl
import com.area51.clasemvp.net.entidad.Usuario
import com.area51.clasemvp.net.registro.callback.RegistroCallback

class RegistroInteractor {
    fun registrar(usuario: Usuario,
                  callback: RegistroCallback) {
        val sql = MetodoRealmImpl()
        val respuesta = sql.agregar(usuario)
        if (respuesta == null) {
            callback.onFailure()
        } else {
            callback.onSuccess(respuesta)
        }
    }
}