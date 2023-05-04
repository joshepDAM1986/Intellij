
package com.mycompany.variables;

/**
 *
 * @author damci
 */

public class Variables 
{
    public static void main(String[] args) 
    {
        byte a=10;
        int b=60000;
        float c=8.3f;
        char d='A';
        char e= (char)(d+2);
        final double PI=3.1416d;
        final String LENGUAJE = "JAVA";
        
        System.out.println("El valor de a es " +a);
        System.out.println("El valor de b es " +b);
        System.out.println("El valor de c es " +c);
        System.out.println("El valor de d es " +d);
        System.out.println("El valor de e es " +e);
        
        System.out.println("El resultado de a x b es "+(a*b));
        System.out.println("El resultado de b x c es "+(b*c));
        System.out.println("El resultado de (c + PI) es "+(c+PI));
        System.out.println("Programo en "+LENGUAJE);
    }
}