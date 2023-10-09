package org.example;

import java.util.Map;
public class MostrarEntornos {
    public static void mostrarEntorno() {
        // Crear un proceso builder
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Obtener el entorno de ejecución del proceso
        Map<String, String> environment = processBuilder.environment();

        // Iterar sobre el Map y mostrar cada entrada
        System.out.println("Entorno de ejecución del proceso:");
        for (Map.Entry<String, String> entry : environment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


