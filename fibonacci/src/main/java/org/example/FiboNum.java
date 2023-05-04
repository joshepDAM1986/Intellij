package org.example;

public class FiboNum {
    public static int calcularFibonacci(int n) {
        if (n<2) {
            return n;
        } else {
            return calcularFibonacci (n-1) + calcularFibonacci(n-2);
        }
    }
}
