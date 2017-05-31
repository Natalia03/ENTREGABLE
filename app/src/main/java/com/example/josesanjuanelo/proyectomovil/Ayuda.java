package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jose Sanjuanelo on 21/05/2017.
 */

public class Ayuda {
    private String Id;
    private double abrigo, bloqueador, kit, repelente, total;

    public Ayuda(String id, double abrigo, double bloqueador, double kit, double repelente, double total) {
        Id = id;
        this.abrigo = abrigo;
        this.bloqueador = bloqueador;
        this.kit = kit;
        this.repelente = repelente;
        this.total = total;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(double abrigo) {
        this.abrigo = abrigo;
    }

    public double getBloqueador() { return bloqueador; }

    public void setBloqueador(double bloqueador) {
        this.bloqueador = bloqueador;
    }

    public double getKit() {
        return kit;
    }

    public void setKit(double kit) {
        this.kit = kit;
    }

    public double getRepelente() {
        return repelente;
    }

    public void setRepelente(double repelente) {
        this.repelente = repelente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql1;

        AyudaSQLLiteOpenHelper aux = new AyudaSQLLiteOpenHelper(contexto, "DBAyuda", null, 2);
        db = aux.getWritableDatabase();

        sql1 = "INSERT INTO Ayuda values('"+this.getId()+"','"+this.getAbrigo()+"','"+this.getBloqueador()+"','"+this.getKit()+"','"+this.getRepelente()+"','"+this.getTotal()+"')";
        db.execSQL(sql1);
    }

    public void modificar(Context contexto){
        SQLiteDatabase db;
        String sql;

       AyudaSQLLiteOpenHelper aux = new AyudaSQLLiteOpenHelper(contexto, "DBAyuda", null, 2);
        db = aux.getWritableDatabase();

        //FORMA 1

        sql = "UPDATE Ayuda set abrigo='"+this.getAbrigo()+"', bloqueador='"+this.getBloqueador()+"', kit='"+this.getKit()+"', repelente='"+this.getRepelente()+"', total='"+this.getTotal()+"'where IdVista like '%"+this.getId()+"%'";
        db.execSQL(sql);
    }
}
