
package com.mycompany.herencia_ejercicio;

/**
 *
 * @author garci
 */

public class Empleado extends Persona{
    
    private String categoria;
    private double irpf;
    private String departamento;

    public Empleado(String nombre,String apellidos,String nif,String ciudad,String categoria,String departamento){
        super(nombre, apellidos, nif, ciudad);
        this.categoria = categoria;
        this.departamento = departamento;
    }

    public Empleado(String nombre,String apellidos,String nif,String categoria){
        super(nombre, apellidos, nif);
        this.categoria = categoria;
        this.departamento = "N/A";
    }
    @Override
    public String toString() {
        return super.toString() + "\nCategoria = " + categoria + "\nDepartamento = " +departamento;
    }   
}


