package org.example;

class Consumidor implements Runnable {
    private ColaSincronizada cola;

    public Consumidor(ColaSincronizada cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (true) {
            cola.get();
        }
    }
}