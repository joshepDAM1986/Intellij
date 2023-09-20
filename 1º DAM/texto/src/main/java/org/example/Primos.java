package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Primos {

    public static void main(String[] args) {

        int n = 10;
        String resultado = "primos.txt";

        buscarPrimos(n, resultado);
    }

    /**
     * Método para mostrar los números primos menores que "n"
     *
     * @param n
     * @param f
     */
    public static void buscarPrimos(int n, String f) {

        try {
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);

            if (n >= 2) {
                if (esPrimo(n)) {
                    System.out.println(n);
                    pw.println(n);
                    pw.flush();
                }
                buscarPrimos(--n, f);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Excepción " + e);
        }
    }


    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//        // FORMA ITERATIVA
//        for(int i=2; i<=n; i++) {
//            if(esPrimo(i)) {
//                System.out.println(i);
//            }
//        }

        // FORMA RECURSIVA
//        if(n>=2) {
//            buscarPrimos(n-1, f);
//            if(esPrimo(n)) {
//                System.out.println(n);
//                pw.println(n);
//            }
//        }


