package com.itla.mudat.dao;

/**
 * Created by iconlabs on 25/11/17.
 */

public class SqlHelperSchema
{
    public static final String USUARIO_TABLE = "CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT," +
            "tipo_usuario TEXT," +
            "identificacion TEXT," +
            "email TEXT," +
            "telefono TEXT," +
            "clave TEXT," +
            "estatus TEXT)";

    public static final String ANUNCIO_TABLE = "CREATE TABLE anuncio (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "id_categoria INTEGER," +
            "id_usuario INTEGER," +
            "fecha TEXT," +
            "condicion TEXT," +
            "precio REAL," +
            "titulo TEXT," +
            "ubicacion TEXT," +
            "descripcion TEXT" +
            ")";

    public static final String CATEGORIA_TABLE = "CREATE TABLE categoria (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Descripcion TEXT," +
            "Nombre TEXT" +
            ")";


}


