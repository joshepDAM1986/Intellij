
package com.mycompany._examen_interfaces;

/**
 *
 * @author garci
 */

/**
 * Clase Triangulo que hereda de Figura e implementa ILados
 */
public class Triangulo extends Figura implements ILados {
    private double base;
    private double altura;
    
    /**
     * 
     * @param base
     * @param altura 
     */

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    /**
     * Calcula el area del triangulo
     * @return el area del triangulo
     */

    @Override
    public double calculaArea() {
        return (base * altura) / 2;
    }
    
   /**
     * Muestra el numero de lados del triangulo
     * @return el numero lados del triandgulo
     */

    @Override
    public int numLados() {
        return 3;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
    

    public String mostrar() {
        return "El area del triangulo con base = " + base + " y altura " + altura + " es = " + calculaArea();
    }
}
