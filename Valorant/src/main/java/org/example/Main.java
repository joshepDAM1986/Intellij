package org.example;

import javax.persistence.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/valorant.odb");
            EntityManager em = emf.createEntityManager();
            System.out.println("------------- Menú -------------");
            System.out.println("1. Ingresar un Agente");
            System.out.println("2. Consultar todos los Agentes");
            System.out.println("3. Consultar un agente concreto");
            System.out.println("4. Modificar datos de un agente");
            System.out.println("5. Borrar un agente");
            System.out.println("6. Ingresar Habilidad");
            System.out.println("0. Salir");

            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> CRUDAgente.altaAgente(em);
                case 2 -> CRUDAgente.consultarAgentes(em);
                case 3 -> CRUDAgente.consultarAgente(em);
                case 4 -> CRUDAgente.modificarAgente(em);
                case 5 -> CRUDAgente.borrarAgente(em);
                case 6-> CRUDHabilidad.altaHabilidad(em);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Seleccione una opción válida.");
            }
            em.close();
            emf.close();
        }
        while (opcion != 0);
    }
}
