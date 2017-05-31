package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lina Marcela on 23/05/2017.
 */

public class RegistroSQLLiteOpenHelper extends SQLiteOpenHelper {

    String sql1= "CREATE TABLE Registro(IdRegistro text, nombre text, apellido text, usuario text, contrasenia text, edad text, sexo texto)";

    public RegistroSQLLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Registro");
        db.execSQL(sql1);
    }
}
