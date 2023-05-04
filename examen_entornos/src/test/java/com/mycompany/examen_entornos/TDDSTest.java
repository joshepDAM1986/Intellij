
package com.mycompany.examen_entornos;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author garci
 */

public class TDDSTest {
    
    @Rule
    public ExpectedException exception=ExpectedException.none();            

    @Test
    public void testSuma() {
        System.out.println("suma");
        
        int a = 2;
        int b = 5;
        
        TDDS instance = new TDDS();
        
        int expResult = 7;
        int result = instance.suma(a, b);
        assertEquals(expResult, result);
    }

    @Test(expected=ArithmeticException.class)
    public void testDivision() {
        System.out.println("division");
        
        float a = 9.0F;
        float b = 2.0F;
        
        TDDS instance = new TDDS();
        
        float expResult = 4.5F;
        float result = instance.division(a, b);
        assertEquals(expResult, result, 0);
        
        a = 9.0F;
        b = 0.0F;
        
        expResult = 0.0F;
        result = instance.division(a, b);
        assertEquals(expResult, result, 0);
        
        exception.expectMessage("No se puede dividir por cero.");
    }
    
    @Test
    public void testMayorDeEdad() {
        System.out.println("mayorDeEdad");
        
        int edad = 9;
        
        TDDS instance = new TDDS();
        
        String expResult = "Es menor de edad";
        String result = instance.mayorDeEdad(edad);
        assertEquals(expResult, result);
        
        edad = 19;
        expResult = "Es mayor de edad";
        result = instance.mayorDeEdad(edad);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testOfuscar() {
        System.out.println("ofuscar");
        
        String cadena = "hola";
        
        TDDS instance = new TDDS();
        
        String expResult = "hola";
        String result = instance.ofuscar(cadena);
        assertNotEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConE() {   
        System.out.println("conE");
        
        String cadena = "patata";
        
        TDDS instance = new TDDS();
        
        String expResult = "petete";
        String result = instance.conE(cadena);
        assertEquals(expResult, result);
        
        cadena = "abcdefghijk";
        instance.conE(cadena);
        exception.expectMessage("No se puede introducir cadenas 10 o más caracteres.");
    }
    
    /*
    @Test(expected=IllegalArgumentException.class)
    public void testInvertirParte() {

        System.out.println("invertirParte");

        TDDS instance = new TDDS();
        String[] cadena = {"piña", "pera", "plátano", "kiwi"};
        String[] expResult = {"piña", "kiwi", "plátano", "pera"};
        String[] result = instance.invertirParte(cadena);
        assertArrayEquals(expResult, result);
        
        String[] cadena2 = {"piña", "pera", "plátano", "kiwi", "melón"};
        instance.invertirParte(cadena2);
      */  
}
 



