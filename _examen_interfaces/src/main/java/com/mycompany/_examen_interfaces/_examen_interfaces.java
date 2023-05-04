
package com.mycompany._examen_interfaces;

/**
 *
 * @author garci
 */

public class _examen_interfaces {

    public static void main(String[] args) {
        
        /**
         * Creamos instancias de cada figuras y
         * lo mostramos por pantalla con el metodo toSting
         */
        Circulo circulo = new Circulo(10);
        System.out.println(circulo.mostrar());

        Triangulo triangulo = new Triangulo(5, 3);
        System.out.println(triangulo.mostrar());

        Cuadrado cuadrado = new Cuadrado(4);
        System.out.println(cuadrado.mostrar());
    }
}

