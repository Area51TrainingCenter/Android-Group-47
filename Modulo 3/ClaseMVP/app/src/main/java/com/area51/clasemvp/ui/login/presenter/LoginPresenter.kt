package com.area51.clasemvp.ui.login.presenter

import com.area51.clasemvp.net.entidad.Usuario
import com.area51.clasemvp.net.login.callback.LoginCallback
import com.area51.clasemvp.net.login.interactor.LoginInteractor
import com.area51.clasemvp.net.login.interactor.LoginInteractor2
import com.area51.clasemvp.ui.Presenter
import com.area51.clasemvp.ui.login.views.LoginView

class LoginPresenter : Presenter<LoginView>, LoginCallback {
    override fun onFailure() {
        view!!.respuestaValidarUsuario(false, null)
    }

    override fun onSuccess(respuesta: Usuario) {
        view!!.respuestaValidarUsuario(true, respuesta)
    }

    var view: LoginView? = null
    var interactor: LoginInteractor? = null

    override fun agregarView(view: LoginView) {
        this.view = view
        interactor = LoginInteractor()
    }

    override fun eliminarView() {
        this.view = null
    }

    fun irARegistro() {
        view!!.irPantallaRegistro()
    }

    fun validarUsuario(usuario: String, contrasena: String) {
        if (usuario.isEmpty()) {
            view!!.respuestaValidarUsuario(false, null)
            return
        }
        interactor!!.validarUsuario(usuario, contrasena, this)
    }

}