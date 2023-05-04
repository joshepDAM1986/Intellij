

package com.mycompany.excepciones;

import java.util.Scanner;

/**
 *
 * @author damci
 */

public class Excepciones 
{

    public static void main(String[] args) 
    {
        int a=0;
        int b=0;
        try
        {
            
            Scanner sc=new Scanner (System.in);
            System.out.println("Introduzca el dividendo");
            int dividendo=Integer.parseInt(sc.nextLine());
            System.out.println("Introduzca un divisor");
            int divisor=Integer.parseInt(sc.nextLine());
            System.out.println("El resuletado de la división de "+dividendo+" y "+divisor+" es "+dividendo/divisor);
        }
        catch (Exception ex)
                {
                    
                    System.out.println("Exception: "+ex.getMessage());
                    ex.printStackTrace();
                }
        finally
        {
            System.out.println("Fin del programa división");
        }
    }
}
