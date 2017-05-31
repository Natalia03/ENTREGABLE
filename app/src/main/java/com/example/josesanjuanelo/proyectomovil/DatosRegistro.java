package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Lina Marcela on 23/05/2017.
 */

public class DatosRegistro {

    public static ArrayList<Registro> traerRegistro (Context contexto){
        SQLiteDatabase db;
        String sql1, nombre, apellido, usuario, contrasenia, edad, sexo;
        int idRegistro;
        ArrayList<Registro> registrados = new ArrayList<>();
        RegistroSQLLiteOpenHelper aux = new RegistroSQLLiteOpenHelper(contexto, "DBRegistro", null, 2);
        db = aux.getReadableDatabase();

        sql1 = "Select * from Registro";
        Cursor c = db.rawQuery(sql1, null);

        if (c.moveToFirst()){
            do{
                idRegistro = Integer.parseInt(c.getString(0));
                nombre = c.getString(1);
                apellido = c.getString(2);
                usuario = c.getString(3);
                contrasenia = c.getString(4);
                edad = c.getString(5);
                sexo = c.getString(6);

                Registro a = new Registro(idRegistro, nombre, apellido, usuario, contrasenia, edad, sexo);
                registrados.add(a);
            }while (c.moveToNext());
        } db.close();
        return  registrados;
    }

    public static Registro buscar(Context contexto, int idRegistro){
        SQLiteDatabase db;
        String sql, nombreB="", nombre, apellido, usuario, contrasenia, edad, sexo;;
        int idRegistro2=0;
        Registro a=null;

        RegistroSQLLiteOpenHelper aux = new RegistroSQLLiteOpenHelper(contexto, "DBRegistro", null,2);
        db = aux.getReadableDatabase();

        //cursor

        sql = "Select * from Registro where idRegistro='"+idRegistro+"'";

        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst())


            idRegistro2 = Integer.parseInt(c.getString(0));
        nombre = c.getString(1);
        apellido = c.getString(2);
        usuario = c.getString(3);
        contrasenia = c.getString(4);
        edad = c.getString(5);
        sexo = c.getString(6);


        a = new Registro(idRegistro2, nombre, apellido, usuario, contrasenia, edad, sexo);

        db.close();

        return a;
    }

    public static Registro buscarUsuario(Context contexto, String idRegistro){
        SQLiteDatabase db;
        String sql, nombreB="", nombre, apellido, usuario, contrasenia, edad, sexo;;
        int idRegistro2=0;
        Registro a=null;

        RegistroSQLLiteOpenHelper aux = new RegistroSQLLiteOpenHelper(contexto, "DBRegistro", null,2);
        db = aux.getReadableDatabase();

        //cursor

        sql = "Select * from Registro where usuario='"+idRegistro+"'";

        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst())


            idRegistro2 = Integer.parseInt(c.getString(0));
            nombre = c.getString(1);
            apellido = c.getString(2);
            usuario = c.getString(3);
            contrasenia = c.getString(4);
            edad = c.getString(5);
            sexo = c.getString(6);


        a = new Registro(idRegistro2, nombre, apellido, usuario, contrasenia, edad, sexo);

        db.close();

        return a;
    }

    public static Registro buscarContrasnia(Context contexto, String idRegistro){
        SQLiteDatabase db;
        String sql, nombreB="", nombre, apellido, usuario, contrasenia, edad, sexo;;
        int idRegistro2=0;
        Registro a=null;

        RegistroSQLLiteOpenHelper aux = new RegistroSQLLiteOpenHelper(contexto, "DBRegistro", null,2);
        db = aux.getReadableDatabase();

        //cursor

        sql = "Select * from Registro where contrasenia='"+idRegistro+"'";

        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst())


            idRegistro2 = Integer.parseInt(c.getString(0));
        nombre = c.getString(1);
        apellido = c.getString(2);
        usuario = c.getString(3);
        contrasenia = c.getString(4);
        edad = c.getString(5);
        sexo = c.getString(6);


        a = new Registro(idRegistro2, nombre, apellido, usuario, contrasenia, edad, sexo);

        db.close();

        return a;
    }
}
