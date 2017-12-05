package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.mudat.entily.TipoUsuario;
import com.itla.mudat.entily.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iconlabs on 25/11/17.
 */

public class UsuarioDbo
{
    private DbConnection con;

    public UsuarioDbo(Context context)
    {
        con = new DbConnection(context);
    }

    public void crear(Usuario usuario)
    {
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre", usuario.getNombre());
        cv.put("clave", usuario.getClave());
        cv.put("tipo_usuario", usuario.getTipoUsuario().toString());
        cv.put("telefono", usuario.getTelefono());
        cv.put("email", usuario.getEmail());
        cv.put("identificacion", usuario.getIdentificacion());
        cv.put("estatus", usuario.getEstatus());

        if(usuario.getId() == 0 )
        {
            Long id = db.insert("usuario", null, cv);
        }
        else
        {
            db.update("usuario", cv, "id = " + usuario.getId(),null);
        }


        db.close();
    }

    public List<Usuario> buscar()
    {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = con.getReadableDatabase();
        String columnas[] = new String[] {"id","nombre","tipo_usuario","telefono", "email", "identificacion", "estatus"};
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            Usuario u = new Usuario();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
           // u.setTipoUsuario(TipoUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipo_usuario"))));
            u.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setIdentificacion(cursor.getString(cursor.getColumnIndex("identificacion")));
            u.setEstatus(cursor.getInt(cursor.getColumnIndex("estatus")));
            cursor.moveToNext();
            usuarios.add(u);
        }
        cursor.close();
        db.close();

        return usuarios;
    }
}
