package com.example.josesanjuanelo.proyectomovil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class RegistroCiudades extends AppCompatActivity {

    private Spinner cbxDepartamentos;
    private EditText cajaCiudad;
    private Resources res;
    private ArrayList<Ciudad> k = new ArrayList();
    private ArrayAdapter<String> ad1;
    private String [] opc1;
    private ImageView mini;
    private Button subir;
    private ProgressDialog pSub;
    private StorageReference myStorag;
    private Uri descargaDeFoto;
    private static final int galeria = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ciudades2);

        res = this.getResources();
        cajaCiudad = (EditText)findViewById(R.id.txtCiudadRegistro);
        cbxDepartamentos = (Spinner)findViewById(R.id.spnDepartamentosRegistro);
        myStorag = FirebaseStorage.getInstance().getReference();
        subir = (Button)findViewById(R.id.btnSubirArchivo);
        mini = (ImageView)findViewById(R.id.imgMiniatura);
        pSub = new ProgressDialog(this);

        subir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i, galeria);
            }

        });

        opc1 = this.getResources().getStringArray(R.array.deptos);

        ad1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc1);

        cbxDepartamentos.setAdapter(ad1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == galeria && resultCode == RESULT_OK){

            pSub.setTitle(res.getString(R.string.mensajeSubida1));
            pSub.setMessage(res.getString(R.string.mensajeSubida2));
            pSub.setCancelable(false);
            pSub.show();
            Uri U = data.getData();

            StorageReference fileDestiny = myStorag.child("TourismeNaJos").child(U.getLastPathSegment());

            fileDestiny.putFile(U).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    pSub.dismiss();

                    descargaDeFoto = taskSnapshot.getDownloadUrl();

                    Glide.with(RegistroCiudades.this)
                            .load(descargaDeFoto)
                            .fitCenter()
                            .centerCrop()
                            .into(mini);
                    Toast.makeText(RegistroCiudades.this, "Carga exitosa", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void registrar (View v) {
    int c= Departamento.traerCiudades(getApplicationContext()).size()+1;
        if (validar()) {
            String nombreDep, nombreCiu, foto;
            nombreCiu = cajaCiudad.getText().toString().trim();
            nombreDep = cbxDepartamentos.getSelectedItem().toString();

            foto = String.valueOf(descargaDeFoto);
            Ciudad n = new Ciudad(c, foto, nombreDep, nombreCiu);
            n.guardar(getApplicationContext());

            //msj.setText(res.getString(R.string.mensaje));
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje)).show();
            limpiar();
        }
    }


    public void limpiar (){
            cajaCiudad.setText("");
            cbxDepartamentos.setSelection(0);
            cajaCiudad.requestFocus();
    }

    public boolean validar(){
        if (cajaCiudad.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaCiudad.setError(getResources().getString(R.string.error_1));
            return false;
        }

        return true;
    }

}
