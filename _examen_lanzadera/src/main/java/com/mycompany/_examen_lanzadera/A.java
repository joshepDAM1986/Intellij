
package com.mycompany._examen_lanzadera;

/**
 *
 * @author garci
 */
public class A {
    String c1 = "A1";
    String c2 = "A2";

    public void metodoA(){
        System.out.println("MetodoA en A");
    }

    public void metodoSobrescrito(){
        System.out.println("metodoSobrescrito en A");

    }

    public A(){
        System.out.println("En constructor A");
    }

    public A(int numero){
        System.out.println("A:" + numero);
    }

    public A(String mensaje){
        System.out.println("A" + mensaje);
    }

}