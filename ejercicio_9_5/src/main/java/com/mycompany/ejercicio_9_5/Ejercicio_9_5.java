
package com.mycompany.ejercicio_9_5;

import java.util.*;

/**
 *
 * @author garci
 */
public class Ejercicio_9_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de alumnos: ");
        int numAlumnos = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        TreeSet<Alumno> Alumnos = new TreeSet<>();

        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Introduce los datos del alumno " + (i+1) + ":");
            System.out.print("Apellido1: ");
            String apellido1 = sc.nextLine();
            System.out.print("Apellido2: ");
            String apellido2 = sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nacionalidad: ");
            String nacionalidad = sc.nextLine();

            Alumno alumno = new Alumno(nombre, apellido1, apellido2, nacionalidad);
            Alumnos.add(alumno);
        }

        System.out.println("\nResumen de alumnos:");
        for (Alumno alumno : Alumnos) {
            System.out.println(alumno);
        }
    }
}