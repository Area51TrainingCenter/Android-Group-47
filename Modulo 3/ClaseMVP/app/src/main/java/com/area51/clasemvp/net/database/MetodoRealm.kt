package com.area51.clasemvp.net.database

import com.area51.clasemvp.net.entidad.Usuario

interface MetodoRealm {
    fun validarUsuario(usuario: String, contrasena: String): Usuario?
}