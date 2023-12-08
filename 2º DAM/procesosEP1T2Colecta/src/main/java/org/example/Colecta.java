package org.example;

public class Colecta {
    private final Object lock = new Object();
    private int cantidadRecogida = 0;

    public void realizarColecta() {
        synchronized (lock) {
            int cantidad = (int) (Math.random() * 22) + 4;
            cantidadRecogida += cantidad;
            System.out.println("Hilo " + Thread.currentThread().getId() + " recogió " + cantidad + " | Total: " + cantidadRecogida);

            if (cantidadRecogida >= 2000) {
                System.out.println("¡Colecta completada por hilo " + Thread.currentThread().getId() + "!");
            }
        }
    }

    public int consultarCantidadRecogida() {
        synchronized (lock) {
            return cantidadRecogida;
        }
    }
}