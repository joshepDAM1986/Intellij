
package com.mycompany.e_bucles_multiplos;

/**
 *
 * @author damci
 */

//Mostrar numero multiplos de 2 y 3 de entre (1 y 100)

public class E_bucles_multiplos 
{

    public static void main(String[] args) 
    {
        int i=0;
        for (i=0;i<=100;i++)
        {
            if (i%2==0 && i%3==0)
            System.out.println(i); 
        }
    }
}
