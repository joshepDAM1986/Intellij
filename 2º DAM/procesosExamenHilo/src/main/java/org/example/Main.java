package org.example;public class Main {
    public static void main(String[] args) {
        long tiempoInicial = System.currentTimeMillis();
        Memoria c = new Memoria();
        Modificador e = new Modificador(c);

        // Número de hilos a utilizar
        int numThreads = 8;

        // Crear un pool de hilos
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        System.out.println("Comienzo del proceso de los datos");

        // Ejecutar tareas en paralelo utilizando hilos
        for (int i = 0; i < numThreads; i++) {
            executorService.execute(() -> e.modificar());
        }

        // Apagar el pool de hilos después de que todas las tareas estén completas
        executorService.shutdown();

        // Esperar a que todas las tareas se completen
        while (!executorService.isTerminated()) {
            Thread.yield();
        }

        System.out.println(("Contador de datos modificados: " + e.getContador()));
        System.out.println("Finalización del proceso de los datos: "
                + (System.currentTimeMillis() - tiempoInicial) / 1000 + " segundos");
    }
}