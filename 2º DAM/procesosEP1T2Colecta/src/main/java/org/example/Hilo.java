package org.example;

public class Hilo implements Runnable{
    private Colecta colecta;

    public Hilo(Colecta colecta) {
        this.colecta = colecta;
    }

    @Override
    public void run() {
        while (colecta.consultarCantidadRecogida() < 2000) {
            colecta.realizarColecta();

            // Introducir un pequeño retraso para simular el tiempo aleatorio de colecta
            try {
                Thread.sleep((int) (Math.random() * 191) + 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

