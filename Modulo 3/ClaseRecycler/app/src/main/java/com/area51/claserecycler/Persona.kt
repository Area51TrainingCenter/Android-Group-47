package com.area51.claserecycler

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Persona(
        var id:String,
        var nombre: String,
        var apellido: String,
        var genero: String
):Parcelable