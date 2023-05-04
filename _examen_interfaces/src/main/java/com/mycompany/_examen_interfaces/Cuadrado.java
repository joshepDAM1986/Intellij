
package com.mycompany._examen_interfaces;

/**
 *
 * @author garci
 */

/**
 * Clase Cuadrado que hereda de Figura e implementa ILados
 */

public class Cuadrado extends Figura implements ILados {
    private double lado;
    
    /**
     * 
     * @param lado 
     */

    public Cuadrado(double lado) {
        this.lado = lado;
    }
    
    /**
     * Calcula el area del cuadradp
     * @return el area del cuadradp
     */

    @Override
    public double calculaArea() {
        return Math.pow(lado, 2);
    }
    
    /**
     * Muestra el numero de lados del cuadrado
     * @return el numero lados del cuadrado
     */

    @Override
    public int numLados() {
        return 4;
    }

    public double getLado() {
        return lado;
    }
    
    public String mostrar() {
        return "El area del cuadrado con lado = " + lado + " es = " + calculaArea();
    }
}