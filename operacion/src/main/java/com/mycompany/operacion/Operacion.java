
package com.mycompany.operacion;

/**
 *
 * @author damci
 */

public class Operacion {
    
    public int suma;
   
    public void sumar(int a, int b)
    {
        int suma= a+b;
        this.suma=suma;
  
    }
    
    public static void main(String[] args) 
    {
        Operacion op=new Operacion();
        op.sumar(8,9);
        //op.suma=3;
        System.out.println(op.suma);
    }
}



