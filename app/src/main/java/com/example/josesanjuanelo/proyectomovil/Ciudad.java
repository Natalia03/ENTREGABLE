package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.inputmethodservice.Keyboard;

import java.sql.RowId;

/**
 * Created by Jose Sanjuanelo on 21/05/2017.
 */

public class Ciudad {
    private  String foto;
    private String nombreDep, nombCiu;
    int numero;

    public Ciudad(int numero, String foto, String nombreDep, String nombCiu) {
        this.numero = numero;
        this.foto = foto;
        this.nombreDep = nombreDep;
        this.nombCiu = nombCiu;
    }

    public Ciudad(String nombreDep, String nombCiu) {
        this.nombreDep = nombreDep;
        this.nombCiu = nombCiu;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    public String getNombCiu() {
        return nombCiu;
    }

    public void setNombCiu(String nombCiu) {
        this.nombCiu = nombCiu;
    }

    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql1;

        DepartamentosSQLLiteOpenHelper aux = new DepartamentosSQLLiteOpenHelper(contexto, "DBCiudades", null, 1);
        db = aux.getWritableDatabase();

        sql1 = "INSERT INTO Ciudades values('"+this.getNumero()+"','"+this.getFoto()+"','"+this.getNombreDep()+"','"+this.getNombCiu()+"')";
        db.execSQL(sql1);
    }
}
