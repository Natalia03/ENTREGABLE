package com.example.josesanjuanelo.proyectomovil;

import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Valledupar extends AppCompatActivity {

    private RadioButton r1, r2, r3, r4, r5;
    private CheckBox abrigo, bloqueador, kit, repelente;
    private Double puntos, abrig, bloqueado, kitt , repelent;
    private String sql1;
    private TextView resp, cajaAbrigo, cajaBloqueador, cajaKit, cajaRepelente;
    private ArrayList<Puntuacion> k = new ArrayList();
    private DecimalFormat puntoDos = new DecimalFormat("0.0");
    private SQLiteDatabase db;
    Double total, totala;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valledupar);

        buscarPuntos();
        buscarPorcentaje();

        res = this.getResources();
        resp = (TextView)findViewById(R.id.lblPuntuacionPopayan);
        r1 = (RadioButton)findViewById(R.id.r1Popayan);
        r2 = (RadioButton)findViewById(R.id.r2Popayan);
        r3 = (RadioButton)findViewById(R.id.r3Popayan);
        r4 = (RadioButton)findViewById(R.id.r4Popayan);
        r5 = (RadioButton)findViewById(R.id.r5Popayan);
        abrigo = (CheckBox)findViewById(R.id.cbxAbrigoPopayan);
        bloqueador = (CheckBox)findViewById(R.id.cbxBloqueadorPopayan);
        kit = (CheckBox)findViewById(R.id.cbxKitPopayan);
        repelente = (CheckBox)findViewById(R.id.cbxRepelentePopayan);
        cajaAbrigo = (TextView)findViewById(R.id.lblAbrigoPopayan);
        cajaBloqueador = (TextView)findViewById(R.id.lblBloqueadorPopayan);
        cajaKit = (TextView)findViewById(R.id.lblKitPopayan);
        cajaRepelente = (TextView)findViewById(R.id.lblRepelentePopayan);
    }
    public void mostrar_mapa (View v){
        Intent i = new Intent(Valledupar.this,Mapa_Valledupar.class);
        startActivity(i);
    }

    public void buscarPuntos(){;
        String nombre="VL";
        Puntuacion p;
        p = DatosPuntacion.buscar(getApplicationContext(), nombre);
        if(p!=null) {
            puntos = p.getPuntuacion();
            total = p.getTotal();
        }
    }

    public void buscarPorcentaje(){;
        String nombre="VL";
        Ayuda a;
        a = DatosAyuda.buscar(getApplicationContext(), nombre);
        if(a!=null) {
            abrig = a.getAbrigo();
            bloqueado = a.getBloqueador();
            kitt = a.getKit();
            repelent = a.getRepelente();
            totala = a.getTotal();
        }
    }

    public void puntuar(View v){
        String resultado;
        double form;
        String form2;

        if(r1.isChecked()) puntos = puntos+1;
        if(r2.isChecked()) puntos = puntos+2;
        if(r3.isChecked()) puntos = puntos+3;
        if(r4.isChecked()) puntos = puntos+4;
        if(r5.isChecked()) puntos = puntos+5;

        total = total+1;
        Puntuacion n = new Puntuacion("VL", puntos, total);
        n.modificar(getApplicationContext());
        form = (puntos/total);
        form2 = puntoDos.format(form);
        resultado = res.getString(R.string.calificacionActual)+" : "+form2;
        resp.setText(resultado);
    }

    public  void ayuda(View v){
        String resultado;
        double  a1, b1, k1, r1;
        String form2="", a2, b2, k2, r2;

        if(abrigo.isChecked()) abrig = abrig+1;
        if(bloqueador.isChecked()) bloqueado = bloqueado+1;
        if(kit.isChecked()) kitt = kitt+1;
        if(repelente.isChecked()) repelent = repelent+1;

        if (abrigo.isChecked() || bloqueador.isChecked() || kit.isChecked() || repelente.isChecked()){
            totala = totala+1;

            Ayuda a = new Ayuda("VL", abrig, bloqueado, kitt, repelent, totala);
            a.modificar(getApplicationContext());

            a1 = (abrig/totala)*100;
            a2 = puntoDos.format(a1);
            b1 = (bloqueado/totala)*100;
            b2 = puntoDos.format(b1);
            k1 = (kitt/totala)*100;
            k2 = puntoDos.format(k1);
            r1 = (repelent/totala)*100;
            r2= puntoDos.format(r1);

            cajaAbrigo.setText(a2+"%");
            cajaBloqueador.setText(b2+"%");
            cajaKit.setText(k2+"%");
            cajaRepelente.setText(r2+"%");

        }else{
            form2 = res.getString(R.string.error_3);
        }

        resp.setText(form2);
    }
}
