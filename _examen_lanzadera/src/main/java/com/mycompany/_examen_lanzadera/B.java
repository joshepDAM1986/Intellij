
package com.mycompany._examen_lanzadera;

/**
 *
 * @author garci
 */
public class B extends A{

    int c1 = 1;

    public void metodoB(){
        System.out.println("metodoB en B");

    }

    @Override
    public void metodoSobrescrito(){
        System.out.println("metodoSobrescrito1 en B");
    }

    public B(){
        System.out.println("En constructor B");
    }

    public B(int numero){
        System.out.println("B:" + numero);
    }

    public B(String mensaje){
        System.out.println("B" + mensaje);
    }
}