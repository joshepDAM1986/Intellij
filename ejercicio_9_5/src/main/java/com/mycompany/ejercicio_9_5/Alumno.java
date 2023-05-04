
package com.mycompany.ejercicio_9_5;

/**
 *
 * @author garci
 */

class Alumno implements Comparable<Alumno> {
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
    public int compareTo(Alumno otroAlumno) {
        // Comparar primero por el primer apellido, luego por el segundo apellido, y finalmente por el nombre
        int comparacion = this.apellido1.compareTo(otroAlumno.getApellido1());
        if (comparacion == 0) {
            comparacion = this.apellido2.compareTo(otroAlumno.getApellido2());
            if (comparacion == 0) {
                comparacion = this.nombre.compareTo(otroAlumno.getNombre());
            }
        }
        return comparacion;
    }

    @Override
    public String toString() {
        return this.apellido1 + " " + this.apellido2 + ", " + this.nombre + " (" + this.nacionalidad + ")";
    }
}


