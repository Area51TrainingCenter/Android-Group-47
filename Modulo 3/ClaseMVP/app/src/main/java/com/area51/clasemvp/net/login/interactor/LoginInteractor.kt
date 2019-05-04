package com.area51.clasemvp.net.login.interactor

import com.area51.clasemvp.net.database.MetodoRealmImpl
import com.area51.clasemvp.net.entidad.Usuario
import com.area51.clasemvp.net.login.callback.LoginCallback
import com.area51.clasemvp.net.ws.MetodoWS
import com.area51.clasemvp.net.ws.response.login.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteractor {
    fun validarUsuario(
        usuario: String,
        contrasena: String,
        callback: LoginCallback
    ) {

        val call = MetodoWS.crear().login(usuario, contrasena)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                //johannjara    123456
                val respuesta = response.body()
                if (respuesta!!.status) {
                    //Adicionar llamado a base de datos interna

                    val obj = respuesta.rpta[0]

                    val objRespuesta = Usuario()
                    objRespuesta.nombre = obj.nombre
                    objRespuesta.apellido = obj.apellido

                    callback.onSuccess(objRespuesta)
                } else {
                    callback.onFailure()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                callback.onFailure()
            }
        })
/*
        val realm = MetodoRealmImpl()
        val respuesta = realm.validarUsuario(usuario, contrasena)
        if (respuesta == null) {
            callback.onFailure()
        } else {
            callback.onSuccess(respuesta)
        }*/
    }
}