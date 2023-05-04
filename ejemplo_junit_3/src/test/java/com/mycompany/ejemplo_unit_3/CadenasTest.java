
package com.mycompany.ejemplo_unit_3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author garci
 */

public class CadenasTest {
    
    public CadenasTest() {
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
