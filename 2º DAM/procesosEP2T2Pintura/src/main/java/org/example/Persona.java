package org.example;

public class Persona implements Runnable {
    private final String nombre;
    private final Deposito color1;
    private final Deposito color2;

    public Persona(String nombre, Deposito color1, Deposito color2) {
        this.nombre = nombre;
        this.color1 = color1;
        this.color2 = color2;
    }

    @Override
    public void run() {
        while (true) {
            prepararColor();
            descansar();
        }
    }

    private void prepararColor() {
        color1.obtenerAcceso();
        System.out.println(nombre + " está utilizando " + color1.getColor());

        color2.obtenerAcceso();
        System.out.println(nombre + " está utilizando " + color2.getColor());

        // Simular tiempo de preparación
        try {
            Thread.sleep((int) (Math.random() * 401) + 100);  // Entre 100 y 500 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Liberar depósitos
        color1.liberarAcceso();
        color2.liberarAcceso();

        System.out.println(nombre + " ha preparado el color.");
    }

    private void descansar() {
        // Simular tiempo de descanso antes de volver a intentar preparar
        try {
            Thread.sleep((int) (Math.random() * 1001) + 1000);  // Entre 1 y 2 s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

