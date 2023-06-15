package org.example;

import javax.persistence.*;
import java.util.*;

public class CRUDAgente {
    public static void altaAgente(EntityManager em) {
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la nacionalidad: ");
        String nacionalidad = sc.nextLine();

        System.out.println("Ingrese el tipo de agente que es:");
        System.out.println("1. CENTINELA");
        System.out.println("2. CONTROLADOR");
        System.out.println("3. DUIELISTA");
        System.out.println("4. INICIADOR");
        int opcionTipoAgente = sc.nextInt();
        sc.nextLine();

        TipoAgente tipoAgente = null;
        switch (opcionTipoAgente) {
            case 1:
                tipoAgente = TipoAgente.CENTINELA;
                break;
            case 2:
                tipoAgente = TipoAgente.CONTROLADOR;
                break;
            case 3:
                tipoAgente = TipoAgente.DUIELISTA;
                break;
            case 4:
                tipoAgente = TipoAgente.INICIADOR;
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
        Habilidad habilidad = null;
        System.out.println("Ingrese la ID de habilidad:");
        int idHabilidad = sc.nextInt();
        sc.nextLine();

        TypedQuery<Habilidad> query = em.createQuery("SELECT h FROM Habilidad h WHERE h.idHabilidad = :Habilidad", Habilidad.class);
        query.setParameter("Habilidad", idHabilidad);
        List<Habilidad> resultados = query.getResultList();

        if (!resultados.isEmpty()) {
            habilidad = resultados.get(0);
            Agente agente = new Agente();
            agente.setNombre(nombre);
            agente.setNacionalidad(nacionalidad);
            agente.setTipoAgente(tipoAgente);
            agente.setHabilidad(habilidad);
            em.persist(agente);
            em.getTransaction().commit();
        } else {
            System.out.println("La habilidad seleccionada no existe en la base de datos.");
        }
    }

    static public void consultarAgentes(EntityManager em) {
        System.out.println("-------------------------------------------------");
        TypedQuery<Agente> query
                = em.createQuery("SELECT id FROM Agente id",
                Agente.class);
        List<Agente> results = query.getResultList();
        for (Agente agente : results) {
            System.out.println(agente);
        }
    }

    static public void consultarAgente(EntityManager em) {
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la id del vehículo:");
        int id = sc.nextInt();
        sc.nextLine();
        Agente agenteExistente = em.find(Agente.class, id);
        if (agenteExistente == null) {
            System.out.println("El agente con ID " + id + " no existe en la base de datos.");
            em.getTransaction().rollback();
            return;
        }
        System.out.println("-------------------------------------------------");
        Agente vehiculo = em.find(Agente.class, id);
        System.out.println(vehiculo);
        em.getTransaction().commit();
    }

    public static void modificarAgente(EntityManager em) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del agente que desea modificar: ");
        int idAgente = scanner.nextInt();
        scanner.nextLine();

        Agente agente = em.find(Agente.class, idAgente);
        if (agente == null) {
            System.out.println("No se encontró ningún agente con el ID proporcionado.");
            return;
        }

        System.out.println("Seleccione el atributo que desea modificar: ");
        System.out.println("1. Nombre");
        System.out.println("2. Tipo de agente");
        System.out.println("3. Nacionalidad");
        System.out.println("4. Habilidad");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        int numModificaciones = 0;

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nuevo nombre del agente: ");
                String nombre = scanner.nextLine();
                if (!nombre.isEmpty()) {
                    agente.setNombre(nombre);
                    numModificaciones++;
                }
                break;
            case 2:
                System.out.println("Seleccione el nuevo tipo de agente: ");
                for (TipoAgente tipo : TipoAgente.values()) {
                    System.out.println(tipo.ordinal() + 1 + ". " + tipo.name());
                }
                int tipoAgenteIndex = scanner.nextInt();
                if (tipoAgenteIndex >= 1 && tipoAgenteIndex <= TipoAgente.values().length) {
                    TipoAgente tipoAgente = TipoAgente.values()[tipoAgenteIndex - 1];
                    agente.setTipoAgente(tipoAgente);
                    numModificaciones++;
                } else {
                    System.out.println("Opción no válida. No se realizaron cambios en el tipo de agente.");
                }
                break;
            case 3:
                System.out.println("Ingrese la nueva nacionalidad del agente: ");
                String nacionalidad = scanner.nextLine();
                if (!nacionalidad.isEmpty()) {
                    agente.setNacionalidad(nacionalidad);
                    numModificaciones++;
                }
                break;
            case 4:
                System.out.println("Ingrese los datos de la nueva habilidad: ");
                System.out.println("Nombre: ");
                String nombreHabilidad = scanner.nextLine();
                System.out.println("Descripción: ");
                String descripcionHabilidad = scanner.nextLine();
                System.out.println("Precio: ");
                int precioHabilidad = scanner.nextInt();
                System.out.println("Usos: ");
                int usosHabilidad = scanner.nextInt();
                scanner.nextLine();

                if (!nombreHabilidad.isEmpty() || !descripcionHabilidad.isEmpty() || precioHabilidad != 0 || usosHabilidad != 0) {
                    Habilidad habilidad = new Habilidad(nombreHabilidad, descripcionHabilidad, precioHabilidad, usosHabilidad);
                    agente.setHabilidad(habilidad);
                    numModificaciones++;
                }
                break;
            default:
                System.out.println("Opción no válida. No se realizaron cambios en el agente.");
        }

        if (numModificaciones > 0) {
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("El agente ha sido modificado exitosamente.");
            System.out.println("Número de modificaciones realizadas: " + numModificaciones);
        } else {
            System.out.println("No se realizaron modificaciones en el agente.");
            System.out.println("Número de modificaciones realizadas: " + numModificaciones);
        }
    }

    public static void borrarAgente(EntityManager em) {
        Scanner sc = new Scanner(System.in);

        em.getTransaction().begin();
        System.out.println("Introduce la ID del agente a borrar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Agente agente = em.find(Agente.class, id);
        if (agente == null) {
            System.out.println("No se encontró ningún agente con esa ID .");
            int numBorrados = 0;
            System.out.println("Número de agentes borrados: " + numBorrados);
        } else {
            Query query = em.createQuery("DELETE FROM Agente WHERE id = :id");
            query.setParameter("id", id);

            int numBorrados = query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Agente borrado exitosamente.");
            System.out.println("Número de agentes borrados: " + numBorrados);
        }
    }


}








