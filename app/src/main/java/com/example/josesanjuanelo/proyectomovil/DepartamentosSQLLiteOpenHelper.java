package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jose Sanjuanelo on 21/05/2017.
 */

public class DepartamentosSQLLiteOpenHelper extends SQLiteOpenHelper {
    String sql1= "CREATE TABLE Ciudades(IdCiudades INTEGER PRIMARY KEY AUTOINCREMENT,foto text, nombreDep text, nombreCiu text)";

    public DepartamentosSQLLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Ciudades");
        db.execSQL(sql1);
    }
}
