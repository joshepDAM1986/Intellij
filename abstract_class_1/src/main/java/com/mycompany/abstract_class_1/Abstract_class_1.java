
package com.mycompany.abstract_class_1;

/**
 *
 * @author garci
 */

public class Abstract_class_1 {

    public static void main(String[] args) {
        
    Figura rectangulo = new Rectangulo("Rojo", 5, 10);
    System.out.println("La figura tipo rectángulo tiene un área de " + rectangulo.area());

    Figura triangulo = new Triangulo("Azul", 4, 3);
    double areaTriangulo = triangulo.area();
    System.out.println("La figura tipo triángulo tiene un área de " + areaTriangulo);
    }
}