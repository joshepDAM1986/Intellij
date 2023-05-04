

package com.mycompany.consola3;

import java.io.Console;

/**
 *
 * @author damci
 */

public class Consola3 {

    public static void main(String[] args) {
        Console c=System.console();
                if (c==null)
                    System.err.println("No hay consola");
                else
                {
                    System.out.println("Introduzca su nombre: ");
                    String nombre=c.readLine();
                    System.out.println("Hola "+nombre);
                    System.out.println("Introduzca su password: ");
                    String password=String.valueOf(c.readPassword());
                    System.out.println("Su password es. "+password);
                }
                
                float bi=17000.20f;
                int iva=21;
                float total= 23.1290f;
                System.out.printf("Base Imponible: %010.2f%nIVA: %d.%nTotal: %.2f Euros", bi, iva, total);
    }
}
