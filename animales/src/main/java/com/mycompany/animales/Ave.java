
package com.mycompany.animales;

/**
 *
 * @author garci
 */

public class Ave extends Animal{
    
    private int patas;
    private int alas;
    
    @Override
    public String comunicarse(){
        return "pio pio";
    }
    
    public void hacerNido(){
        
    }

    public Ave(String especie, String nombre, int edad, String raza,int patas, int alas){
        super(especie, nombre, edad, raza);
        this.patas = patas;
        this.alas = alas;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public int getAlas() {
        return alas;
    }

    public void setAlas(int alas) {
        this.alas = alas;
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
        return super.toString() + "\nPatas = " + patas + "\nAlas = " + alas + "\n";
    }
    
}