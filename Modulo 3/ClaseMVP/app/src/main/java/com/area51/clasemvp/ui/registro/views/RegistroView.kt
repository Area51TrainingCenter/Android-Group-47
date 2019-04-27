package com.area51.clasemvp.ui.registro.views

import com.area51.clasemvp.net.entidad.Usuario

interface RegistroView {
    fun respuestaGuardarUsuario(status: Boolean, usuario: Usuario?)
}