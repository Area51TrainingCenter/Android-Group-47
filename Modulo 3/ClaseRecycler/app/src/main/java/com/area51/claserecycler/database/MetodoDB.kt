package com.area51.claserecycler.database

import com.area51.claserecycler.entidades.Persona
import io.realm.RealmResults

interface MetodoDB {
    fun listar(): RealmResults<Persona>?
    fun registrar(item: Persona): Persona?
}