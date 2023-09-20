package classes.no.usadas;

import javax.persistence.*;
import java.util.Scanner;
/*
public class Control2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/control.odb");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------------- Menú -------------");
            System.out.println("1. Dar de alta persona");
            System.out.println("2. Consultar todas las personas");
            System.out.println("3. Dar de alta vehículo");
            System.out.println("4. Consultar todos los vehículos");
            System.out.println("5. Consultar un vehículo por su ID");
            System.out.println("6. Modificar datos de un vehículo");
            System.out.println("7. Eliminar vehículo");
            System.out.println("0. Salir");

            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> CRUDPersona.altaPersona(em);
                case 2 -> CRUDPersona.consultarPersonas(em);
                case 3 -> CRUDVehiculo.altaVehiculo(em);
                case 4 -> CRUDVehiculo.consultarTodosVehiculos(em);
                case 5 -> CRUDVehiculo.consultarVehiculoId(em);
                case 6 -> CRUDVehiculo.modificarVehiculo(em);
                case 7 -> CRUDVehiculo.borrarVehiculo(em);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }
        while (opcion != 0);

            em.close();
            emf.close();
        }
    }
*/


