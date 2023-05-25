package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

    public class CRUDVehiculo extends Vehiculo {
        public static void altaVehiculo(EntityManager em) {
            em.getTransaction().begin();
            Scanner sc = new Scanner(System.in);
            Persona conductor = null;
            System.out.println("------ Alta Vehiculo ------");

            System.out.println("¿El vehiculo tiene conductor? (s/n): ");
            String opcion = sc.nextLine();

            while (opcion.equals("s")) {
                System.out.println("Ingrese el DNI del conductor: ");
                String dniConductor = sc.nextLine();

                // Buscar y recuperar la instancia del conductor desde la base de datos
                TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.dni = :dni", Persona.class);
                query.setParameter("dni", dniConductor);
                List<Persona> resultados = query.getResultList();

                if (!resultados.isEmpty()) {
                    conductor = resultados.get(0);
                    break; // Salir del bucle si se encontró el conductor
                }
                else {
                    System.out.println("El conductor no existe en la base de datos.");
                    System.out.println("¿Desea ingresar otro DNI? (s/n): ");
                    opcion = sc.nextLine();
                }
            }

            System.out.println("Ingrese la matricula del vehiculo: ");
            String matricula = sc.nextLine();

            // Verificar si la matrícula ya existe en la base de datos
            TypedQuery<Vehiculo> matriculaQuery
                    = em.createQuery("SELECT v FROM Vehiculo v WHERE v.matricula = :matricula", Vehiculo.class);
            matriculaQuery.setParameter("matricula", matricula);
            List<Vehiculo> vehiculosConMatricula = matriculaQuery.getResultList();

            if (!vehiculosConMatricula.isEmpty()) {
                System.out.println("Ya existe un vehículo con la misma matrícula.");
                em.getTransaction().rollback();
                return;
            }

            System.out.println("Ingrese la fecha de matriculación del vehiculo: ");
            System.out.print("Ingrese el año: ");
            int año = sc.nextInt();
            System.out.print("Ingrese el mes: ");
            int mes = sc.nextInt();
            System.out.print("Ingrese el dia: ");
            int dia = sc.nextInt();
            sc.nextLine();
            LocalDate fechaMatriculacion = LocalDate.of(año, mes, dia);

            System.out.print("¿El vehiculo es un coche? (s/n): ");
            String esCoche = sc.nextLine();

            try {
                if (esCoche.equals("s")) {
                    System.out.println("Ingrese el tipo de energía del vehículo:");
                    System.out.println("1. GASOLINA");
                    System.out.println("2. DIESEL");
                    System.out.println("3. ELECTRICO");
                    System.out.println("4. HIBRIDO");
                    int opcionTipoEnergia = sc.nextInt();
                    sc.nextLine();

                    TipoEnergia tipoEnergia = null;
                    switch (opcionTipoEnergia) {
                        case 1:
                            tipoEnergia = TipoEnergia.GASOLINA;
                            break;
                        case 2:
                            tipoEnergia = TipoEnergia.DIESEL;
                            break;
                        case 3:
                            tipoEnergia = TipoEnergia.ELECTRICO;
                            break;
                        case 4:
                            tipoEnergia = TipoEnergia.HIBRIDO;
                            break;
                        default:
                            System.out.println("Opción no válida. Se asignará el valor por defecto (null).");
                            break;
                    }
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setMatricula(matricula);
                    vehiculo.setFechaMatriculacion(fechaMatriculacion);
                    vehiculo.setConductor(conductor);
                    vehiculo.setTipoEnergia(tipoEnergia);
                    em.persist(vehiculo);
                }
                else
                {
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setMatricula(matricula);
                    vehiculo.setFechaMatriculacion(fechaMatriculacion);
                    vehiculo.setConductor(conductor);
                    em.persist(vehiculo);
                }

                System.out.println("Vehiculo dado de alta correctamente.");
                System.out.println("-----------------------------");
                em.getTransaction().commit();

            }
            catch (Exception e) {
                System.out.println("Error al dar de alta al vehiculo: " + e.getMessage());
                em.getTransaction().rollback();
            }

        }

        static public void consultarTodosVehiculos(EntityManager em) {
        System.out.println("Datos de todos los vehículos de la base de datos:");
        System.out.println("-------------------------------------------------");
        TypedQuery<Vehiculo> query
                = em.createQuery("SELECT id FROM Vehiculo id",
                Vehiculo.class);
        List<Vehiculo> results = query.getResultList();
        for (Vehiculo vehiculo : results) {
            System.out.println(vehiculo);
        }
    }
    static public void consultarVehiculoId(EntityManager em) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la id del vehículo:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Datos del vehículo buscado:");
        System.out.println("---------------------------");
        Vehiculo vehiculo = em.find(Vehiculo.class, id);
        System.out.println(vehiculo);
    }

    /*
    static public void consultarVehiculoMatricula(EntityManager em) {
        Scanner sc=new Scanner(System.in);
        String matricula = sc.nextLine();
        System.out.println("Introduce la matrícula del vehículo:");
        System.out.println("Datos del vehículo buscado:");
        System.out.println("---------------------------");
        TypedQuery consulta = em.createQuery("SELECT b From Vehiculo b " +
                "WHERE b.matricula = '"+matricula+"'", Vehiculo.class);
        List<Vehiculo> resultado = consulta.getResultList();
        for (Vehiculo vehiculo : resultado) {
            System.out.println(vehiculo);
        }
    }
    */

    public static void modificarVehiculo(EntityManager em){
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la nueva matricula: ");
        String matricula= sc.nextLine();
        System.out.println("Introduce la id del vehículo que quieres a modificar: ");
        int id= sc.nextInt();
        sc.nextLine();
        Query consulta = em.createQuery("UPDATE Vehiculo "+
                "SET matricula = '"+matricula+"'"+
                "where id = "+id+"");

        int numModificados = consulta.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Modificaciones realizadas: " + numModificados);

    }

    static public void borrarVehiculo(EntityManager em) {
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la id del vehiculo a borrar ");
        int id = sc.nextInt();
        Query query
                = em.createQuery("DELETE FROM Vehiculo " +
                        "WHERE id = "+id+"");
        int numBorrados = query.executeUpdate();
        em.getTransaction().commit();

        System.out.println("Vehículos borrados: " + numBorrados);
    }
}