package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Almacen {
    private int hojasLechuga = 6;
    private int tomates = 3;
    private int jamon = 500;
    private final Lock lock = new ReentrantLock();

    public int getHojasLechuga() {
        return hojasLechuga;
    }

    public int getTomates() {
        return tomates;
    }

    public int getJamon() {
        return jamon;
    }

    public void consumirIngredientes(int hojasLechugaConsumidas, int tomatesConsumidos, int jamonConsumido) {
        lock.lock();
        hojasLechuga -= hojasLechugaConsumidas;
        tomates -= tomatesConsumidos;
        jamon -= jamonConsumido;
        lock.unlock();
    }

    public void reponerLechuga() {
        lock.lock();
        hojasLechuga = Math.min(hojasLechuga + 6, 6);  // Reposición cada 8 horas, hasta la cantidad inicial
        System.out.println("Reponer lechuga: Cantidad actual = " + hojasLechuga);
        lock.unlock();
    }

    public void reponerTomates() {
        lock.lock();
        tomates = Math.min(tomates + 3, 3);  // Reposición cada 5 horas, hasta la cantidad inicial
        System.out.println("Reponer tomates: Cantidad actual = " + tomates);
        lock.unlock();
    }

    public void reponerJamon() {
        lock.lock();
        jamon = Math.min(jamon + 500, 500);  // Reposición cada 12 horas, hasta la cantidad inicial
        System.out.println("Reponer jamón: Cantidad actual = " + jamon);
        lock.unlock();
    }
}
