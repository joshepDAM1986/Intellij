
package com.mycompany._examen_array_list;

/**
 *
 * @author garci
 */

class Persona {
    private String nombre;
    private String apellidos;
    private String nif;

    public Persona(String nombre, String apellidos, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNif() {
        return nif;
    }
}


