package com.area51.clasemvp.net.login.interactor;

import com.area51.clasemvp.net.database.MetodoRealm;
import com.area51.clasemvp.net.database.MetodoRealmImpl;
import com.area51.clasemvp.net.entidad.Usuario;
import com.area51.clasemvp.net.login.callback.LoginCallback;

public class LoginInteractor2 {
    public void validarUsuario(String usuario,
                               String contrasena,
                               LoginCallback callback) {
        MetodoRealm realm = new MetodoRealmImpl();
        Usuario respuesta = realm.validarUsuario(usuario, contrasena);
        if (respuesta == null) {
            callback.onFailure();
        } else {
            callback.onSuccess(respuesta);
        }
    }
}
