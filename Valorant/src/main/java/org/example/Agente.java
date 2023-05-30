package org.example;

import javax.persistence.*;
import java.util.Scanner;

@Entity
public class Agente {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private TipoAgente tipoAgente;
    private String Nacionalidad;
    @Embedded
    private Habilidad habilidad;

    public Agente() {
    }

    public Agente(String nombre, TipoAgente tipoAgente, String nacionalidad, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipoAgente = tipoAgente;
        Nacionalidad = nacionalidad;
        this.habilidad = habilidad;
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

    public TipoAgente getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(TipoAgente tipoAgente) {
        this.tipoAgente = tipoAgente;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return "Agentes:" + "\n\n" +
                "ID= " + id + "\n" +
                "Nombre= " + nombre + "\n" +
                "Tipo de Agente= " + tipoAgente + "\n" +
                "Nacionalidad= " + Nacionalidad + "\n" +
                "Habilidad= " + habilidad.getNombre() + "\n";
    }
}
