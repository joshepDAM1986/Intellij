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
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Productos.odb");
            EntityManager em = emf.createEntityManager();
            System.out.println("------------- Menú -------------");
            System.out.println("1. Ingresar datos de productos");
            System.out.println("2. Consultar todos los productos");
            System.out.println("3. Consultar producto (ID))");
            System.out.println("4. Consultar producto (Query)");
            System.out.println("5. Modificar datos del Producto (ID)");
            System.out.println("6. Modificar datos del Producto (Query)");
            System.out.println("7. Borrar productos con id más bajo (Query)");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> Operaciones.ingresarDatosInstancias(em);
                case 2 -> Operaciones.consultarProductos(em);
                case 3 -> Operaciones.consultarProductosId(em);
                case 4 -> Operaciones.consultarProductosQuery(em);
                case 5 -> Operaciones.modificarDatosPorId(em);
                case 6 -> Operaciones.modificarDatosPorQuery(em);
                case 7 -> Operaciones.borrarProductosPorQuery(em);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");

            }
            em.close();
            emf.close();
        }

        while (opcion != 0);
    }
}

