package com.area51.clasemvp.net.registro.callback

import com.area51.clasemvp.net.entidad.Usuario

interface RegistroCallback {
    fun onFailure()
    fun onSuccess(respuesta: Usuario)

}