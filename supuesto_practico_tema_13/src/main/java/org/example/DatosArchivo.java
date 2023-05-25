package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

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

    public static void insertarNuevoEmpleado(EntityManager em) {
            em.getTransaction().begin();
            Scanner sc=new Scanner(System.in);
            System.out.println("------ Alta Empleado ------");
            System.out.print("Ingrese el DNI del empleado: ");
            String dni = sc.nextLine();

            Empleado empleadoExistente = em.find(Empleado.class, dni);
            if (empleadoExistente != null) {
                System.out.println("El empleado con DNI " + dni + " ya existe en la base de datos.");
                em.getTransaction().rollback();
                return;
            }

            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();

            System.out.println("Ingrese primer apellido: ");
            String apellido1=sc.nextLine();

            System.out.println("Ingrese segundo apellido: ");
            String apellido2=sc.nextLine();

            System.out.println("Ingrese la fecha de nacimiento: ");
            System.out.print("Ingrese el año: ");
            int año = sc.nextInt();
            System.out.print("Ingrese el mes: ");
            int mes = sc.nextInt();
            System.out.print("Ingrese el dia: ");
            int dia = sc.nextInt();
            sc.nextLine();
            LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);

            System.out.println("Ingrese la fecha de incorporación: ");
            System.out.print("Ingrese el año: ");
            int añoIncorporacion = sc.nextInt();
            System.out.print("Ingrese el mes: ");
            int mesIncorporacion = sc.nextInt();
            System.out.print("Ingrese el dia: ");
            int diaIncorporacion = sc.nextInt();
            sc.nextLine();
            LocalDate fechaIncorporacion = LocalDate.of(añoIncorporacion, mesIncorporacion, diaIncorporacion);

            System.out.println("Ingrese el puesto de trabajo que ocupa: ");
            String puesto=sc.nextLine();

            Empleado empleado = new Empleado();
                empleado.setDni(dni);
                empleado.setNombre(nombre);
                empleado.setApellido1(apellido1);
                empleado.setApellido2(apellido2);
                empleado.setFechaNacimiento(fechaNacimiento);
                empleado.setFechaIncorporacion(fechaIncorporacion);
                empleado.setPuesto(puesto);

            em.persist(empleado);
            em.getTransaction().commit();
            }


    static public void consultarEmpleados(EntityManager em) {
        System.out.println("Datos de todas las personas de la base de datos:");
        System.out.println("-------------------------------------------------");
        TypedQuery<Empleado> query
                = em.createQuery("SELECT dni FROM Empleado dni",
                Empleado.class);
        List<Empleado> results = query.getResultList();
        for (Empleado empleado : results) {
            System.out.println(empleado);
        }
    }

    public static void filtrarPorMayoresEdad(EntityManager em) {
        System.out.println("Filtrar empleados por mayores de edad");
        System.out.println("--------------------------------------");

        // Calcular la fecha actual y restar 18 años.
        LocalDate fechaMayorEdad = LocalDate.now().minusYears(18);

        TypedQuery<Empleado> consulta = em.createQuery(
                "SELECT e FROM Empleado e WHERE e.fechaNacimiento <= :fechaMayorEdad",
                Empleado.class);

        consulta.setParameter("fechaMayorEdad", fechaMayorEdad);
        List<Empleado> resultado = consulta.getResultList();

        System.out.println("Empleados mayores de edad:");
        for (Empleado empleado : resultado) {
            System.out.println(empleado);
        }
    }

    public static void filtrarPorAntiguedad(EntityManager em) {
        System.out.println("Filtrar por fecha");
        System.out.println("-------------------------------------");

        TypedQuery<Empleado> consulta = em.createNamedQuery("masAntiguoPrimero", Empleado.class);
        List<Empleado> resultado = consulta.getResultList();

        System.out.println("Empleados ordenados por antigüedad en el trabajo:");
        for (Empleado empleado : resultado) {
            System.out.println(empleado);
        }
    }

    static public void filtrarDni(EntityManager em) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dni:");
        String dni = sc.nextLine();
        TypedQuery<Empleado> consulta = em.createQuery("SELECT b From Empleado b WHERE b.dni = :dni", Empleado.class);
        consulta.setParameter("dni", dni);
        List<Empleado> resultado = consulta.getResultList();
        if (resultado.isEmpty()) {
            System.out.println("No existe ningún empleado con ese DNI");

        } else {
        System.out.println("Datos del empleado:");
        System.out.println("---------------------------");
        for (Empleado empleado : resultado) {
            System.out.println(empleado);
            }
        }
    }


    public static void filtrarPrimeraLetra(EntityManager em) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la primera letra del nombre:");
        String letra = sc.nextLine();
        System.out.println("Datos del empleado:");
        System.out.println("---------------------------");
        TypedQuery<Empleado> consulta = em.createQuery(
                "SELECT e FROM Empleado e WHERE e.nombre LIKE :Nombre",
                Empleado.class);
        consulta.setParameter("Nombre", letra + "%"); // Establecer el valor para el parámetro con nombre
        List<Empleado> resultado = consulta.getResultList();
        for (Empleado empleado : resultado) {
            System.out.println(empleado);
        }
    }
}


