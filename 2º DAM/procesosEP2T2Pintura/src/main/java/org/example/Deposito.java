package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Deposito {
    private final String color;
    private final Lock lock = new ReentrantLock();

    public Deposito(String color) {
        this.color = color;
    }

    public void obtenerAcceso() {
        lock.lock();
        System.out.println("Persona en hilo " + Thread.currentThread().getId() + " obtuvo acceso a " + color);
    }

    public void liberarAcceso() {
        System.out.println("Persona en hilo " + Thread.currentThread().getId() + " liberó acceso a " + color);
        lock.unlock();
    }
    public String getColor() {
        return color;
    }
}

