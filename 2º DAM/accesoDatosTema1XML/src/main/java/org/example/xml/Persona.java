package org.example.xml;

import javax.xml.bind.annotation.XmlElement;

public class Persona {
    private String nombre;
    private int edad;

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public int getEdad() {
        return edad;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
        this.edad=0;
        this.nombre="";
    }


    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}