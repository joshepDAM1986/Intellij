package org.example;

class Productor implements Runnable {
    private ColaSincronizada cola;
    private String identificador;

    public Productor(String identificador, ColaSincronizada cola) {
        this.identificador = identificador;
        this.cola = cola;
    }

    @Override
    public void run() {
        int valor = 1;

        while (true) {
            String dato = identificador + "_" + valor++;
            cola.put(dato);
        }
    }
}