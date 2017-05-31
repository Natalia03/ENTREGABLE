package com.example.josesanjuanelo.proyectomovil;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrarPuntuacion extends AppCompatActivity {
    private TextView lblPuntacion, lblTotal;
    private EditText cajaNombre;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_puntuacion);

        res = this.getResources();
        cajaNombre = (EditText) findViewById(R.id.txtLlave);
        lblPuntacion = (TextView) findViewById(R.id.lblPuntuacionRegistro);
        lblTotal = (TextView) findViewById(R.id.lblTotalRegistro);
    }

    public void registrarPuntos(View v){
        if (validar()) {
            String nombre;
            Double puntuacion, total;

            puntuacion = Double.parseDouble(lblPuntacion.getText().toString());
            total = Double.parseDouble(lblTotal.getText().toString());
            nombre = cajaNombre.getText().toString().trim();

            Puntuacion p = new Puntuacion(nombre, puntuacion, total);
            p.guardar(getApplicationContext());

            //msj.setText(res.getString(R.string.mensaje));
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje2)).show();
            limpiar();
        }
    }

    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaNombre.setError(getResources().getString(R.string.error_2));
            return false;
        }

        return true;
    }

    public void limpiar (){
        cajaNombre.setText("");
        cajaNombre.requestFocus();
    }

}
