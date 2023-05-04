
package com.mycompany.agregacion;

/**
 *
 * @author garci
 */

public class Persona {
    private String nombre;
    private String apellidos;
    private Persona padre;

    public Persona(String nombre, String apellidos, Persona padre) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.padre = padre;
    }

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Persona() {
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Persona getPadre() {
        return padre;
    }

    public void setPadre(Persona padre) {
        this.padre = padre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", padre=" + padre + '}';
    }
    
    
}
