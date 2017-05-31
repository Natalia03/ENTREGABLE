package com.example.josesanjuanelo.proyectomovil;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class registrarAyuda extends AppCompatActivity {

    private TextView lblAbrigo, lblBloqueador, lblKit, lblRepelente, lblTotal;
    private EditText cajaNombre;
    private Resources res;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_ayuda);

        res = this.getResources();
        cajaNombre = (EditText) findViewById(R.id.txtLlaveAyuda);
        lblAbrigo = (TextView) findViewById(R.id.lblAbrigoRegistro);
        lblBloqueador = (TextView) findViewById(R.id.lblBloqueadorRegistro);
        lblKit = (TextView) findViewById(R.id.lblKitRegistro);
        lblRepelente = (TextView) findViewById(R.id.lblRepelenteRegistro);
        lblTotal = (TextView) findViewById(R.id.lblAyudaRegistro);
    }

    public void registrarAyudas(View v){
        if (validar()) {
            String nombre;
            Double abrigo, bloqueador, kit, repelente, total;

            abrigo= Double.parseDouble(lblAbrigo.getText().toString());
            bloqueador = Double.parseDouble(lblBloqueador.getText().toString());
            kit = Double.parseDouble(lblKit.getText().toString());
            repelente = Double.parseDouble(lblRepelente.getText().toString());
            total = Double.parseDouble(lblTotal.getText().toString());
            nombre = cajaNombre.getText().toString().trim();

            Ayuda a = new Ayuda(nombre, abrigo, bloqueador, kit, repelente, total);
            a.guardar(getApplicationContext());

            //msj.setText(res.getString(R.string.mensaje));
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje3)).show();
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
