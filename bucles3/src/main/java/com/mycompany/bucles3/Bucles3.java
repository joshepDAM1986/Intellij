
package com.mycompany.bucles3;

import java.util.Scanner;

/**
 *
 * @author damci
 */

//Pedir por pantalla un numero
//muestra cuenta decreciente con asteriscos
//*****
//****
//***
//**
//*

public class Bucles3 
{

    public static void main(String[] args) 
    {
        int contador=0;
        Scanner sc=new Scanner (System.in);
        System.out.println("Escribe el numero de estrellas");
        
        if (sc.hasNextInt())
           contador=sc.nextInt();
        {
            for (int i=contador;i>0;i--)
            {   
                for(int j=i;j>0;j--)
                {
                    System.out.print("*");

                }    
                System.out.println("");
            }
        }
    }
}

