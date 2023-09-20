package org.example;

import java.sql.*;
import java.util.Scanner;

public class CRUDEmpleado {
    public static void insertarEmpleado() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese el DNI: ");
            String dni = sc.nextLine();

            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el primer apellido: ");
            String apellido1 = sc.nextLine();

            System.out.print("Ingrese el segundo apellido: ");
            String apellido2 = sc.nextLine();

            System.out.print("Ingrese la fecha de nacimiento: ");
            String fechNacimiento = sc.nextLine();

            System.out.print("Ingrese la fecha de incorporacion: ");
            String fechIncorporacion = sc.nextLine();

            System.out.print("Ingrese el puesto en la empresa: ");
            String puesto = sc.nextLine();

            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");

            String sql = "INSERT INTO empresa.empleado (dni, nombre, apellido1, apellido2, fechNacimiento, fechIncorporacion, puesto) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, dni);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido1);
            stmt.setString(4, apellido2);
            stmt.setString(5, fechNacimiento);
            stmt.setString(6, fechIncorporacion);
            stmt.setString(7, puesto);

            int filasInsertadas = stmt.executeUpdate();

            System.out.println("Filas insertadas: " + filasInsertadas);

            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void lecturaEmpleado(Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM empleado";
            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", DNI: " + resultado.getString("dni")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Primer apellido: " + resultado.getString("apellido1")
                        + ", Segundo apellido: " + resultado.getString("apellido2")
                        + ", Fecha de nacimiento: " + resultado.getString("fechNacimiento")
                        + ", Fecha de incorporacion: " + resultado.getString("fechIncorporacion")
                        + ", Puesto en la empresa: " + resultado.getString("puesto"));
                numFilas++;
            }
            System.out.println("\nFilas leidas: " + numFilas);
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void lecturaEmpleadoId(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese la ID del empleado a consultar: ");
            int id = sc.nextInt();
            sc.nextLine();

            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM empleado WHERE id='" + id + "'";
            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", DNI: " + resultado.getString("dni")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Primer apellido: " + resultado.getString("apellido1")
                        + ", Segundo apellido: " + resultado.getString("apellido2")
                        + ", Fecha de nacimiento: " + resultado.getString("fechNacimiento")
                        + ", Fecha de incorporacion: " + resultado.getString("fechIncorporacion")
                        + ", Puesto en la empresa: " + resultado.getString("puesto"));
                numFilas++;
            }
            System.out.println("\nFilas leídas: " + numFilas);
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }

    public static void lecturaEmpleadoDni(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese la DNI del empleado a consultar: ");
            String dni = sc.nextLine();

            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM empleado WHERE dni='" + dni + "'";
            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", DNI: " + resultado.getString("dni")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Primer apellido: " + resultado.getString("apellido1")
                        + ", Segundo apellido: " + resultado.getString("apellido2")
                        + ", Fecha de nacimiento: " + resultado.getString("fechNacimiento")
                        + ", Fecha de incorporacion: " + resultado.getString("fechIncorporacion")
                        + ", Puesto en la empresa: " + resultado.getString("puesto"));
                numFilas++;
            }
            System.out.println("\nFilas leídas: " + numFilas);
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }

    public static void filtarEmpleadoMayorEdad(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM empresa.empleado " +
                         " WHERE fechNacimiento <= DATE_SUB(CURDATE(), INTERVAL 18 YEAR)";
            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", DNI: " + resultado.getString("dni")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Primer apellido: " + resultado.getString("apellido1")
                        + ", Segundo apellido: " + resultado.getString("apellido2")
                        + ", Fecha de nacimiento: " + resultado.getString("fechNacimiento")
                        + ", Fecha de incorporacion: " + resultado.getString("fechIncorporacion")
                        + ", Puesto en la empresa: " + resultado.getString("puesto"));
                numFilas++;
            }
            System.out.println("\nFilas leídas: " + numFilas);
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }

    public static void filtarEmpleadoAntiguedad(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese la fecha de referencia: ");
            String fechaAntiguedad = sc.nextLine();

            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM empresa.empleado " +
                    "WHERE DATEDIFF( fechIncorporacion, '" + fechaAntiguedad + "') >= 0";

            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", DNI: " + resultado.getString("dni")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Primer apellido: " + resultado.getString("apellido1")
                        + ", Segundo apellido: " + resultado.getString("apellido2")
                        + ", Fecha de nacimiento: " + resultado.getString("fechNacimiento")
                        + ", Fecha de incorporacion: " + resultado.getString("fechIncorporacion")
                        + ", Puesto en la empresa: " + resultado.getString("puesto"));
                numFilas++;
            }
            System.out.println("\nFilas leídas: " + numFilas);
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }

    public static void filtarEmpleadoLetra(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese una letra para filtrar por nombre, apellido1 y apellido2: ");
            String letra = sc.nextLine();

            Statement stmt = cn.createStatement();

            String sql = "SELECT * FROM empresa.empleado " +
                    "WHERE (nombre LIKE '" + letra + "%' OR apellido1 LIKE '" + letra + "%' OR apellido2 LIKE '" + letra + "%') " +
                    "ORDER BY nombre, apellido1, apellido2";

            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", DNI: " + resultado.getString("dni")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Primer apellido: " + resultado.getString("apellido1")
                        + ", Segundo apellido: " + resultado.getString("apellido2")
                        + ", Fecha de nacimiento: " + resultado.getString("fechNacimiento")
                        + ", Fecha de incorporacion: " + resultado.getString("fechIncorporacion")
                        + ", Puesto en la empresa: " + resultado.getString("puesto"));
                numFilas++;
            }
            System.out.println("\nFilas leídas: " + numFilas);
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }
}
