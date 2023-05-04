
package com.mycompany.examen_entornos;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author garci
 */

public class LetraNifTest {
    
    @Rule
    public ExpectedException exception=ExpectedException.none();

    @Test(expected=IllegalArgumentException.class)
    public void testCalcularLetraDNI() {
        System.out.println("calcularLetraDNI");
        int dni = 11778777;
        char expResult = 'V';
        char result = LetraNif.calcularLetraDNI(dni);
        assertEquals(expResult, result);
        
        dni = 12345678;
        expResult = 'Z';
        result = LetraNif.calcularLetraDNI(dni);
        assertEquals(expResult, result);
        
        dni = 75162631;
        expResult = 'B';
        result = LetraNif.calcularLetraDNI(dni);
        assertEquals(expResult, result);
        
        dni = 999999999;
        result = LetraNif.calcularLetraDNI(dni);
        assertEquals(expResult, result);
    }
}
    

