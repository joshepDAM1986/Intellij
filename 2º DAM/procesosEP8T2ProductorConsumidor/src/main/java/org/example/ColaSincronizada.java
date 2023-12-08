package org.example;

import java.util.ArrayList;
public class ColaSincronizada {
    private ArrayList<Integer> contenedor = new ArrayList<>();

    public synchronized void put(int valor) {
        try {
            // Simular tiempo de espera aleatorio para el proceso productor
            Thread.sleep((int) (Math.random() * 1001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        contenedor.add(valor);
        System.out.println("Productor produce: " + valor);
        notify();  // Notificar a los consumidores que hay un nuevo elemento en la cola
    }

    public synchronized int get() {
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

        int valor = contenedor.remove(0);
        System.out.println("Consumidor consume: " + valor);
        return valor;
    }
}
