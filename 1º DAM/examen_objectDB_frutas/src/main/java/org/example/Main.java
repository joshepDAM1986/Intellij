package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/frutas.odb");
            EntityManager em = emf.createEntityManager();
            System.out.println("------------- Menú -------------");
            System.out.println("1. Ingresar datos componente");
            System.out.println("2. Ingresar datos frutas");
            System.out.println("3. Consultar todas las futas");
            System.out.println("4. Consultar una fruta");
            System.out.println("5. Modificar nombre de fruta");
            System.out.println("6. Borrar una fruta");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> Operaciones.insertarDatosComponente(em);
                case 2 -> Operaciones.insertarDatosFruta(em);
                case 3 -> Operaciones.consultarFrutas(em);
                case 4 -> Operaciones.consultarFruta(em);
                case 5 -> Operaciones.modificarFruta(em);
                case 6 -> Operaciones.borrarFruta(em);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Seleccione una opción válida.");
            }
            em.close();
            emf.close();
        }
        while (opcion != 0);
    }
}
