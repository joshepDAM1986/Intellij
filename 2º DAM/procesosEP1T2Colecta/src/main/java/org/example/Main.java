package org.example;

public class Main {
    public static void main(String[] args) {
        Colecta colecta = new Colecta();

        // Crear hilos
        Thread hilo1 = new Thread(new Hilo(colecta));
        Thread hilo2 = new Thread(new Hilo(colecta));
        Thread hilo3 = new Thread(new Hilo(colecta));
        Thread hilo4 = new Thread(new Hilo(colecta));

        // Iniciar hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        // Esperar a que todos los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

