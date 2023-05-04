
package com.mycompany.ejercicio_9_5_alt;
import java.util.*;

/**
 *
 * @author garci
 */
public class Ejercicio_9_5_alt {

      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de alumnos: ");
        int numAlumnos = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

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
            listaAlumnos.add(alumno);
        }

        System.out.println("\nResumen de alumnos:");
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }
    }
}