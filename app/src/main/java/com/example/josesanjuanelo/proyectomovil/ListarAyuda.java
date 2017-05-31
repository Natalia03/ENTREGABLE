package com.example.josesanjuanelo.proyectomovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarAyuda extends AppCompatActivity {

    private TableLayout tabla;
    private String aux;
    private ArrayList<Ayuda> a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ayuda);

        tabla = (TableLayout)findViewById(R.id.tblAyudaE);
        a = DatosAyuda.traerAyuda(getApplicationContext());
        for (int i = 0; i < a.size(); i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);
            TextView c7 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(a.get(i).getId());
            c3.setText("" + a.get(i).getAbrigo());
            c4.setText("" + a.get(i).getBloqueador());
            c5.setText("" + a.get(i).getKit());
            c6.setText("" + a.get(i).getRepelente());
            c7.setText("" +a.get(i).getTotal());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);
            fila.addView(c7);

            tabla.addView(fila);
        }
    }
}
