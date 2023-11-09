package org.example;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread h1 = new Thread(new Hilo("H1"));
        Thread h2 = new Thread(new Hilo("H2"));

        h1.start();
        h2.start();

        //Hilo main espera 1 seg
        TimeUnit.MICROSECONDS.sleep(2500);
        System.out.println("Hilo principal terminado.");
    }
}