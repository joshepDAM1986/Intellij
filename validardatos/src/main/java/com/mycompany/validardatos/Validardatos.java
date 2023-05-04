
package com.mycompany.validardatos;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author damci
 */

public class Validardatos
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner (System.in, "ISO-8859-1");
        System.out.println("Introduzca su nombre");
        String nombre=sc.nextLine();
        System.out.println("Introduzca su teléfono");
        String regExTelefono="[6|7|9][0-9]{8}";
        String telefono=sc.next();
        
        if (Pattern.matches(regExTelefono, telefono))
        {
            System.out.println("Datos de usuario: ");
            System.out.println(nombre);
            System.out.println(telefono);
        }
        else
        {
            System.out.println("Datos de usuario: ");
            System.out.println(nombre);
            System.out.println("N/A");
        }
    }
}