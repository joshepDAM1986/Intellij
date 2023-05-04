
package com.mycompany.proyecto_practica_1;

/**
 *
 * @author garci
 */
public class Operaciones {
    static final double PI=3.1415;
    
    public double areaCirculo(double radio){
            double resultado=PI * Math.pow (radio,2);
            return resultado;
    }
    
    public double perimetroCirculo(double radio){
            double resultado=(2*PI)*radio; 
            return resultado;
    }
    
}

