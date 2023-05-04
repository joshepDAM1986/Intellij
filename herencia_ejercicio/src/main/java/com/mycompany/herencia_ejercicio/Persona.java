
package com.mycompany.herencia_ejercicio;

/**
 *
 * @author garci
 */

public class Persona {
    private String nombre;
    private String apellidos;
    private String nif;
    private String ciudad;

    public Persona(String nombre, String apellidos, String nif, String ciudad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.ciudad = ciudad;
    }

    public Persona(String nombre, String apellidos, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.ciudad="Desconocida";
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    
    
    @Override
    public String toString() {
        return "Nombre = " + nombre +" "+ apellidos + "\nNif = " + nif + "\nCiudad = " + ciudad;
    }
}
