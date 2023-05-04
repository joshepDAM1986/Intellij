
package com.mycompany.ejemplo_unit_3;

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
     * Test of sumaArray method, of class Operaciones.
     */
    @Test
    public void testSumaArray() {
        System.out.println("sumaArray");
        int[] array = null;
        Operaciones instance = new Operaciones();
        int expResult = 0;
        int result = instance.sumaArray(array);
        assertEquals(expResult, result);
     }

    /**
     * Test of mayorElementoArray method, of class Operaciones.
     */
    
    @Test
    public void testMayorElementoArray() {
        System.out.println("mayorElementoArray");
        int[] array = null;
        Operaciones instance = new Operaciones();
        int expResult = 0;
        int result = instance.mayorElementoArray(array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menorElementoArray method, of class Operaciones.
     */
    
    @Test
    public void testMenorElementoArray() {
        System.out.println("menorElementoArray");
        int[] array = null;
        Operaciones instance = new Operaciones();
        int expResult = 0;
        int result = instance.menorElementoArray(array);
        assertEquals(expResult, result);
    }

    /**
     * Test of mayorMenorElementoArray method, of class Operaciones.
     */
    
    @Test
    public void testMayorMenorElementoArray() {
        System.out.println("mayorMenorElementoArray");
        int[] array = null;
        int tipo = 0;
        Operaciones instance = new Operaciones();
        int expResult = 0;
        int result = instance.mayorMenorElementoArray(array, tipo);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of InvertirCadena method, of class Cadenas.
     */
    
    @Test
    public void testInvertirCadena() {
        System.out.println("InvertirCadena");
        String cadena = "";
        String expResult = "";
        String result = Cadenas.InvertirCadena(cadena);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of sumarLetras method, of class Cadenas.
     */
    
    @Test
    public void testSumarLetras() {
        System.out.println("sumarLetras");
        String cadena = "";
        Cadenas instance = new Cadenas();
        String expResult = "";
        String result = instance.sumarLetras(cadena);
        assertEquals(expResult, result);
        
    }
}
