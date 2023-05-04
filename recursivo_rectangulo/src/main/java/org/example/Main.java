package org.example;

public class Main {
        public static void main(String[] args) {
            rectangulo(10, 3); // rectangulo de base 10 y altura 3
        }

        public static void rectangulo(int b, int a) {
            if (a <= 0) {
                System.out.print("");
            }
            else {
                for(int i = 0; i < b; ++i) {
                    System.out.print("*");
                }
                System.out.println();
                rectangulo(b, a - 1);
            }
        }
    }