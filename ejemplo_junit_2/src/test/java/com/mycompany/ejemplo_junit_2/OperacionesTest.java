
package com.mycompany.ejemplo_junit_2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author damci
 */

public class OperacionesTest {
    
    public OperacionesTest() {
    }
    
    @Test
    public void testSomeMethod() {
        
        //Given
        System.out.println("operaciones");
        Operaciones op = new Operaciones();
        
        //When
        int n1 = 4;
        int n2 = 5;
        
        int resultado = op.suma(n1,n2);
        
        //Then
        assertEquals(9, resultado,0);
    }

    @Test
    public void testConversorTemp() {
        System.out.println("conversor");
        double temp = 100;
        char system = 'C';
        Operaciones instance = new Operaciones();
        
        double result = instance.conversorTemp(temp, system);
        
        assertEquals(212, result, 0);
    }

    /**
     * Test of suma method, of class Operaciones.
     */
    @Test
    public void testSuma() {
        System.out.println("suma");
        int n1 = 0;
        int n2 = 0;
        Operaciones instance = new Operaciones();
        int expResult = 0;
        int result = instance.suma(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
