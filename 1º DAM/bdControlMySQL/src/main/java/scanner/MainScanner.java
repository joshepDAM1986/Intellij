package scanner;

import java.util.Scanner;

public class MainScanner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = 0;

        try {
            do {
                System.out.println();
                System.out.println("------------------------------------------------");
                System.out.println("************* MENÚ DE ACTUALIZCIÓN *************");
                System.out.println("------------------------------------------------");
                System.out.println("¿Qué desea hacer?");
                System.out.println();
                System.out.println("1. Conectar con la base de datos");
                System.out.println("2. Introducir los datos de una persona en la base de datos");
                System.out.println("3. Mostrar los datos de todas las personas");
                System.out.println("4. Mostrar los datos de una persona introduciendo su DNI");
                System.out.println("5. Modificar los datos de una persona");
                System.out.println("6. Borrar los datos de una persona de la base de datos");
                System.out.println("7. Dar de alta a un trabajador");
                System.out.println("8. Mostrar los datos de todos los trabajadores");
                System.out.println("9. Mostrar los datos de un trabajador introduciendo su Número de Registro de Personal");
                System.out.println("0. Salir");
                System.out.println("--------------------------------------");
                System.out.println();
                System.out.println("Seleccione una opción: ");
                option = sc.nextInt();

                switch (option) {

                    case 0 -> System.out.println("Cerrando sesión ...");
                    case 1 -> CRUDScanner.conectar();
                    case 2 -> CRUDScanner.addPerson();
                    case 3 -> CRUDScanner.readPeople();
                    case 4 -> CRUDScanner.readPerson();
                    case 5 -> CRUDScanner.updatePersona();
                    case 6 -> CRUDScanner.deletePerson();
                    case 7 -> CRUDScanner.addEmployee();
                    case 8 -> CRUDScanner.readEmployees();
                    case 9 -> CRUDScanner.readEmployee();
                    case 10 -> CRUDScanner.updateEmployee();
                    case 11 -> CRUDScanner.deleteEmployee();
                    default -> System.out.println("No ha introducido una opción correcta");
                }

            } while (option != 0);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error... " + e.getMessage());
        }
    }
}
