package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Control {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/control.odb");
            EntityManager em = emf.createEntityManager();
            System.out.println("------------- Menú -------------");
            System.out.println("1. Ingresar datos de instancias");
            System.out.println("2. Dar de alta persona");
            System.out.println("3. Consultar todas las personas");
            System.out.println("4. Dar de alta vehículo");
            System.out.println("5. Consultar todos los vehículos");
            System.out.println("6. Consultar un vehículo por su ID");
            System.out.println("7. Modificar datos de un vehículo");
            System.out.println("8. Eliminar vehículo");
            System.out.println("9. Ingresar datos de archivo");
            System.out.println("10. Consultar datos de empleados");
            System.out.println("11. Insertar un nuevo empleado");
            System.out.println("12. Filtrar por mayoría de edad");
            System.out.println("13. Filtrar por antigüedad en el trabajo");
            System.out.println("14. Filtrar por DNI");
            System.out.println("15. Filtrar por primera letra del nombre");
            System.out.println("0. Salir");

            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> DatosInstancias.ingresarDatosInstancias(em);
                case 2 -> CRUDPersona.altaPersona(em);
                case 3 -> CRUDPersona.consultarPersonas(em);
                case 4 -> CRUDVehiculo.altaVehiculo(em);
                case 5 -> CRUDVehiculo.consultarTodosVehiculos(em);
                case 6 -> CRUDVehiculo.consultarVehiculoId(em);
                case 7 -> CRUDVehiculo.modificarVehiculo(em);
                case 8 -> CRUDVehiculo.borrarVehiculo(em);
                case 9 -> DatosArchivo.importarDatos(em);
                case 10 -> CRUDEmpleado.consultarEmpleados(em);
                case 11 -> CRUDEmpleado.insertarNuevoEmpleado(em);
                case 12 -> CRUDEmpleado.filtrarPorMayoresEdad(em);
                case 13 -> CRUDEmpleado.filtrarPorAntiguedad(em);
                case 14 -> CRUDEmpleado.filtrarDni(em);
                case 15 -> CRUDEmpleado.filtrarPrimeraLetra(em);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");

            }
            em.close();
            emf.close();
        }

        while (opcion != 0);

    }
}

