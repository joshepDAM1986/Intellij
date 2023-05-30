package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CRUDEmpleado {
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la fecha de referencia");
        String fechaReferencia = sc.nextLine();
        System.out.println("-------------------------------------");

        try {
            TypedQuery<Empleado> query = em.createNamedQuery("masAntiguoPrimero", Empleado.class);
            query.setParameter("fechaReferencia", LocalDate.parse(fechaReferencia));
            List<Empleado> resultado = query.getResultList();

            System.out.println("Empleados ordenados por antigüedad en el trabajo:");

            for (Empleado empleado : resultado) {
                System.out.println(empleado);
            }

            if (resultado.size() == 0) {
                System.out.println("No existen trabajadores tan antiguos");
            }
        }
        catch (DateTimeException e){
                System.out.println("Error, fecha no válida"+ e.getMessage());
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
        consulta.setParameter("Nombre", letra + "%");
        List<Empleado> resultado = consulta.getResultList();
        for (Empleado empleado : resultado) {
            System.out.println(empleado);
        }
    }
}

