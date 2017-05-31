package com.example.josesanjuanelo.proyectomovil;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

public class Principal extends AppCompatActivity {
    TabHost th;
    private Spinner cbxDepartamentos;
    private Resources res;
    private ArrayList<Ciudad> k = new ArrayList();
    private ImageView tay1, tay2, arac1, arac2, bara1, bara2, popa1;
    private ArrayAdapter<String> ad1;
    private String [] opc1;
    private ListView lista;
    private ArrayList<Registro> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        res = this.getResources();

        lista = (ListView)findViewById(R.id.lvUsers);
        users = DatosRegistro.traerRegistro(getApplicationContext());
        tay1 = (ImageView)findViewById(R.id.imgtay1);
        tay2 = (ImageView)findViewById(R.id.imgTay2);
        arac1 = (ImageView)findViewById(R.id.imgAra1);
        arac2 = (ImageView)findViewById(R.id.imgAra2);
        bara1 = (ImageView)findViewById(R.id.imgBara1);
        bara2 = (ImageView)findViewById(R.id.imgBara2);
        popa1 = (ImageView)findViewById(R.id.imgPopa1);

        AdaptadorUser adapter = new AdaptadorUser(this, users);
        lista.setAdapter(adapter);

        th = (TabHost)findViewById(R.id.tabhPrincipal);
        th.setup();
        TabHost.TabSpec ts1=th.newTabSpec("Tab1");
        ts1.setIndicator(res.getString(R.string.thinicio));
        ts1.setContent(R.id.tab1);

        th.addTab(ts1);

        th.setup();
        TabHost.TabSpec ts2=th.newTabSpec("Tab2");
        ts2.setIndicator(res.getString(R.string.thifotos));
        ts2.setContent(R.id.tab2);

        th.addTab(ts2);

        th.setup();
        TabHost.TabSpec ts3=th.newTabSpec("Tab3");
        ts3.setIndicator(res.getString(R.string.thintempo));
        ts3.setContent(R.id.tab3);

        th.addTab(ts3);

        Glide.with(this)
                .load(aleatoriotay1())
                .fitCenter()
                .centerCrop()
                .into(tay1);

        Glide.with(this)
                .load(aleatoriotay2())
                .fitCenter()
                .centerCrop()
                .into(tay2);

        Glide.with(this)
                .load(aleatorioAra1())
                .fitCenter()
                .centerCrop()
                .into(arac1);

        Glide.with(this)
                .load(aleatorioAra2())
                .fitCenter()
                .centerCrop()
                .into(arac2);

        Glide.with(this)
                .load(aleatorioBara1())
                .fitCenter()
                .centerCrop()
                .into(bara1);

        Glide.with(this)
                .load(aleatorioBara2())
                .fitCenter()
                .centerCrop()
                .into(bara2);

        Glide.with(this)
                .load(aleatorioPopa1())
                .fitCenter()
                .centerCrop()
                .into(popa1);
    }

    public  void mostrarListado1(View v){
        Intent i = new Intent(Principal.this, ListarCiudad.class);
        startActivity(i);
    }

    public String aleatoriotay1(){
        String fotos[] = {"http://vivecaribe.co/wp-content/uploads/2016/09/Un-viaje-a-Ciudad-Perdida-708x350.jpg",
                "http://new-hls.s3.amazonaws.com/hls/data/2250/website/general/bn/parque-tayrona-banner-1.jpg",
                "https://www.promosaereas.com/wp-content/uploads/2016/05/parque-tayrona-santa-marta-colombia.jpg",
                "https://i.ytimg.com/vi/oGXn1HGWU78/maxresdefault.jpg",
                "https://i.ytimg.com/vi/EZ9sKrStGY0/maxresdefault.jpg"};
        Random rand = new Random();
        int numero = rand.nextInt(4);
        return  fotos[numero];
    }

    public String aleatoriotay2(){
        String fotos[] = {"http://www.eltiempo.com/contenido///colombia/otras-ciudades/IMAGEN/IMAGEN-16418822-2.png",
                "https://variedadesdecolombia.com/wp-content/uploads/2014/09/Parque_Nacional_Natural_Tayrona.jpg",
                "http://new-hls.s3.amazonaws.com/hls/data/1199/website/general/bn/normal_baner-01-novo-436513804.jpg",
                "http://www.eluniversal.com.co/sites/default/files/201612/tayrona_2_2.jpg",
                "https://www.elheraldo.co/sites/default/files/styles/width_860/public/articulo/2016/12/09/4d_parque_tayrona.jpg?itok=0lPw2zIF"};
        Random rand = new Random();
        int numero = rand.nextInt(4);
        return  fotos[numero];
    }

    public String aleatorioAra1(){
        String fotos[] = {"https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Aracataca%27s_Train_Station.JPG/1200px-Aracataca%27s_Train_Station.JPG",
                "https://media-cdn.tripadvisor.com/media/photo-s/01/c5/5a/d3/restaurante-gabo.jpg",
                "http://www.telesurtv.net/__export/1408989383833/sites/telesur/img/image/2014/04/18/aracataca3.jpg_1718483346.jpg",
                "https://img.webme.com/pic/m/magdalenenses/tren_aracataca.jpg",
                "http://www.viajarenverano.com/wp-content/uploads/2014/11/Parque-Bolivar-Kiosco.png"};
        Random rand = new Random();
        int numero = rand.nextInt(4);
        return  fotos[numero];
    }

    public String aleatorioAra2(){
        String fotos[] = {"https://www.opitours.com/images/aracataca%20mac.jpg",
                "http://www.elinformador.com.co/images/stories/magdalena/2015/12-diciembre/04mag01.jpg",
                "http://www.elinformador.com.co/guia/images/djmediatools/5-aracataca/31aracatacas.jpg",
                "https://zabacequia.files.wordpress.com/2015/12/img_20151227_135732839.jpg",
                "http://www.elinformador.com.co/images/stories/revistas/31fotosant.jpg"};
        Random rand = new Random();
        int numero = rand.nextInt(4);
        return  fotos[numero];
    }

    public String aleatorioBara1(){
        String fotos[] = {"http://emisoraatlantico.com.co/wp-content/uploads/2016/10/baranoa.jpg",
                "http://revistas.elheraldo.co/sites/default/files/2013/11/14/articulo/img_3274.jpg",
                "http://www.autopistasdelsol.com.co/sites/default/files/Doble%20calzada%20Barranquilla%20-Baranoa__2.jpg",
                "http://revistas.elheraldo.co/sites/default/files/2013/11/14/articulo/img_3297.jpg",
                "http://www.autopistasdelsol.com.co/sites/default/files/Doble%20calzada%20Barranquilla%20-Baranoa__1_0.jpg"};
        Random rand = new Random();
        int numero = rand.nextInt(4);
        return  fotos[numero];
    }

    public String aleatorioBara2(){
        String fotos[] = {"http://www.baranoa-atlantico.gov.co/NuestraAlcaldia/SaladePrensa/PublishingImages/X%20FERIA%20PEDAGOGICA%20MUNICIPAL.jpg",
                "http://www.intergremialatlantico.com/sites/default/files/styles/news_main/public/field/image/banda.jpg?itok=VKr5VJcI",
                "https://lh6.googleusercontent.com/-ABI_K7RUPP0/UV46tbLSKzI/AAAAAAAAAC0/TUB2jJuF3iw/w800-h800/baranoa+parque+espejo+de+agua10.jpg",
                "https://lh3.googleusercontent.com/-KwjvsJsKr6I/UV46sztZOxI/AAAAAAAAACo/fzL18J7wMFo/w800-h800/baranoa+parque+espejo+de+agua.jpg",
                "http://4.bp.blogspot.com/-SY0juziikmE/Up-GCASvyvI/AAAAAAAAEy8/H9gGJN0vE4U/s1600/Iglesia.jpg"};
        Random rand = new Random();
        int numero = rand.nextInt(4);
        return  fotos[numero];
    }

    public String aleatorioPopa1(){
        String fotos[] = {"https://www.las2orillas.co/wp-content/uploads/2017/02/Popayan.jpg",
                "http://aventurecolombia.com/sites/default/files/popayan_y_el_volcan_purace_0.jpg",
                "http://www.derechoypropiedad.com/nw/images/oficinas/popayan.jpg",
                "http://www.hotelesdann.com/dann-popayan/wp-content/uploads/sites/14/2016/09/courtyard-hotel-dann-monasterio-popayan-colombia_6055642029_o.jpg",
                "http://www.hotelsanmartinpopayan.com/image/cache/data/Slider%2028Junio/1-1380x750.jpg"};
        Random rand = new Random();
        int numero = rand.nextInt(4);
        return  fotos[numero];
    }


}
