

package com.mycompany.examen_ejercicio;

/**
 *
 * @author damci
 */

public class Examen_ejercicio 
{

    public static void main(String[] args) 
    {
        for (int i=100;i<=1000;i= i + 2)
        {
            if (i%6==0 && i%7==0)
            {
                System.out.println(i);
                break;
            }
        }
    }
}
