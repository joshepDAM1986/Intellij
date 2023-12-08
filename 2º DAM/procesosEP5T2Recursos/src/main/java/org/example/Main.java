package org.example;

public class Main {
    public static void main(String[] args) {
        RecursoCompartido recurso = new RecursoCompartido();

        // Crear hilo suministrador
        Thread suministradorThread = new Thread(() -> {
            while (true) {
                recurso.suministrarCantidad();
                try {
                    Thread.sleep(1000);  // Suministrar cada segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Crear 10 hilos para los procesos
        Thread[] procesoThreads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            procesoThreads[i] = new Thread(new Proceso("Proceso " + (i + 1), recurso, (int) (Math.random() * 16) + 10));  // Entre 10 y 25
        }

        // Iniciar hilos
        suministradorThread.start();
        for (Thread procesoThread : procesoThreads) {
            procesoThread.start();
        }
    }
}