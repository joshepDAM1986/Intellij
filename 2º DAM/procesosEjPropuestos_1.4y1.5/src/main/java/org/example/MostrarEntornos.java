package org.example;

import java.util.Map;
public class MostrarEntornos {
    public static void mostrarEntorno() {
        // Creamos el proceso
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Obtenemos el entorno de ejecución del proceso
        Map<String, String> environment = processBuilder.environment();
        // Iterar sobre el Map y mostrar cada entrada usando un bucle for
        System.out.println("Entorno de ejecución del proceso:");
        for (String key : environment.keySet()) {
            String value = environment.get(key);
            System.out.println(key + ": " + value);
        }
    }
}

