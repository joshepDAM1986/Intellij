package org.example;

public class Main {
    public static void main(String[] args) {

        triangulo(4);
    }

    public static void triangulo(int a) {
        if (a == 0) {
            System.out.print("");
        }
        else
        {
            triangulo(a - 1);

            for(int i = 0; i < a; ++i) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}