package org.example;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Se crean dos hilos con instancias de la clase Hilo
        Thread h1 = new Thread(new Hilo("H1"));
        Thread h2 = new Thread(new Hilo("H2"));

        // Se inician los hilos
        h1.start();
        h2.start();

        // El hilo principal espera 1.5 segundos
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Hilo principal terminado.");
    }
}
