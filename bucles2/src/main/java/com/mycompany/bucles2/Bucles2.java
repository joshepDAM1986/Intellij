
package com.mycompany.bucles2;

/**
 *
 * @author damci
 */

public class Bucles2 
{

    public static void main(String[] args) 
    {
        
// int i=0;
// int sum=0;
//
// for (i=0;i<=200; i++)
//        {
//            if (i%2==0)
//                {
//                sum+=i;
//                    System.out.println("sum= "+sum);
//                }
//        }
//        System.out.println("La suma de los 100 primeros numeros pares es " +sum);
        
        int i=0;
        int sigPar=0;
        int suma=0;
        
        for(i=0;i<=100;i++)
        {   
            System.out.println("Suma: "+sigPar);
            suma=suma+sigPar;
            sigPar+=2;
        }
        System.out.println("El valor final de i es "+i);
        System.out.println("El valor de la suma es "+suma);
    }   
}
