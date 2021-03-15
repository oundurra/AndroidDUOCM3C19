package com.example.clase19;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ConexionHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME="usuario";
    public static final String COLUMN_NOMBRE="nombre";
    public static final String COLUMN_APELLIDO="apellido";
    public static final String COLUMN_EDAD="edad";
    public static final String COLUMN_SEXO="sexo";

    public ConexionHelper(Context context) {
        super(context, "dbUsuario2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario ("+
                "nombre varchar(100)" +
                ",apellido varchar(100)"+
                ",edad int"+
                ",sexo varchar(1))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
