package classes.no.usadas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
/*
public class Control3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/contro.odb");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------------- Menú -------------");
            System.out.println("1. DatosArchivo datos de archivo");
            System.out.println("2. Insertar un nuevo empleado");
            System.out.println("3. Consultar datos de empleados");
            System.out.println("4. Filtrar por mayoría de edad");
            System.out.println("5. Filtrar por antigüedad en el trabajo");
            System.out.println("6. Filtrar por DNI");
            System.out.println("7. Filtrar por primera letra del nombre");
            System.out.println("0. Salir");

            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> DatosArchivo.importarDatos(em);
                case 2 -> DatosArchivo.insertarNuevoEmpleado(em);
                case 3 -> DatosArchivo.consultarEmpleados(em);
                case 4 -> DatosArchivo.filtrarPorMayoresEdad(em);
                case 5 -> DatosArchivo.filtrarPorAntiguedad(em);
                case 6 -> DatosArchivo.filtrarDni(em);
                case 7 -> DatosArchivo.filtrarPrimeraLetra(em);
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
