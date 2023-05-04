package org.example;

import java.util.Scanner;

import static org.example.FiboNum.calcularFibonacci;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Introduzca el numero requerido: ");
            n = sc.nextInt();
            System.out.print("");
            System.out.print("La secuencia de " + n + " es: ");
            System.out.println(calcularFibonacci(n));
            System.out.println("");
        }
        while (n<0);
    }
}