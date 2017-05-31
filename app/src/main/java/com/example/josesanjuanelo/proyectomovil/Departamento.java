package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Jose Sanjuanelo on 21/05/2017.
 */


public class Departamento {
    public static ArrayList<Ciudad> traerCiudades (Context contexto){
        SQLiteDatabase db;
        String sql1, foto, nombreDep, nombCiu;
        int id;
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        DepartamentosSQLLiteOpenHelper aux = new DepartamentosSQLLiteOpenHelper(contexto, "DBCiudades", null, 1);
        db = aux.getReadableDatabase();

        sql1 = "Select * from Ciudades";
        Cursor c = db.rawQuery(sql1, null);

        if (c.moveToFirst()){
            do{
                id = Integer.parseInt(c.getString(0));
                foto = c.getString(1);
                nombreDep = c.getString(2);
                nombCiu = c.getString(3);

                Ciudad n = new Ciudad(id, foto, nombreDep, nombCiu);
                ciudades.add(n);
            }while (c.moveToNext());
        } db.close();
        return  ciudades;
    }

    public static  Ciudad buscar(Context contexto, String nombreCiu){
        SQLiteDatabase db;
        String sql1, foto, nombreDep, nombrCiu;
        Ciudad n=null;

        DepartamentosSQLLiteOpenHelper aux = new DepartamentosSQLLiteOpenHelper(contexto, "DBCiudades", null, 1);
        db = aux.getReadableDatabase();

        sql1 = "Select * from Ciudades where nombreCiu='"+nombreCiu+"'";
        Cursor c = db.rawQuery(sql1, null);

        if(c.moveToFirst())
            foto = c.getString(1);
            nombreDep = c.getString(2);
            nombrCiu = c.getString(3);

            n = new Ciudad(nombreDep, nombrCiu);

        db.close();

        return  n;
    }
}
