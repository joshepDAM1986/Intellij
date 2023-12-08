package org.example;

public class Main {
    public static void main(String[] args) {
        Deposito cian = new Deposito("Cian");
        Deposito magenta = new Deposito("Magenta");
        Deposito amarillo = new Deposito("Amarillo");

        // Crear personas que intentan preparar nuevos colores
        Thread rojoThread = new Thread(new Persona("Rojo", amarillo, magenta));
        Thread azulThread = new Thread(new Persona("Azul", magenta, cian));
        Thread verdeThread = new Thread(new Persona("Verde", amarillo, cian));

        // Iniciar hilos
        rojoThread.start();
        azulThread.start();
        verdeThread.start();
    }
}