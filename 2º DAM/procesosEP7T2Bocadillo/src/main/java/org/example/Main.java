package org.example;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        // Crear hilos para personas
        Thread persona1 = new Thread(new Persona("Persona 1", almacen));
        Thread persona2 = new Thread(new Persona("Persona 2", almacen));
        Thread persona3 = new Thread(new Persona("Persona 3", almacen));
        Thread persona4 = new Thread(new Persona("Persona 4", almacen));

        // Crear hilos para reposición de ingredientes
        Thread reposicionLechuga = new Thread(new ReposicionLechuga(almacen));
        Thread reposicionTomates = new Thread(new ReposicionTomates(almacen));
        Thread reposicionJamon = new Thread(new ReposicionJamon(almacen));

        // Iniciar hilos
        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();

        reposicionLechuga.start();
        reposicionTomates.start();
        reposicionJamon.start();
    }
}