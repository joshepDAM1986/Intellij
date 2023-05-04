
package com.mycompany.fauna_flora;

/**
 *
 * @author garci
 */

public class Animal extends SerVivo {
    protected int peso;
    protected float altura;

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public void alimentarse() {
        System.out.println("Los animales comen");
    }
    
    @Override
    public String toString() {
        return "--------\n " + "Animal: \n" + "--------" +
                "\nPeso: " + peso +
                "\nAltura: " + altura +
                "\nNombre científico: " + nombre_cientifico +
                "\nNombre común: " + nombre_comun;
    }
}
