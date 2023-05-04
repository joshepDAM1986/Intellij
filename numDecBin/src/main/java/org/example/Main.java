package org.example;


import java.util.Scanner;
import static org.example.decToBin.decBin;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Introduzca numero mayor a 0: ");
            n = sc.nextInt();
            System.out.print("");
            System.out.print("Binario: ");
            decBin(n);
            System.out.println("");
        }
        while (n<0);

    }
}