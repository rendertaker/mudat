package com.itla.mudat.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entily.Anuncio;
import com.itla.mudat.entily.Categoria;
import com.itla.mudat.entily.Usuario;
import com.itla.mudat.view.LoginActivity;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by iconlabs on 9/12/17.
 */

public class AnuncioDbo
{
    private DbConnection con;
    final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public AnuncioDbo(Context context)
    {
        con = new DbConnection(context);
    }

    public void crear(Anuncio anuncio)
    {
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("titulo", anuncio.getTitulo());
        cv.put("descripcion", anuncio.getDescripcion());
        cv.put("precio", anuncio.getPrecio());
        cv.put("condicion", anuncio.getCondicion());
        cv.put("id_categoria", anuncio.getCategoria().getId());
        cv.put("id_usuario", LoginActivity.usuariologeado.getId());



        if(anuncio.getId() == 0 )
        {
            Long id = db.insert("anuncio", null, cv);
        }
        else
        {
            db.update("anuncio", cv, "id = " + anuncio.getId(),null);
        }


        db.close();
    }

    public List<Anuncio> buscar()
    {
        List<Anuncio> anuncios = new ArrayList<>();
        SQLiteDatabase db = con.getReadableDatabase();
        //String columnas[] = new String[] {"id","titulo","condicion","categoria", "fecha", "usuario", "ubicacion"};
        Cursor cursor = db.rawQuery("select a.*, u.nombre as u_nombre, c.Descripcion from anuncio a, usuario u, categoria c where a.id_usuario = u.id and a.id_categoria = c.id ", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            Anuncio a = new Anuncio();
            Usuario u = new Usuario();
            Categoria c = new Categoria();
            u.setId(cursor.getInt(cursor.getColumnIndex("id_usuario")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("u_nombre")));

            c.setId(cursor.getInt(cursor.getColumnIndex("id_categoria")));
            //c.setNombre(cursor.getString(cursor.getColumnIndex("ca")));
           // try {
            //    a.setFecha(df.parse(cursor.getString(cursor.getColumnIndex("fecha"))));
            //}catch (ParseException ex)
            //{


            a.setUsuario(u);
            a.setCategoria(c);
            a.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            a.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            a.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            a.setPrecio(cursor.getDouble(cursor.getColumnIndex("precio")));
            a.setCondicion(cursor.getString(cursor.getColumnIndex("condicion")));

            cursor.moveToNext();
            anuncios.add(a);
        }
        cursor.close();
        db.close();

        return anuncios;
    }
}
