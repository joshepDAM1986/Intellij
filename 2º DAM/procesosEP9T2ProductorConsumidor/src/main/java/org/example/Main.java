package org.example;

public class Main {
    public static void main(String[] args) {
        ColaSincronizada cola = new ColaSincronizada();

        // Crear varios hilos para productores
        Thread productor1 = new Thread(new Productor("P1", cola));
        Thread productor2 = new Thread(new Productor("P2", cola));

        // Crear varios hilos para consumidores
        Thread consumidor1 = new Thread(new Consumidor(cola));
        Thread consumidor2 = new Thread(new Consumidor(cola));

        // Iniciar hilos
        productor1.start();
        productor2.start();

        consumidor1.start();
        consumidor2.start();
    }
}