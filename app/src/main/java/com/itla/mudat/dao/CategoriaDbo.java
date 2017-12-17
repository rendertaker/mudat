package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.itla.mudat.entily.Categoria;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by iconlabs on 11/12/17.
 */

public class CategoriaDbo
{

    private DbConnection con;

    public CategoriaDbo(Context context)
    {
        con = new DbConnection(context);
    }

    public void crear(Categoria categoria)
    {
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Nombre", categoria.getNombre());
        cv.put("Descripcion", categoria.getDescripcion());

        Log.i("CategoriaDbo_crear", String.valueOf(categoria.getId()));

        if(categoria.getId() == 0 )
        {
            Long id = db.insert("categoria", null, cv);
        }
        else
        {
            db.update("categoria", cv, "id = " + categoria.getId(),null);

        }


        db.close();
    }

    public List<Categoria> buscar()
    {
        List<Categoria> categorias = new ArrayList<>();
        SQLiteDatabase db = con.getReadableDatabase();
        String columnas[] = new String[] {"id","Nombre","Descripcion"};
        Cursor cursor = db.query("categoria", columnas, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            Categoria c = new Categoria();
            c.setId(cursor.getInt(cursor.getColumnIndex("id")));
            c.setNombre(cursor.getString(cursor.getColumnIndex("Nombre")));
            c.setDescripcion(cursor.getString(cursor.getColumnIndex("Descripcion")));
            cursor.moveToNext();
            categorias.add(c);
        }
        cursor.close();
        db.close();

        return categorias;
    }
}
