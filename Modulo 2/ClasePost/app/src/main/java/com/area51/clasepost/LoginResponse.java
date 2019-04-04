package com.area51.clasepost;

import java.util.ArrayList;

public class LoginResponse {
    private String nomServ;
    private int codRpta;
    private String desRpta;
    private ArrayList<UsuarioResponse> dataResulUsuLogin;

    public String getNomServ() {
        return nomServ;
    }

    public void setNomServ(String nomServ) {
        this.nomServ = nomServ;
    }

    public int getCodRpta() {
        return codRpta;
    }

    public void setCodRpta(int codRpta) {
        this.codRpta = codRpta;
    }

    public String getDesRpta() {
        return desRpta;
    }

    public void setDesRpta(String desRpta) {
        this.desRpta = desRpta;
    }

    public ArrayList<UsuarioResponse> getDataResulUsuLogin() {
        return dataResulUsuLogin;
    }

    public void setDataResulUsuLogin(ArrayList<UsuarioResponse> dataResulUsuLogin) {
        this.dataResulUsuLogin = dataResulUsuLogin;
    }
}
