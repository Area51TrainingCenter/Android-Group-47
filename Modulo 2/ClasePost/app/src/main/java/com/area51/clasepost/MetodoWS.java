package com.area51.clasepost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MetodoWS {
    /*
        @POST("mantenimientoUsuario")
        Call<RegistroResponse> registrar(@Body RegistroResponse request);

        @POST("mantenimientoUsuario")
        @FormUrlEncoded
        Call<RegistroResponse> registrar(@Field("codpersona") String codpersona);
    */
    @POST("mantenimientoUsuario")
    Call<RegistroResponse> registrar(
            @Query("codpersona") String codpersona,
            @Query("tipodoc") String tipodoc,
            @Query("numdoc") String numdoc,
            @Query("pass") String pass,
            @Query("prinombre") String prinombre,
            @Query("segnombre") String segnombre,
            @Query("apepaterno") String apepaterno,
            @Query("apematerno") String apematerno,
            @Query("flgsexo") String flgsexo,
            @Query("fecnaci") String fecnaci,
            @Query("telfijo") String telfijo,
            @Query("telcel") String telcel,
            @Query("emailprin") String emailprin,
            @Query("desdire") String desdire,
            @Query("flgpubli") String flgpubli,
            @Query("maqip") String maqip,
            @Query("opcion") String opcion,
            @Query("origen") String origen);

    @GET("loginMovil")
    Call<LoginResponse> validarLogin(
            @Query("tipodoc") String tipodoc,
            @Query("username") String username,
            @Query("pass") String pass);

}
