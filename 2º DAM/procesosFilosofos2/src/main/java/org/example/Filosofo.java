package org.example;

import java.util.concurrent.locks.Lock;

public class Filosofo implements Runnable {
    private final int id;
    private final Lock[] palillos;

    public Filosofo(int id, Lock[] palillos) {
        this.id = id;
        this.palillos = palillos;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 3000));
    }

    private void comer() throws InterruptedException {
        int izquierda = id;
        int derecha = (id + 1) % palillos.length;

        // Adquirir los palillos
        palillos[izquierda].lock();
        palillos[derecha].lock();

        System.out.println("Filósofo " + id + " está comiendo.");

        // Filósofo come
        Thread.sleep((long) (Math.random() * 3000));

        // Liberar los palillos
        palillos[izquierda].unlock();
        palillos[derecha].unlock();
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                comer();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

