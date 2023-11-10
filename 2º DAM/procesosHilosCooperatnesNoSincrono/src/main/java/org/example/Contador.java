package org.example;

import java.util.concurrent.SynchronousQueue;

public class Contador {
    private int cuenta=0;

    public Contador() {
        this.cuenta = cuenta;
    }
    public synchronized int getCuenta() {
        return cuenta;
    }
    public synchronized int incrementa(){
        cuenta++;
        return cuenta;
    }
}
