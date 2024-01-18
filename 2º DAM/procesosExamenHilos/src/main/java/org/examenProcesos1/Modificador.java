package org.examenProcesos1;
public class Modificador {
    private final Memoria c;

    public Modificador(Memoria c) {
        this.c = c;
    }
    public void modificar() {
        int numHilos = 8;
        Thread[] hilos = new Thread[numHilos];

        for (int i = 0; i < numHilos; i++) {
            int j = i;
            hilos[i] = new Thread(() -> {
                for (int k = j; k < Memoria.ELEMENTOS; k += numHilos) {
                    c.activarDato(k);
                    c.incrementarContador();
                }
            });
            hilos[i].start();
        }

        try {
            for (Thread hilo : hilos) {
                hilo.join(); // Espera a que cada hilo termine
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getContador() {
        return c.getContador();
    }
}