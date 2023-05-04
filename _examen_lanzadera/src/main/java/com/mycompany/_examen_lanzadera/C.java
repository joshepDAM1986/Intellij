
package com.mycompany._examen_lanzadera;

/**
 *
 * @author garci
 */

public class C extends B{
    char c1 = 'z';

    public void metodoC(){
        System.out.println("metodoC en C");
    }

    @Override
    public void metodoSobrescrito() {
        System.out.println("metodoSobrescrito en C");
    }

    public C(){
        System.out.println("En constructor C");
    }

    public C(int numero){
        System.out.println("C:" + numero);
    }

    public C(String mensaje){
        System.out.println("C" + mensaje);
    }
}
