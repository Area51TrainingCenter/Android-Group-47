package com.area51.clasemvp.ui.registro.presenter

import com.area51.clasemvp.net.entidad.Usuario
import com.area51.clasemvp.net.registro.callback.RegistroCallback
import com.area51.clasemvp.net.registro.interactor.RegistroInteractor
import com.area51.clasemvp.ui.Presenter
import com.area51.clasemvp.ui.registro.views.RegistroView

class RegistroPresenter : Presenter<RegistroView>, RegistroCallback {
    var view: RegistroView? = null
    var interactor: RegistroInteractor? = null

    override fun agregarView(view: RegistroView) {
        this.view = view
        interactor = RegistroInteractor()
    }

    override fun eliminarView() {
        view = null
    }

    override fun onFailure() {
        view!!.respuestaGuardarUsuario(false, null)
    }

    override fun onSuccess(respuesta: Usuario) {
        view!!.respuestaGuardarUsuario(true, respuesta)
    }

    fun registrarUsuario(usuario: String, nombre: String, apellido: String,
                         contrasena: String, repContrasena: String) {
        if (usuario.isEmpty()) {
            view!!.respuestaGuardarUsuario(false, null)
            return
        }

        val obj = Usuario()
        obj.usuario = usuario
        obj.nombre = nombre
        obj.apellido = apellido
        obj.contrasena = contrasena
        interactor!!.registrar(obj, this)
    }
}