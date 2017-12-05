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
}
