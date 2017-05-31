package com.example.josesanjuanelo.proyectomovil;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class Admin extends AppCompatActivity {

    TabHost th;
    Resources res;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        res = this.getResources();
        th = (TabHost)findViewById(R.id.tabhAdmin);
        th.setup();
        TabHost.TabSpec ts1=th.newTabSpec("Tab1");
        ts1.setIndicator(res.getString(R.string.thinciudad));
        ts1.setContent(R.id.tab1);

        th.addTab(ts1);

        th.setup();
        TabHost.TabSpec ts2=th.newTabSpec("Tab2");
        ts2.setIndicator(res.getString(R.string.thbhAyuda));
        ts2.setContent(R.id.tab2);

        th.addTab(ts2);

        th.setup();
        TabHost.TabSpec ts3=th.newTabSpec("Tab3");
        ts3.setIndicator(res.getString(R.string.tbhUsuarios));
        ts3.setContent(R.id.tab3);

        th.addTab(ts3);
    }

    public  void mostrarRegistro1(View v){
        Intent i = new Intent(Admin.this, RegistroCiudades.class);
        startActivity(i);
    }
    public  void mostrarListado1(View v){
        Intent i = new Intent(Admin.this, ListarCiudad.class);
        startActivity(i);
    }
    public  void mostrarListadoPuntos(View v){
        Intent i = new Intent(Admin.this, ListarPuntos.class);
        startActivity(i);
    }
    public  void mostrarRegistroPuntos(View v){
        Intent i = new Intent(Admin.this, RegistrarPuntuacion.class);
        startActivity(i);
    }
    public  void mostrarRegistroChec(View v){
        Intent i = new Intent(Admin.this, registrarAyuda.class);
        startActivity(i);
    }
    public  void mostrarListadoChec(View v){
        Intent i = new Intent(Admin.this, ListarAyuda.class);
        startActivity(i);
    }
    public  void mostrarLogin(View v){
        Intent i = new Intent(Admin.this, Login.class);
        startActivity(i);
    }
    public  void ListarUsuarioLogin(View v){
        Intent i = new Intent(Admin.this, ListarUsuarios.class);
        startActivity(i);
    }
    public  void mostrarRegistroLogin(View v){
        Intent i = new Intent(Admin.this, RegistroPersona.class);
        startActivity(i);
    }
}
