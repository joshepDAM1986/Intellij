package org.example;



public class Proceso implements Runnable {
    private final String nombre;
    private final RecursoCompartido recurso;
    private final int cantidadNecesaria;

    public Proceso(String nombre, RecursoCompartido recurso, int cantidadNecesaria) {
        this.nombre = nombre;
        this.recurso = recurso;
        this.cantidadNecesaria = cantidadNecesaria;
    }

    @Override
    public void run() {
        while (true) {
            int cantidadObtenida = recurso.obtenerCantidad(cantidadNecesaria);
            realizarActividad(cantidadObtenida);
        }
    }

    private void realizarActividad(int cantidad) {
        // Simular tiempo de actividad
        try {
            Thread.sleep((int) (Math.random() * 401) + 100);  // Entre 100 y 500 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nombre + ": Realizó actividad con cantidad = " + cantidad);
    }
}
