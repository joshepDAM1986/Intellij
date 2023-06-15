package org.example;

import java.util.Objects;

public class Fruta {
    private String nombre;
    private String descripcion;
    private float precio;
    private String pais;

    public Fruta(String nombre, float precio, String descripcion, String pais) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruta fruta = (Fruta) o;
        return Float.compare(fruta.precio, precio) == 0
                && Objects.equals(nombre, fruta.nombre)
                && Objects.equals(descripcion, fruta.descripcion)
                && Objects.equals(pais, fruta.pais);
    }

}
