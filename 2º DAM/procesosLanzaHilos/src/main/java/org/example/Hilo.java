package org.example;

public class Hilo implements Runnable {
    private final String nombre;

    // Constructor que recibe el nombre del hilo
    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener el nombre del hilo
    public String getNombre() {
        return nombre;
    }

    // Método run() que se ejecuta cuando se inicia el hilo
    @Override
    public void run() {
        System.out.printf("Hola soy el hilo: %s.\n", this.nombre);
        System.out.printf("Hilo %s ha terminado.\n", this.nombre);
    }
}
