package com.area51.claserecycler.entidades

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class PersonaEntidad : RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var nombre: String? = null
    var apellido: String? = null
    var genero: String? = null
}