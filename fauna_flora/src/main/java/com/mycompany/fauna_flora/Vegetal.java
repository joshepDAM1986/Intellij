
package com.mycompany.fauna_flora;

/**
 *
 * @author garci
 */

public class Vegetal extends SerVivo{
    protected float altura;
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    @Override
    public String toString() {
        return "-------- \n" + "Vegetal: \n" + "--------" +
                "\nAltura: " + altura +
                "\nNombre científico: " + nombre_cientifico +
                "\nNombre común: " + nombre_comun;
    }
    @Override
    public void alimentarse() {
        System.out.println("Las plantas hacen la fotosíntesis");
    }
}