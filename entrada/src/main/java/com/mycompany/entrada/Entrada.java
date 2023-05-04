
package com.mycompany.entrada;

/**
 *
 * @author damci
 */

public class Entrada 
{
    public static void main(String[] args) 
    {
        String parametro1=args[0];
        String parametro2=args[1];
        String parametro3=args[2];
        String parametro4=args[3];
        
        int p1=Integer.parseInt(parametro1);
        int p2=Integer.parseInt(parametro2);
        int p3=Integer.parseInt(parametro3);
        int p4=Integer.parseInt(parametro4);
        
        int suma=p1+p2+p3+p4;
        System.out.println(suma);
    }
}
