package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jose Sanjuanelo on 21/05/2017.
 */

public class AyudaSQLLiteOpenHelper extends SQLiteOpenHelper {

    String sql1= "CREATE TABLE Ayuda(IdVista text,abrigo real, bloqueador real, kit real, repelente real, total real)";

    public AyudaSQLLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Ayuda");
        db.execSQL(sql1);
    }
}
