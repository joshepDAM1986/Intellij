
package com.mycompany.herencia;

/**
 *
 * @author garci
 */

public class B extends A {
    
    public B() { 
        System.out.println("En constructor B");
    }
    
    public B(String mensaje){
        super(mensaje);
        System.out.println("B: "+mensaje);
    }
    
    public B(int numero){
        super(numero);
        System.out.println("B: "+numero);
    } 
}
