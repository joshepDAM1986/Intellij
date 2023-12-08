package org.example;

import java.util.ArrayList;
class ColaSincronizada {
    private ArrayList<String> contenedor = new ArrayList<>();
    private static final int CAPACIDAD_MAXIMA = 10;

    public synchronized void put(String dato) {
        while (contenedor.size() == CAPACIDAD_MAXIMA) {
            try {
                // Esperar si el contenedor está lleno
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Simular tiempo de espera aleatorio para el proceso productor
        try {
            Thread.sleep((int) (Math.random() * 1001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        contenedor.add(dato);
        System.out.println("Productor produce: " + dato);
        notify();  // Notificar a los consumidores que hay un nuevo elemento en la cola
    }

    public synchronized String get() {
        while (contenedor.isEmpty()) {
            try {
                // Esperar si la cola está vacía
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Simular tiempo de espera aleatorio para el proceso consumidor
        try {
            Thread.sleep((int) (Math.random() * 501));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String dato = contenedor.remove(0);
        System.out.println("Consumidor consume: " + dato);
        notify();  // Notificar a los productores que se ha consumido un elemento
        return dato;
    }
}