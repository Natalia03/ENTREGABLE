package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Jose Sanjuanelo on 21/05/2017.
 */

public class DatosPuntacion {
    public static ArrayList<Puntuacion> traerPuntuaciones (Context contexto){
        SQLiteDatabase db;
        String sql1, id;
        double total, puntuacion;
        ArrayList<Puntuacion> puntuaciones = new ArrayList<>();
        PuntuacionSQLLiteOpenHelper aux = new PuntuacionSQLLiteOpenHelper(contexto, "DBPuntos", null, 3);
        db = aux.getReadableDatabase();

        sql1 = "Select * from Puntuaciones";
        Cursor c = db.rawQuery(sql1, null);

        if (c.moveToFirst()){
            do{
                id = c.getString(0);
                puntuacion = Double.parseDouble(c.getString(1));
                total = Double.parseDouble(c.getString(2));

                Puntuacion n = new Puntuacion(id, puntuacion, total);
                puntuaciones.add(n);
            }while (c.moveToNext());
        } db.close();
        return  puntuaciones;
    }

    public static Puntuacion buscar(Context contexto, String idPuntos){
        SQLiteDatabase db;
        String sql, nombre="";
        Double total, punto;
        int edad;
        Puntuacion p=null;

        PuntuacionSQLLiteOpenHelper aux = new PuntuacionSQLLiteOpenHelper(contexto, "DBPuntos", null,3);
        db = aux.getReadableDatabase();

        //cursor

        sql = "Select * from Puntuaciones where idPuntuacion='"+idPuntos+"'";

        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst())

            nombre = c.getString(0);
            punto = Double.parseDouble(c.getString(1));
            total = Double.parseDouble(c.getString(2));


        p = new Puntuacion(nombre, punto, total);

        db.close();

        return p;
    }
}
