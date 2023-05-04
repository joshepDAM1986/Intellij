
package com.mycompany.animales;

/**
 *
 * @author garci
 */

public class Perro extends Animal {
private int patas;
    private boolean cola;
    private int nRegistro;
    
    @Override
    public String comunicarse(){
        return "guau guau";
    }
    
    public void olfatear(){
    }

    public Perro(String especie, String nombre, int edad, String raza, int patas, boolean cola, int nRegistro) {
        super(especie, nombre, edad, raza);
        this.patas = patas;
        this.cola = cola;
        this.nRegistro = nRegistro;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public boolean isCola() {
        return cola;
    }

    public void setCola(boolean cola) {
        this.cola = cola;
    }

    public int getnRegistro() {
        return nRegistro;
    }

    public void setnRegistro(int nRegistro) {
        this.nRegistro = nRegistro;
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
        return super.toString() + "\nPatas = " + patas + "\nCola = " + cola + "\nNúmero de Registro = " + nRegistro + "\n";
    }
}