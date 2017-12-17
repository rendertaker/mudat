package com.itla.mudat.entily;

import java.io.Serializable;

/**
 * Created by iconlabs on 18/11/17.
 */

public class Categoria implements Serializable
{
    int id;
    String nombre;
    String descripcion;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
