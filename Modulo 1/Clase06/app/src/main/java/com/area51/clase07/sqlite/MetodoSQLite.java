package com.area51.clase07.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.area51.clase07.Usuario;

import java.util.ArrayList;

public class MetodoSQLite {
    private ManageOpenHelper conexion;

    public MetodoSQLite(Context context) {
        conexion = new ManageOpenHelper(
                context, "clase06.db", null, 1);
    }

    public long guardarUsuario(Usuario usuario) {
        SQLiteDatabase database = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("usuario", usuario.getUsuario());
        values.put("nombre", usuario.getNombre());
        values.put("apellido", usuario.getApellido());
        values.put("genero", usuario.getGenero());
        values.put("contrasenia", usuario.getContrasena());

        return database.insert("usuarios", null, values);
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        SQLiteDatabase database = conexion.getReadableDatabase();

        Cursor cursor = database.rawQuery(
                "select * from usuarios",
                null
        );
        ArrayList<Usuario> lista = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(
                        cursor.getInt(cursor.getColumnIndex("id"))
                );
                usuario.setNombre(
                        cursor.getString(cursor.getColumnIndex("nombre"))
                );
                usuario.setApellido(
                        cursor.getString(cursor.getColumnIndex("apellido"))
                );
                usuario.setGenero(
                        cursor.getString(cursor.getColumnIndex("genero"))
                );
                usuario.setUsuario(
                        cursor.getString(cursor.getColumnIndex("usuario"))
                );
                usuario.setContrasena(
                        cursor.getString(cursor.getColumnIndex("contrasenia"))
                );
                lista.add(usuario);
            } while (cursor.moveToNext());
        }
        return lista;
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {
        SQLiteDatabase database = conexion.getReadableDatabase();

        Cursor cursor = database.rawQuery(
                "select * from usuarios where usuario=? and contrasenia=?",
                new String[]{usuario, contrasenia}
        );
        Usuario respuesta = null;
        if (cursor.moveToFirst()) {
            do {
                respuesta = new Usuario();
                respuesta.setId(
                        cursor.getInt(cursor.getColumnIndex("id"))
                );
                respuesta.setNombre(
                        cursor.getString(cursor.getColumnIndex("nombre"))
                );
                respuesta.setApellido(
                        cursor.getString(cursor.getColumnIndex("apellido"))
                );
                respuesta.setGenero(
                        cursor.getString(cursor.getColumnIndex("genero"))
                );
                respuesta.setUsuario(
                        cursor.getString(cursor.getColumnIndex("usuario"))
                );
                respuesta.setContrasena(
                        cursor.getString(cursor.getColumnIndex("contrasenia"))
                );
            } while (cursor.moveToNext());
        }
        return respuesta;
    }
}
