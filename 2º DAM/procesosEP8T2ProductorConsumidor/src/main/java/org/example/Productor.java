package org.example;
class Productor implements Runnable {
    private ColaSincronizada cola;

    public Productor(ColaSincronizada cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        int valor = 1;

        while (true) {
            cola.put(valor++);
        }
    }
}