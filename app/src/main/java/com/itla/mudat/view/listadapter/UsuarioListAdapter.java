package com.itla.mudat.view.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.itla.mudat.R;
import com.itla.mudat.entily.Usuario;
import android.content.Context;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iconlabs on 2/12/17.
 */

public class UsuarioListAdapter extends BaseAdapter
{
    private List<Usuario> usuarios;
    private Activity context;

    public UsuarioListAdapter(List<Usuario> usuarios, Activity context)
    {
        this.usuarios = usuarios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
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
            view = inflater.inflate(R.layout.listausuariorow, null);
        }

        TextView luNombre = (TextView) view.findViewById(R.id.luNombre);
        TextView luEmail = (TextView) view.findViewById(R.id.luEmail);

        Usuario u = usuarios.get(i);
        luNombre.setText(u.getNombre());
        luEmail.setText(u.getEmail());

        return view;
    }
}
