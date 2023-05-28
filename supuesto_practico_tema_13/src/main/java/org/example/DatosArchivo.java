package org.example;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;


public class DatosArchivo {
    public static void importarDatos(EntityManager em) {
        String datos = "datos_empleados.txt";
        em.getTransaction().begin();
        boolean datosDuplicados = false; // Variable para verificar si se encontraron datos duplicados
        try (BufferedReader br = new BufferedReader(new FileReader(datos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("#");

                String dni = campos[0];
                // Verificar si el empleado ya existe en la base de datos
                if (em.find(Empleado.class, dni) != null) {
                    datosDuplicados = true;
                    break; // Salir del bucle si se encontraron datos duplicados
                }

                String apellido1 = campos[1];
                String apellido2 = campos[2];
                String nombre = campos[3];
                LocalDate fechaNacimiento = LocalDate.parse(campos[4]);
                LocalDate fechaIncorporacion = LocalDate.parse(campos[5]);
                String puesto = campos[6];

                Empleado empleado = new Empleado(dni, nombre, apellido1, apellido2, fechaNacimiento, fechaIncorporacion, puesto);
                em.persist(empleado);
            }

            if (datosDuplicados) {
                System.out.println("Los datos ya existen en la base de datos.");
                em.getTransaction().commit();
            } else {
                em.getTransaction().commit();

                System.out.println("\nDatos de archivo insertados\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



