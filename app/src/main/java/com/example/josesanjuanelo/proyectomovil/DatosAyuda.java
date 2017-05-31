package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Jose Sanjuanelo on 21/05/2017.
 */

public class DatosAyuda {

    public static ArrayList<Ayuda> traerAyuda (Context contexto){
        SQLiteDatabase db;
        String sql1, idVista ;
        double abrigo, bloqueador, kit, repelente, total;
        ArrayList<Ayuda> ayudados = new ArrayList<>();
        AyudaSQLLiteOpenHelper aux = new AyudaSQLLiteOpenHelper(contexto, "DBAyuda", null, 2);
        db = aux.getReadableDatabase();

        sql1 = "Select * from Ayuda";
        Cursor c = db.rawQuery(sql1, null);

        if (c.moveToFirst()){
            do{
                idVista = c.getString(0);
                abrigo = Double.parseDouble(c.getString(1));
                bloqueador = Double.parseDouble(c.getString(2));
                kit = Double.parseDouble(c.getString(3));
                repelente = Double.parseDouble(c.getString(4));
                total = Double.parseDouble(c.getString(5));

                Ayuda a = new Ayuda(idVista, abrigo, bloqueador, kit, repelente, total);
                ayudados.add(a);
            }while (c.moveToNext());
        } db.close();
        return  ayudados;
    }

    public static Ayuda buscar(Context contexto, String idPuntos){
        SQLiteDatabase db;
        String sql, nombre="";
        Double total, abrigo, bloqueador, kit, repelente;
        Ayuda a=null;

        AyudaSQLLiteOpenHelper aux = new AyudaSQLLiteOpenHelper(contexto, "DBAyuda", null,2);
        db = aux.getReadableDatabase();

        //cursor

        sql = "Select * from Ayuda where idVista='"+idPuntos+"'";

        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst())


        nombre = c.getString(0);
        abrigo = Double.parseDouble(c.getString(1));
        bloqueador = Double.parseDouble(c.getString(2));
        kit = Double.parseDouble(c.getString(3));
        repelente = Double.parseDouble(c.getString(4));
        total = Double.parseDouble(c.getString(5));


            a = new Ayuda(nombre, abrigo, bloqueador, kit, repelente, total);

        db.close();

        return a;
    }

}
