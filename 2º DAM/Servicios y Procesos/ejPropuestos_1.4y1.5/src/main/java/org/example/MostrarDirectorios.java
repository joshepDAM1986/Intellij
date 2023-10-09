package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class MostrarDirectorios {
    public static void mostrarDirectorio() {
//        // Obtener el directorio por defecto de ejecución
//        File directorioDefecto = new File(System.getProperty("user.dir"));
//        System.out.println("Directorio por defecto: " + directorioDefecto);
//
//        // Crear un proceso para ejecutar el comando "dir" en el directorio por defecto
//        ejecutarCommando("cmd.exe", "/c", "dir", directorioDefecto.getAbsolutePath());
//
//        // Crear un nuevo directorio para la segunda ejecución
//        File nuevoDirectorio = new File("nuevo_directorio");
//        nuevoDirectorio.mkdir();
//
//        System.out.println("Ejecutando 'dir' en el nuevo directorio: " + nuevoDirectorio);
//
//        // Ejecutar el comando "dir" en el nuevo directorio
//        ejecutarCommando("cmd.exe", "/c", "dir", nuevoDirectorio.getAbsolutePath());
//
//        // Limpiar el directorio creado después de usarlo
//        nuevoDirectorio.delete();
//    }
//
//    private static void ejecutarCommando(String... command) {
//        ProcessBuilder processBuilder = new ProcessBuilder(command);
//        processBuilder.inheritIO(); // Mostrar la salida en la consola actual
//
//        try {
//            Process process = processBuilder.start();
//            int exitCode = process.waitFor();
//
//            if (exitCode == 0) {
//                System.out.println("Comando ejecutado correctamente");
//            } else {
//                System.err.println("Error al ejecutar el comando. Código de salida: " + exitCode);
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
            pb.inheritIO();
            File directorioActual = new File(System.getProperty("user.dir"));
            File directorioOriginal = new File(directorioActual.getParent());

            pb.directory(directorioActual);
            Process p = pb.start();

            System.out.println(p.isAlive());
            Thread.sleep(5000);
            System.out.println(p.isAlive());

            pb.directory(directorioOriginal);
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}