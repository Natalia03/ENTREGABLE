package com.example.josesanjuanelo.proyectomovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarPuntos extends AppCompatActivity {
    private TableLayout tabla;
    private String aux;
    private ArrayList<Puntuacion> p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_puntos);

        tabla = (TableLayout)findViewById(R.id.tblPuntos);
        p = DatosPuntacion.traerPuntuaciones(getApplicationContext());
        for (int i = 0; i < p.size(); i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c5 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(p.get(i).getNumero());
            c3.setText(""+p.get(i).getPuntuacion());
            c5.setText(""+p.get(i).getTotal());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c5);

            tabla.addView(fila);
        }
    }
}
