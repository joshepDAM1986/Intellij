
package com.mycompany.email;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author damci
 */

public class Email {

    public static void main(String[] args) {
        System.out.println("Introduzca su email");
        Scanner sc=new Scanner(System.in);
        String regExMail="[a-zA-Z0-9 +&*-]+(?:\\.[a-zA-Z0-9 +&*-]+)*@"
                        +"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}";
     
        String correo=sc.next();
        boolean esCorreo=Pattern.matches(regExMail, correo);
        if (esCorreo)
        {
            System.out.println("Correo registrado");
        }
        else 
        {
            System.out.println("Correo inválido");
        }
        if (Pattern.matches(regExMail, correo))
        {
            System.out.println("Correo registrado");
        }
        else
        {
            System.out.println("Correo inválido");
        }
    }
}