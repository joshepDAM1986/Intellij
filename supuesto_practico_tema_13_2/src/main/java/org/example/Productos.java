package org.example;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Productos {
    @Id
    @GeneratedValue
    @Column (name = "id", nullable = false)
    private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    private String pais;

    public Productos() {
    }

    public Productos(String nombre, String descripcion, float precio, String pais) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String toString() {
        return "Productos {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", pais='" + pais + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productos productos = (Productos) o;
        return id == productos.id && Float.compare(productos.precio, precio) == 0 && nombre.equals(productos.nombre) && descripcion.equals(productos.descripcion) && pais.equals(productos.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, precio, pais);
    }
}
