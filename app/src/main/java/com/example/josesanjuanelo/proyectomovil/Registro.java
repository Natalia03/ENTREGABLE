package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Lina Marcela on 23/05/2017.
 */

public class Registro {
    private String nombre, apellido, edad, sexo, usuario, contrasenia;
    private int id;

    public Registro(int id, String nombre, String apellido, String usuario, String contrasenia, String edad, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql1;

        RegistroSQLLiteOpenHelper aux = new RegistroSQLLiteOpenHelper(contexto, "DBRegistro", null, 2);
        db = aux.getWritableDatabase();

        sql1 = "INSERT INTO Registro values('"+this.getId()+"','"+this.getNombre()+"','"+this.getApellido()+"','"+this.getUsuario()+"','"+this.getContrasenia()+"','"+this.getEdad()+"','"+this.getSexo()+"')";
        db.execSQL(sql1);
    }

    public void modificar(Context contexto){
        SQLiteDatabase db;
        String sql;

        RegistroSQLLiteOpenHelper aux = new RegistroSQLLiteOpenHelper(contexto, "DBRegitro", null, 2);
        db = aux.getWritableDatabase();

        //FORMA 1

        sql = "UPDATE Ayuda set nombre='"+this.getNombre()+"', apellido='"+this.getApellido()+"', usuario='"+this.getUsuario()+"', contrasenia='"+this.getContrasenia()+"', edad='"+this.getEdad()+"', sexo='"+this.getSexo()+"'where IdRegistro like '%"+this.getId()+"%'";
        db.execSQL(sql);
    }
}
