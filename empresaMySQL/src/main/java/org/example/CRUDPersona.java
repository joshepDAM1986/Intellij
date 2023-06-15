package org.example;

import java.sql.*;
import java.util.*;

public class CRUDPersona {

    public static void insertarPersona() {
        try (Scanner sc = new Scanner(System.in);
             Connection cn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empresa", "usr_empresa", "Empresa#23");
             PreparedStatement stmt = cn.prepareStatement("INSERT INTO empresa.persona " +
                     "(dni, nombre, numRegistro) VALUES (?, ?, ?)")) {

            System.out.print("Ingrese el DNI: ");
            String dni = sc.nextLine();

            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();

            Integer numRegistro = null;
            System.out.print("¿Es trabajador? (S/N): ");
            String esTrabajador = sc.nextLine();
            if (esTrabajador.equalsIgnoreCase("s")) {
                System.out.print("Ingrese el número de registro: ");
                numRegistro = sc.nextInt();
                sc.nextLine();
            }

            stmt.setString(1, dni);
            stmt.setString(2, nombre);
            if (numRegistro != null) {
                stmt.setInt(3, numRegistro);
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            int filasInsertadas = stmt.executeUpdate();
            cn.commit(); // Confirmar la transacción

            System.out.println("Filas insertadas: " + filasInsertadas);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void lecturaPersona(Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM persona";
            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", DNI: " + resultado.getString("dni")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Numero de Registro: " + resultado.getInt("numRegistro"));
                numFilas++;
            }
            System.out.println("\nFilas leidas: " + numFilas);
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void lecturaPersonaId(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese la ID de la persona a consultar: ");
            int id = sc.nextInt();
            sc.nextLine();

            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM persona WHERE id='" + id + "'";
            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", DNI: " + resultado.getString("dni")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Numero de Registro: " + resultado.getInt("numRegistro"));
                numFilas++;
            }
            System.out.println("\nFilas leídas: " + numFilas);
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }

    public static void modificarPersona(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese el id de la persona a modificar: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Ingrese el nuevo DNI: ");
            String dni = sc.nextLine();

            System.out.print("Ingrese el nuevo nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el nuevo número de registro (dejar en blanco si es null): ");
            String numRegistroStr = sc.nextLine();

            Integer numRegistro = null;
            if (!numRegistroStr.isEmpty()) {
                numRegistro = Integer.parseInt(numRegistroStr);
            }

            String sql = "UPDATE persona " +
                    "SET dni=?, " +
                    "nombre=?, " +
                    "numRegistro=? " +
                    "WHERE id=?";

            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, dni);
            stmt.setString(2, nombre);

            if (numRegistro != null) {
                stmt.setInt(3, numRegistro);
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            stmt.setInt(4, id);

            int filasModificadas = stmt.executeUpdate();
            System.out.println("Filas modificadas: " + filasModificadas);

            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

        public static void borrarPersona(Connection cn){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("Ingrese el id de la persona a borrar: ");
                int id = sc.nextInt();
                sc.nextLine();

                Statement stmt = cn.createStatement();
                String sql = "DELETE FROM persona "
                        +"WHERE id='" + id + "'";
                    System.out.println(sql);
                    int filasBorradas = stmt.executeUpdate(sql);
                    System.out.println("Filas borradas: "+ filasBorradas);
            }
            catch(Exception e){
            System.out.println("Error!!"+ e.getMessage());
        }
    }
}


