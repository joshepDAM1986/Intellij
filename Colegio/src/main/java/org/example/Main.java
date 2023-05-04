package org.example;

public class Main {
    public static void main(String[] args) {
        Alumno a = new Alumno("Carlos",
                "López", (byte) 58);
        Alumno b = new Alumno("María",
                "Argüelles", (byte) 23);
        Alumno c = new Alumno("Fabio",
                "CIDEP", (byte) 22);
        Alumno d = new Alumno("Carmen",
                "Ruiz", (byte)  30);


        Fichero.escribir(a, "alumnos.bin");
        Fichero.escribir(b, "alumnos.bin");
        Fichero.escribir(c, "alumnos.bin");
        Fichero.escribir(d, "alumnos.bin");

        a.setNombre("Pepe");
        a.setApellidos("Gómez");
        a.setEdad((byte)27);
        b.setNombre("Ana");

        Fichero.actualizar(a, "alumnos.bin", 1);
        Fichero.actualizar(b, "alumnos.bin", 2);
        Alumno e = Fichero.leer("alumnos.bin", 2);
        System.out.println("Leido: " + e.getNombre() + " "
                + e.getApellidos() + " " + e.getEdad());
        Fichero.listar("alumnos.bin");
    }
}