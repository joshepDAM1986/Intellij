
package com.mycompany.consola2;

import java.util.Scanner;

/**
 *
 * @author damci
 */

public class Consola2 
{
    public static void main(String[] args) 
    {
        System.out.println("Introduzca el un número: ");
        Scanner sc= new Scanner(System.in);
        if (sc.hasNextInt())
            System.out.println("El número es: "+ sc.nextInt());
        else
        {
        String entradaTeclado=sc.nextLine();
        System.out.println(entradaTeclado +" no es un número");
        }
    }
}
