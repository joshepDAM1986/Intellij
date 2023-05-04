package org.example;

public class Recursividad {
    public static boolean esBinario(int n) {
        if (n == 0 || n == 1){
            return true;
        }
        else if (n>9) {
            if ((n % 10 == 0) || (n % 10 == 1)) {
                return esBinario(n / 10);
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }
}
