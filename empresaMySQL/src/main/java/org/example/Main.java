package org.example;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        probarConexion();
        conectar();

        try {
            Connection cn = conectar();
            if (cn != null) {
                Scanner scanner = new Scanner(System.in);
                int opcion;

                do {
                    System.out.println("Seleccione una operación:");
                    System.out.println("---------------Persona---------------:");
                    System.out.println("1. Insertar persona nueva");
                    System.out.println("2. Consultar todas las personas");
                    System.out.println("3. Consultar persona por ID");
                    System.out.println("4. Modificar persona por ID");
                    System.out.println("5. Borrar persona por ID");
                    System.out.println("---------------Vehiculo---------------:");
                    System.out.println("6. Insertar vehiculo nuevo");
                    System.out.println("7. Consultar todos los vehiculos ");
                    System.out.println("8. Consultar un vehiculo por ID ");
                    System.out.println("9. Modificar un vehiculo por ID ");
                    System.out.println("10. Borrar un vehiculo por ID ");
                    System.out.println("---------------Empleado---------------:");
                    System.out.println("11. Insertar empleado nuevo");
                    System.out.println("12, Consultar todos los empleados");
                    System.out.println("13, Consultar empleado por ID");
                    System.out.println("14, Consultar empleado por DNI");
                    System.out.println("15. Filtrar empleados mayores de edad");
                    System.out.println("16. Filtrar empleados mas antiguo");
                    System.out.println("17. Filtrar empleados por letra");
                    System.out.println("0. Salir");
                    System.out.print("Selecciona una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1: CRUDPersona.insertarPersona();
                            break;
                        case 2: CRUDPersona.lecturaPersona(cn);
                            break;
                        case 3: CRUDPersona.lecturaPersonaId(cn);
                            break;
                        case 4: CRUDPersona.modificarPersona(cn);
                            break;
                        case 5: CRUDPersona.borrarPersona(cn);
                            break;
                        case 6: CRUDVehiculo.insertarVehiculo();
                            break;
                        case 7: CRUDVehiculo.lecturaVehiculo(cn);
                            break;
                        case 8: CRUDVehiculo.lecturaVehiculoId(cn);
                            break;
                        case 9: CRUDVehiculo.modificarVehiculo(cn);
                            break;
                        case 10: CRUDVehiculo.borrarVehiculo(cn);
                            break;
                        case 11: CRUDEmpleado.insertarEmpleado();
                            break;
                        case 12: CRUDEmpleado.lecturaEmpleado(cn);
                            break;
                        case 13: CRUDEmpleado.lecturaEmpleadoId(cn);
                            break;
                        case 14: CRUDEmpleado.lecturaEmpleadoDni(cn);
                            break;
                        case 15:CRUDEmpleado.filtarEmpleadoMayorEdad(cn);
                            break;
                        case 16:CRUDEmpleado.filtarEmpleadoAntiguedad(cn);
                            break;
                        case 17:CRUDEmpleado.filtarEmpleadoLetra(cn);
                            break;
                        case 0:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                } while (opcion != 0);

                cn.close();
            } else {
                System.out.println("No se pudo conectar");
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Connection conectar() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            return cn;
        } catch (Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
        return null;
    }

    public static void probarConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("Error!!!: " + e.getMessage());
            System.err.print("ClassNotFoundException: " + e.getMessage());
        }
    }
}