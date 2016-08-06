package com.example.monica.formulario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Base extends SQLiteOpenHelper {

    String sql="CREATE TABLE Cliente (Identificacion INTEGER, nombre TEXT, apellido TEXT, email TEXT)";

    public Base(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int sewVersion) {

        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL(sql);
    }
}
