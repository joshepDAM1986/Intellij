
package com.mycompany.saludo;

import java.util.Scanner;

/**
 *
 * @author damci
 */

public class Saludo {

    public static void main(String[] args) 
        {
            System.out.println("Introduce tu nombre");
            Scanner scanner=new Scanner(System.in);
            String nombre= scanner.nextLine();
            System.out.println("Hola "+nombre);
        }
}
