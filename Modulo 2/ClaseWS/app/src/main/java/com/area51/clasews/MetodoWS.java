package com.area51.clasews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MetodoWS {
    @GET("photos")
    Call<ArrayList<Foto>> obtenerFotos();

    @POST("photos/{id}")
    @FormUrlEncoded
    Call<String> enviarDatos(@Field("nombre") String nombre,
                             @Query("apellido") String apellido,
                             @Path("id") String edad);
}