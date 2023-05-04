
package com.mycompany._examen_interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author garci
 */
public class FigurasTest {
    
     /**
     * Test of calculaArea method, of class Circulo.
     */
    
    @Test
    public void testCalculaArea() {
        System.out.println("calculaArea");
        Circulo circulo = new Circulo(10);
        double expResult = 314.1592653589793;
        double result = circulo.calculaArea();
        assertEquals(expResult, result, 0);
        
        Triangulo triangulo = new Triangulo(5,3);
        double expResult2 = 7.5;
        double result2 = triangulo.calculaArea();
        assertEquals(expResult2, result2, 0);

        Cuadrado cuadrado = new Cuadrado(4);
        double expResult3 = 16;
        double result3 = cuadrado.calculaArea();
        assertEquals(expResult3, result3, 0);
    }
}
