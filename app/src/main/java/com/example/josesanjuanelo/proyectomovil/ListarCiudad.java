package com.example.josesanjuanelo.proyectomovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarCiudad extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Ciudad> ciudades;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ciudad);

        lista = (ListView)findViewById(R.id.lvOpcCiudades);
        ciudades = Departamento.traerCiudades(getApplicationContext());

        AdaptadorCiudad adapter = new AdaptadorCiudad(this, ciudades);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(ListarCiudad.this, Aracataca.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(ListarCiudad.this, Tayrona.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(ListarCiudad.this, Valledupar.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(ListarCiudad.this, Popayan.class);
                        startActivity(i);
                        break;
                    case 4:
                        i = new Intent(ListarCiudad.this, Guatape.class);
                        startActivity(i);
                        break;

                }
            }
        });
    }
}
