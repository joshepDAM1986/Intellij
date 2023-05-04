
package com.mycompany.ejercicio_9_5_alt;

/**
 *
 * @author garci
 */
class Alumno {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nacionalidad;

    public Alumno(String nombre, String apellido1, String apellido2, String nacionalidad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return apellido1 + " " + apellido2 + ", " + nombre + ", " + nacionalidad;
    }
}