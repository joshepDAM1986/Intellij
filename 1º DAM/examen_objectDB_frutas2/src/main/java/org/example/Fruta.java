package org.example;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Fruta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    @ManyToOne
    private Pais pais;

    public Fruta() {
    }

    public Fruta(String nombre, String descripcion, float precio, Pais pais) {
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", pais=" + pais +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruta fruta = (Fruta) o;
        if (nombre == fruta.getNombre() && descripcion == fruta.getDescripcion() && precio == fruta.getPrecio() && pais.getPais() == fruta.getPais().getPais()){
            return true;
            }
            return false;
        }
    }
