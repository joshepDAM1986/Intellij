package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Semaphore[] palillos = new Semaphore[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            palillos[i] = new Semaphore(1);
        }

        Thread[] hilosFilosofos = new Thread[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            hilosFilosofos[i] = new Thread(new Filosofo(i, palillos));
            hilosFilosofos[i].start();
        }
    }
}