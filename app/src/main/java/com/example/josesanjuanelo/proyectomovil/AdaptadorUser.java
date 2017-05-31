package com.example.josesanjuanelo.proyectomovil;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;

import java.util.ArrayList;

/**
 * Created by Jose Sanjuanelo on 27/05/2017.
 */


public class AdaptadorUser extends BaseAdapter {
    private Context contexto;
    private ArrayList<Registro> user;
    private Resources res;


    public AdaptadorUser(Context contexto, ArrayList<Registro> user) {
        this.contexto = contexto;
        this.user = user;
    }

    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public Object getItem(int position) {
        return user.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView nombre, edad;
        String url, momentaneo;
        ImageView foto;
        LayoutInflater inflater;
        View ItemView;

        inflater =(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ItemView = inflater.inflate(R.layout.item_user, null);

        nombre = (TextView)ItemView.findViewById(R.id.lblNombre);
        edad = (TextView)ItemView.findViewById(R.id.lblEdad);
        foto = (ImageView) ItemView.findViewById(R.id.imgFotoUser);
        momentaneo = ""+user.get(position).getSexo();
        nombre.setText(""+user.get(position).getNombre());
        edad.setText(user.get(position).getEdad());
        if (momentaneo.equals("Masculino") || momentaneo.equals("Man")){
            url = "https://s-media-cache-ak0.pinimg.com/736x/04/e6/c7/04e6c7b6d4b2150bf6364f0791ddf8f7.jpg";
        }else{
            url = "https://s-media-cache-ak0.pinimg.com/originals/f2/42/6d/f2426d118879c17c5a704487f12714a5.jpg";
        }

        Glide.with(contexto)
                .load(url)
                .fitCenter()
                .centerCrop()
                .into(foto);

        return ItemView;
    }
}
