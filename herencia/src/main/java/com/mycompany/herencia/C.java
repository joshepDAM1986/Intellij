
package com.mycompany.herencia;

/**
 *
 * @author garci
 */

public class C extends B {
    
    public C() { 
        System.out.println("En constructor C");
    }
    
    public C(String mensaje){
        super(mensaje);
        System.out.println("C: "+mensaje);
    }
    
    public C(int numero){
        super(numero);
        System.out.println("C: "+numero);
    }  
}
