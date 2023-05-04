

package com.mycompany.bucles;

/**
 *
 * @author damci
 */

public class Bucles 
{
    public static void main(String[] args) 
    {
        int i=0;
        int suma=0;
        for(i=1;i<=10;i=i+1)
        {
            suma=suma+i; 
            System.out.println("i = "+i+" y suma = "+suma);
        }
        
        System.out.println("El valor final de i es "+i);
        System.out.println("El valor final de la suma es "+suma);
    }
}
