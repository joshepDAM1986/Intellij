package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        {
            int numFilosofos = 5;
            Lock[] palillos = new ReentrantLock[numFilosofos];

            for (int i = 0; i < numFilosofos; i++) {
                palillos[i] = new ReentrantLock();
            }

            Thread[] hilosFilosofos = new Thread[numFilosofos];

            for (int i = 0; i < numFilosofos; i++) {
                hilosFilosofos[i] = new Thread(new Filosofo(i, palillos));
                hilosFilosofos[i].start();
            }
        }
    }
}