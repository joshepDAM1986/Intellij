package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
public class RecursoCompartido {
    private int cantidadDisponible = 0;
    private final int LIMITE_ALMACENAMIENTO = 600;
    private final Lock lock = new ReentrantLock();
    private final Condition suficienteCantidad = lock.newCondition();

    public int obtenerCantidad(int cantidadSolicitada) {
        lock.lock();
        try {
            while (cantidadDisponible < cantidadSolicitada) {
                suficienteCantidad.await();
            }

            int cantidadObtenida = Math.min(cantidadSolicitada, cantidadDisponible);
            cantidadDisponible -= cantidadObtenida;
            return cantidadObtenida;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0;
        } finally {
            lock.unlock();
        }
    }

    public void suministrarCantidad() {
        lock.lock();
        try {
            int cantidadSuministrada = (int) (Math.random() * 71) + 50;  // Entre 50 y 120
            cantidadDisponible = Math.min(cantidadDisponible + cantidadSuministrada, LIMITE_ALMACENAMIENTO);
            System.out.println("Suministrador: Suministrada cantidad = " + cantidadSuministrada + " | Cantidad disponible = " + cantidadDisponible);

            // Despierta a los hilos esperando si hay suficiente cantidad
            suficienteCantidad.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
