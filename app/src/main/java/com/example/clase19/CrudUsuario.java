package com.example.clase19;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CrudUsuario {
    private ConexionHelper helper;
    private SQLiteDatabase db;
    private ContentValues values;
    private int prueba;


    public CrudUsuario(Context context) {
        values = new ContentValues();
        helper = new ConexionHelper(context);
    }

    public void insertarDatos(Usuario usuario) {
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.COLUMN_NOMBRE, usuario.getNombre());
        values.put(ConexionHelper.COLUMN_APELLIDO, usuario.getApellido());
        values.put(ConexionHelper.COLUMN_EDAD, usuario.getEdad());
        values.put(ConexionHelper.COLUMN_SEXO, usuario.getSexo());
        db.insert(ConexionHelper.TABLE_NAME, null, values);
        db.close();
    }

    public void modificarDatos(Usuario usuario) {
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.COLUMN_NOMBRE, usuario.getNombre());
        values.put(ConexionHelper.COLUMN_APELLIDO, usuario.getApellido());
        values.put(ConexionHelper.COLUMN_EDAD, usuario.getEdad());
        values.put(ConexionHelper.COLUMN_SEXO, usuario.getSexo());
        db.update(ConexionHelper.TABLE_NAME, values, "nombre=?", new String[]{String.valueOf(usuario.getNombre())});
        db.close();
    }

    public void eliminarDatos(Usuario usuario) {
        db = helper.getWritableDatabase();
        db.delete(ConexionHelper.TABLE_NAME,"nombre=?", new String[]{String.valueOf(usuario.getNombre())});
        db.close();
    }

    public ArrayList<Usuario> seleccionarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        db = helper.getReadableDatabase();
        Cursor c;
        c = db.rawQuery("select * from " + ConexionHelper.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                usuarios.add(new Usuario(c.getString(0), c.getString(1), c.getInt(2), c.getString(3)));
            } while(c.moveToNext());
        }

        db.close();
        return usuarios;
    }
}
