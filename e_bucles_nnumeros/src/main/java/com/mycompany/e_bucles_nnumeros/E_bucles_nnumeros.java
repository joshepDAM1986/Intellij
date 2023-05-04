
package com.mycompany.e_bucles_nnumeros;

import java.util.Scanner;

/**
 *
 * @author damci
 */

//Pedir por pantalla numero
//productos sucesivos hasta este numero desde 0

public class E_bucles_nnumeros 
{
    public static void main(String[] args) 
    {
    
        int i=0;
        int j=0;
        long resultado=1;
        
        Scanner sc=new Scanner (System.in);
        System.out.print("Introduce un número: ");
        j=sc.nextInt();
            for(i=1;i<=j;i++)
            {
                resultado=resultado*i;
                System.out.print(i);
                if (i==j)
                break;
                else
                System.out.print(" x ");   
            }
            System.out.print(" = "+resultado);
    }
}

