package com.example.josesanjuanelo.proyectomovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarUsuarios extends AppCompatActivity {

    private TableLayout tabla;
    private String aux;
    private ArrayList<Registro> p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);

        tabla = (TableLayout)findViewById(R.id.tblListarUsuaruio);
        p = DatosRegistro.traerRegistro(getApplicationContext());
        for (int i = 0; i < p.size(); i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);
            TextView c7 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(p.get(i).getNombre());
            c3.setText(""+p.get(i).getApellido());
            c4.setText(""+p.get(i).getUsuario());
            c5.setText(""+p.get(i).getContrasenia());
            c6.setText(""+p.get(i).getEdad());
            c7.setText(""+p.get(i).getSexo());

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
