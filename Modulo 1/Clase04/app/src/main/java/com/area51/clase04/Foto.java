package com.area51.clase04;

import android.os.Parcel;
import android.os.Parcelable;

public class Foto implements Parcelable {
    private String nombre;
    private String urlFoto;

    public Foto(String nombre, String urlFoto) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.urlFoto);
    }

    protected Foto(Parcel in) {
        this.nombre = in.readString();
        this.urlFoto = in.readString();
    }

    public static final Parcelable.Creator<Foto> CREATOR = new Parcelable.Creator<Foto>() {
        @Override
        public Foto createFromParcel(Parcel source) {
            return new Foto(source);
        }

        @Override
        public Foto[] newArray(int size) {
            return new Foto[size];
        }
    };
}
