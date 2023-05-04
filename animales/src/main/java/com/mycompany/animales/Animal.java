
package com.mycompany.animales;

/**
 *
 * @author garci
 */

public class Animal extends Animales {
    protected String especie;
    protected String nombre;
    protected int edad;
    protected String raza;

    
    public String comunicarse(){
        return "";
    }
    
    public Animal(String especie,String nombre, int edad, String raza) {
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }
    
public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return especie +":" + "\n" + "Nombre = " + nombre + "\nEdad = " + edad + "\nRaza = " + raza;
    }

    
}
    
