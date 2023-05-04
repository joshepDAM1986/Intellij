
package com.mycompany.animales;

/**
 *
 * @author garci
 */

public class Gato extends Animal{
private int patas;
    private Boolean cola;
    private int nRegistro;
    
    @Override
    public  String comunicarse(){
    return "miau miau";
}
    
    public void ronronear(){
    }

    public Gato(String especie,String nombre, int edad, String raza, int patas, Boolean cola, int nRegistro) {
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

    public Boolean getCola() {
        return cola;
    }

    public void setCola(Boolean cola) {
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