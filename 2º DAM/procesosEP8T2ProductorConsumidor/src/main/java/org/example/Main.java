package org.example;

public class Main {
    public static void main(String[] args) {
        ColaSincronizada cola = new ColaSincronizada();

        // Crear hilos para productor y consumidor
        Thread productorThread = new Thread(new Productor(cola));
        Thread consumidorThread = new Thread(new Consumidor(cola));

        // Iniciar hilos
        productorThread.start();
        consumidorThread.start();
    }
}