package com.itla.mudat.view.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entily.Anuncio;
import com.itla.mudat.entily.Usuario;

import java.util.List;

/**

 */

public class AnuncioListAdapter extends BaseAdapter {

    private List<Anuncio> anuncios;
    private Activity context;

    public AnuncioListAdapter(List<Anuncio> anuncios, Activity context)
    {
        this.anuncios = anuncios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return anuncios.size();
    }

    @Override
    public Object getItem(int i) {
        return anuncios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.listaanunciorow, null);
        }

        TextView laTitulo = (TextView) view.findViewById(R.id.laTitulo);
        TextView laDescripcion = (TextView) view.findViewById(R.id.laDescripcion);

        Anuncio a = anuncios.get(i);
        laTitulo.setText(a.getTitulo());
        laDescripcion.setText(a.getDescripcion());

        return view;
    }
}