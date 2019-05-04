package com.area51.clasemvp.net.login.interactor;

import com.area51.clasemvp.net.database.MetodoRealm;
import com.area51.clasemvp.net.database.MetodoRealmImpl;
import com.area51.clasemvp.net.entidad.Usuario;
import com.area51.clasemvp.net.login.callback.LoginCallback;
import com.area51.clasemvp.net.ws.MetodoWS;
import com.area51.clasemvp.net.ws.response.login.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor2 {
    public void validarUsuario(String usuario,
                               String contrasena,
                               LoginCallback callback) {

        Call<LoginResponse> call=MetodoWS.Factory.crear().login("","");
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

        MetodoRealm realm = new MetodoRealmImpl();
        Usuario respuesta = realm.validarUsuario(usuario, contrasena);
        if (respuesta == null) {
            callback.onFailure();
        } else {
            callback.onSuccess(respuesta);
        }
    }
}
