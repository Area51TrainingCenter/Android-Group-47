
package com.area51.clasemvp.net.ws.response.listado;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rptum {

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido")
    @Expose
    private String apellido;
    @SerializedName("dni")
    @Expose
    private String dni;
    @SerializedName("sexo")
    @Expose
    private String sexo;
    @SerializedName("edad")
    @Expose
    private Integer edad;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("pass")
    @Expose
    private String pass;
    @SerializedName("estado")
    @Expose
    private String estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
