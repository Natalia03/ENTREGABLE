package com.example.josesanjuanelo.proyectomovil;

import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class RegistroPersona extends AppCompatActivity {

    private EditText cajaNombre, cajaApellido, cajaUsuario, cajaContrasenia, cajaEdad;
    private TextView id;
    private RadioButton r1, r2;
    private ArrayAdapter<Registro> r;
    private Resources res;
    private SQLiteDatabase db;
    private int idActual, idAument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_persona);

        res = this.getResources();
        id = (TextView)findViewById(R.id.lblIdRegistro);
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);
        cajaUsuario = (EditText)findViewById(R.id.txtUsuarioRegistro);
        cajaContrasenia = (EditText)findViewById(R.id.txtContraseniaRegistro);
        cajaEdad = (EditText)findViewById(R.id.txtEdad);
        r1 = (RadioButton)findViewById(R.id.r1Masculino);
        r2 = (RadioButton)findViewById(R.id.r2Femenino);
        //id.setText(""+1);
        id.setText("ID: "+idYa());
    }


    /*public void buscarId(int id){
        Registro r;
        r = DatosRegistro.buscar(getApplicationContext(), id);
        if(r!=null) {
            idAument = r.getId();
        }
    }
    */
    public int idYa(){
       int x = DatosRegistro.traerRegistro(getApplicationContext()).size()+1;

        return x;
    }

    public void registrar(View v){
        if (validar()) {
            String  nombre, apellido, usuario, contrasenia, edad, sexo="";


            nombre = cajaNombre.getText().toString();
            apellido = cajaApellido.getText().toString();
            usuario = cajaUsuario.getText().toString();
            contrasenia = cajaContrasenia.getText().toString();
            edad = cajaEdad.getText().toString();
            if (r1.isChecked()){
                sexo = res.getString(R.string.sexo1);
            }else{
                if (r2.isChecked()) {
                    sexo = res.getString(R.string.sexo2);
                }
            }



            idAument=idYa();

            idAument = idAument+1;
            Registro r = new Registro(idAument, nombre, apellido, usuario, contrasenia, edad, sexo);
            r.guardar(getApplicationContext());
            id.setText("ID: "+idAument);

            //msj.setText(res.getString(R.string.mensaje));
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje4)).show();
            limpiar();
        }
    }

    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaNombre.setError(getResources().getString(R.string.error_2));
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaApellido.setError(getResources().getString(R.string.error_4));
            return false;
        }
        if (cajaUsuario.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaUsuario.setError(getResources().getString(R.string.error_5));
            return false;
        }if (cajaContrasenia.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaContrasenia.setError(getResources().getString(R.string.error_6));
            return false;
        }
        if (cajaEdad.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaEdad.setError(getResources().getString(R.string.error_7));
            return false;
        }

        return true;
    }

    public void limpiar (){
        cajaNombre.setText("");
        cajaApellido.setText("");
        cajaUsuario.setText("");
        cajaContrasenia.setText("");
        cajaEdad.setText("");;
        cajaNombre.requestFocus();
    }
}
