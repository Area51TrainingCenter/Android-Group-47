package com.area51.claserecycler.entidades

import io.realm.RealmObject
import java.util.*

open class Persona : RealmObject() {
    var id: String = UUID.randomUUID().toString()
    var nombre: String? = null
    var apellido: String? = null
    var genero: String? = null
}