package com.area51.claserecycler.database

import com.area51.claserecycler.entidades.PersonaEntidad
import io.realm.RealmResults

interface MetodoDB {
    fun listar(): RealmResults<PersonaEntidad>?
    fun registrar(item: PersonaEntidad): PersonaEntidad?
    fun eliminar(id: String)
}