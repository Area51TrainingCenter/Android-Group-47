package com.area51.clasemvp.net.entidad

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Usuario : RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var usuario: String? = null
    var nombre: String? = null
    var apellido: String? = null
    var contrasena: String? = null
}