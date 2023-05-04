
package com.mycompany.figuras;

import com.mycompany.figuras.operaciones.Valores;

/**
 *
 * @author Profesor
 */

public class Circulo {
    private double radio;
    static public int nCirculos;

    public Circulo(double radio) {
        this.radio = radio;
        nCirculos++;
    }

    public Circulo() {
        this.radio = Valores.radio;
        nCirculos++;
    }

    public double area()
    {
        return Valores.pi * Math.pow(radio,2 );
    }  
}
