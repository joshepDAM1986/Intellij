
package com.mycompany.recursivo_numeroinvertido;

import java.util.Scanner;

/**
 *
 * @author garci
 */

public class Recursivo_numeroinvertido {   
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n = sc.nextInt();
        System.out.print("resultado: ");
        invertir(n);
        }
    
    public static void invertir(long n) {
        if(n < 10) {
         System.out.print(n);
        }
        else {
            System.out.print(n % 10);
        invertir(n / 10);
       }
    }
}

    


