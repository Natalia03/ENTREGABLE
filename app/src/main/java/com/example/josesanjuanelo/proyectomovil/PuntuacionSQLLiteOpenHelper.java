package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jose Sanjuanelo on 21/05/2017.
 */

public class PuntuacionSQLLiteOpenHelper extends SQLiteOpenHelper {
    String sql1= "CREATE TABLE Puntuaciones(IdPuntuacion text, puntuacion real, total real)";

    public PuntuacionSQLLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Puntuaciones");
        db.execSQL(sql1);
    }
}
