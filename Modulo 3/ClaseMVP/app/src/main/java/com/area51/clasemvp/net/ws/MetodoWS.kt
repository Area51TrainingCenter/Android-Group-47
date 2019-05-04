package com.area51.clasemvp.net.ws

import com.area51.clasemvp.net.ws.response.listado.ListaUsuarioResponse
import com.area51.clasemvp.net.ws.response.login.LoginResponse
import com.area51.clasemvp.net.ws.response.registro.RegistroResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MetodoWS {

    @POST("listausuarios.php")
    @FormUrlEncoded
    fun listado(@Field("estado") estado: String): Call<ListaUsuarioResponse>

    @POST("insertarusuario.php")
    @FormUrlEncoded
    fun registrar(
        @Field("nom") nom: String,
        @Field("ape") ape: String,
        @Field("dni") dni: String,
        @Field("sexo") sexo: String,
        @Field("edad") edad: String,
        @Field("user") user: String,
        @Field("pass") pass: String
    ): Call<RegistroResponse>

    @POST("logincafe.php")
    @FormUrlEncoded
    fun login(
        @Field("usuario") usuario: String,
        @Field("pass") pass: String
    ): Call<LoginResponse>

    companion object Factory {
        fun crear(): MetodoWS {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://35.184.215.96:1200/Proyectocafe/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(MetodoWS::class.java)
        }
    }
}