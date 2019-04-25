package com.area51.clasemvp.ui.login.views

import com.area51.clasemvp.net.entidad.Usuario

interface LoginView {
    fun irPantallaRegistro()
    fun respuestaValidarUsuario(status: Boolean, usuario: Usuario?)
}