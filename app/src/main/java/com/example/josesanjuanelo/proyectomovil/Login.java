package com.example.josesanjuanelo.proyectomovil;

import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText cajaUsuario, cajaContrasenia;
    String user, pass;
    Resources res;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        res = this.getResources();
        cajaUsuario = (EditText)findViewById(R.id.txtUsuario);
        cajaContrasenia = (EditText)findViewById(R.id.txtContrasenia);

    }

    public void invocar(View v){
        String Usuario = cajaUsuario.getText().toString();
        String Contrasenia = cajaContrasenia.getText().toString();

        if(Usuario.equals("Admin") && Contrasenia.equals("Admin")){
            Intent i = new Intent(Login.this, Admin.class);
            startActivity(i);
        }else{
            validarBD(Usuario, Contrasenia);
            if(Usuario.equals(user) && Contrasenia.equals(pass)){

                Intent i = new Intent(Login.this, Principal.class);
                startActivity(i);
            }
        }

    }

    public void validarBD(String Usuario, String Contrasenia){
        try {
            buscarUsuario(Usuario);
        }catch (Exception e){
            cajaUsuario.setError(getResources().getString(R.string.error_10));
        }
        try {
            buscarContrasenia(Contrasenia);
        }catch (Exception e){
            cajaContrasenia.setError(getResources().getString(R.string.error_11));
        }
    }

    public void buscarUsuario(String usuario){
        Registro r;
        r = DatosRegistro.buscarUsuario(getApplicationContext(), usuario);
        if(r!=null) {
            user = r.getUsuario();
        }
    }

    public void buscarContrasenia (String contrasenia){
        Registro r;
        r = DatosRegistro.buscarContrasnia(getApplicationContext(), contrasenia);
        if(r!=null) {
            pass = r.getContrasenia();
        }
    }

    public void registrate(View v){
        Intent i = new Intent(Login.this, RegistroPersona.class);
        startActivity(i);
    }
}

