package org.example;

import javax.persistence.Embeddable;

@Embeddable
public class Persona{
    private String nombre;
    private String dni;

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;


    }
}