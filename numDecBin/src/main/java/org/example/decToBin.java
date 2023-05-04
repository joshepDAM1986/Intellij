package org.example;
public class decToBin {
    public static void decBin(int n) {
        if (n < 2) {
            System.out.print(n);
        }
        else {
            decBin(n / 2);
            System.out.print(n % 2);
        }
    }
}