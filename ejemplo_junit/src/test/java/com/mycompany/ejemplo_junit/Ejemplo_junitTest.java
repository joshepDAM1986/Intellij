
package com.mycompany.ejemplo_junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author damci
 */
public class Ejemplo_junitTest {
    
    public Ejemplo_junitTest() {
    }

    /**
     * Test of main method, of class Ejemplo_junit.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Ejemplo_junit.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
