
package com.mycompany.ejemplo_junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author damci
 */

public class Test1Test {
    
    public Test1Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("setUpClass");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("tearDownClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUpClass antes de cada test");
        
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDownClass antes de cada test");
    }


    /**
     * Test of multiplica method, of class Test1.
     */
 
    @Test
    public void testMultiplica() {
        System.out.println("multiplica");
        int a = 2;
        int b = 2;
        Test1 instance = new Test1();
        int result = instance.multiplica(a, b);
        assertEquals(4, result);

    }

    /**
     * Test of factorial method, of class Test1.
     */
    
    @Test
    public void testFactorial() {
        System.out.println("factorial");
        int numero = 3;
        Test1 instance = new Test1();
        
        int result = instance.factorial(numero);
        assertEquals(6, result);
    }
    
    @Rule
    public ExpectedException exception=ExpectedException.none();

    @Test(expected=IllegalArgumentException.class)
    public void testSuma(){
        System.out.println("suma");
        int n1=4;
        int n2=5;
        //Given
        Test1 instance = new Test1();
        //When
        //int expResult = 10;
        int result = instance.suma(n1,n2);
        //Then
        assertEquals(9,result);
        
        //Probar excepcion
        n1=-9;
        n2=0;
        
        instance.suma(n1,n2);
        exception.expectMessage("No se aceptan valores negativos");
    }
    
    @Test
    public void testFactorialNegativo() {
        System.out.println("factorial negativo");
        int numero = -3;
        Test1 instance = new Test1();
        exception.expect(ArithmeticException.class);
        exception.expectMessage("El factorial de un numero negativo no existe");        
        int result = instance.factorial(numero);
        assertEquals(1, result);
    }
}
