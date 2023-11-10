package org.example;

public class Hilo implements Runnable{
    private final String nombre;
    public Hilo(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public void run(){

        System.out.printf("Hola soy el hilo: %s.\n", this.nombre);
        System.out.printf("Hilo %s ha terminado.\n", this.nombre);
    }
}
