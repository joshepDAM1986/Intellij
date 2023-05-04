
package com.mycompany.base_datos_alumnado;

import java.io.*;

/**
 *
 * @author garci
 */

public class Alumno implements Serializable {
    private static final long serialVersionUID= 1L;
    private String nombre;
    private  String apellidos;
    private byte edad;

    public Alumno(String nombre, String apellidos, byte edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
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

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format("%30s", nombre)
                + String.format("%30s", apellidos);
    }
    
    
    
} 
