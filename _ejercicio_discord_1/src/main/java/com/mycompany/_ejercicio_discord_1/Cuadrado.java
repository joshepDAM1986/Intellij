
package com.mycompany._ejercicio_discord_1;

/**
 *
 * @author garci
 */
public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(String color,double lado) {
        super(color);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado*lado;
    }

}
