
package com.mycompany.figuras;

import com.mycompany.figuras.operaciones.Valores;

/**
 *
 * @author Profesor
 */

public class Cilindro {
    private double radio;
    private double altura;
    static public int nCilindros;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        nCilindros++;
    }

    public Cilindro() {
        this.radio = Valores.radio;
        this.altura = Valores.altura;  
        nCilindros++;
    }
    
    public double area()
    {
        return (2*Valores.pi*Math.pow(radio,2) + 2*Valores.pi*radio*altura);
    }
}
