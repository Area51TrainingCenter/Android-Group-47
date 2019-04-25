package com.area51.clasemvp.net.login.callback

import com.area51.clasemvp.net.entidad.Usuario

interface LoginCallback {
    fun onFailure()
    fun onSuccess(respuesta: Usuario)

}