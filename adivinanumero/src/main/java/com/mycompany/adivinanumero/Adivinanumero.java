

package com.mycompany.adivinanumero;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author damci
 */

public class Adivinanumero 
{
    
//Adivinar numero [1-10] 
//Pedir número
//        8
//!Has adivinado el numero!
//Inténtalo de nuevo
    

    public static void main(String[] args) 
    {
        int miNum=9;
        int tuNum=0;
        
System.out.print("Introduce un número entre 1 y 10: ");
            while (tuNum!=miNum)
            {
            Scanner sc=new Scanner (System.in);
           if (sc.hasNextInt());                       
                {
                   tuNum=sc.nextInt();
                }
                if (tuNum!=miNum)
                    {
                        System.out.println("Inténtalo de nuevo");
                    }
                else
                    {
                        System.out.println("¡Has adivinado el número!");
                    }
            }
    }
}
