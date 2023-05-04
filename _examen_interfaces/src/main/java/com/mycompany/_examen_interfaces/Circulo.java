
package com.mycompany._examen_interfaces;

/**
 *
 * @author garci
 */

/**
 * Clase Circulo que hereda de Figura
 */

public class Circulo extends Figura {
    private double radio;
    
    /**
     * 
     * @param radio 
     */

    public Circulo(double radio) {
        this.radio = radio;
    }
    
    /**
     * Calcula el area del circulo
     * @return el area del circulo
     */

    @Override
    public double calculaArea() {
        return Math.PI * Math.pow(radio, 2);
    }
    
    public double getRadio() {
        return radio;
    }
    

    public String mostrar() {
        return "El area del circulo con radio = " + radio +  " es = " + calculaArea();
    }
    
}