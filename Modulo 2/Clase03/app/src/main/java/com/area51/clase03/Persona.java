package com.area51.clase03;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Persona extends RealmObject {
    @PrimaryKey
    private String id;
    private String nombre, apellido, genero;

    public Persona() {
    }

    public Persona(String id, String nombre, String apellido, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Persona(String nombre, String apellido, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
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
}
