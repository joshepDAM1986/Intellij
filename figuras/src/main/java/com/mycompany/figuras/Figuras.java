
package com.mycompany.figuras;

import com.mycompany.figuras.operaciones.Valores;

/**
 *
 * @author Profesor
 */

public class Figuras {

    public static void main(String[] args) {
        Circulo c1 = new Circulo();
        Circulo c2 = new Circulo(3.0);
        
        Cilindro cl1 = new Cilindro();
        Cilindro cl2 = new Cilindro(2.0, 8.0);
        
        System.out.println("Area círculo:" + c1.area());
        System.out.println("Area círculo:" + c2.area());
        
        System.out.println("Area cilindro:" + cl1.area());
        System.out.println("Area cilindro:" + cl2.area());
        
        System.out.println("Número de círculos " + Circulo.nCirculos);
        System.out.println("Número de cilindros " + Cilindro.nCilindros);
        
        System.out.println("Area por defecto:" + Valores.area());
    }
}
