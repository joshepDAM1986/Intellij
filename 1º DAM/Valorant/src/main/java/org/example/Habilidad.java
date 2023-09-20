package org.example;

import javax.persistence.*;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int idHabilidad;
    private String nombre;
    private String descripcion;
    private int precio;
    private int usos;

    public Habilidad() {
    }

    public Habilidad(String nombre, String descripcion, int precio, int usos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.usos = usos;
    }

    public int getId() {
        return idHabilidad;
    }

    public void setId(int idHabilidad) {
        this.idHabilidad = idHabilidad;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    @Override
    public String toString() {
        return "Habilidades:" + "\n" +
                "ID= " + idHabilidad + "\n" +
                "Nombre= " + nombre + "\n" +
                "Descripción= " + descripcion + "\n" +
                "Precio= " + precio + "\n" +
                "Usos= " + usos + "\n";
    }
}

