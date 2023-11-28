package org.example;

public class Main {
    public static void main(String[] args) {
            Cuenta c1 = new Cuenta ("ES1512345678901234567890", 12500);
            Cuenta c2 = new Cuenta ("ES4578901234567890123456", 23400);
            System.out.printf("Saldo inicial de %s: %d\n", c1.getNumCuenta(), c1.getSaldo());
            System.out.printf("Saldo inicial de %s: %d\n", c2.getNumCuenta(), c2.getSaldo()); System.out.println(". -");
            // Dos hilos: uno hace transferencias de cl a c2, otro de c2 a cl
            Thread h1 = new Thread(new Hilo (c1, c2, "H1"));
            Thread h2 = new Thread(new Hilo (c2, c1, "H2"));
            h1.start();
            h2.start();
            try {
                h1.join();
                h2.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("."); System.out.printf("Saldo final %s: %d\n", c1.getNumCuenta(), c1.getSaldo());
            System.out.printf("Saldo final %s: %d\n", c2.getNumCuenta(), c2.getSaldo());
        }
    }