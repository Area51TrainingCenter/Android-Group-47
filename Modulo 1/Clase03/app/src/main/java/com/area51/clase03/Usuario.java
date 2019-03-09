package com.area51.clase03;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private String usuario,nombre,apellido,genero;
    private int edad;

    public Usuario(String usuario, String nombre, String apellido, String genero, int edad) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
    }

    public String getUsuario() {

        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.usuario);
        dest.writeString(this.nombre);
        dest.writeString(this.apellido);
        dest.writeString(this.genero);
        dest.writeInt(this.edad);
    }

    protected Usuario(Parcel in) {
        this.usuario = in.readString();
        this.nombre = in.readString();
        this.apellido = in.readString();
        this.genero = in.readString();
        this.edad = in.readInt();
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}
