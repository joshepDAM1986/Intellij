package org.example;

public class Main {
    public static void main(String[] args) {
        Aparcamiento aparcamiento = new Aparcamiento();

        // Programa principal que crea hilos de coches cada cierto tiempo
        for (int i = 1; i <= 100; i++) {
            int matricula = i;
            Thread cocheThread = new Thread(new Coche(matricula, aparcamiento));

            // Iniciar hilo del coche
            cocheThread.start();

            // Simular tiempo entre la creación de coches (500 a 3000 ms)
            try {
                Thread.sleep((int) (Math.random() * 2501) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}