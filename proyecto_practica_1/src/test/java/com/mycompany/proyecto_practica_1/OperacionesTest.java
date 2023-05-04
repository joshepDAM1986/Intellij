
package com.mycompany.proyecto_practica_1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author garci
 */

public class OperacionesTest {
    
    public OperacionesTest() {
    }

    /**
     * Test of areaCirculo method, of class Operaciones.
     */
    
    @Test
    public void testAreaCirculo() {
        System.out.println("areaCirculo");
        double radio = 5;
        Operaciones instance = new Operaciones();
        double expResult = 78.54;
        double result = instance.areaCirculo(radio);
        assertEquals(expResult, result, 0.01);
        
    }

    /**
     * Test of perimetroCirculo method, of class Operaciones.
     */
    
    @Test
    public void testPerimetroCirculo() {
        System.out.println("perimetroCirculo");
        double radio = 5;
        Operaciones instance = new Operaciones();
        double expResult = 31.42;
        double result = instance.perimetroCirculo(radio);
        assertEquals(expResult, result, 0.01);
       
    }
}
