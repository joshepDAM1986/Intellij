package org.example;

import java.sql.*;
import java.util.Scanner;

public class CRUDVehiculo {
    public static void insertarVehiculo() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca la matrícula del vehículo:");
            String matricula = sc.nextLine();
            System.out.println("Introduzca la fecha de matriculación:");
            String fechMatriculacion = sc.nextLine();

            String tipoEnergia = null;
            System.out.println("¿Es un coche? (S/N):");
            String esCoche = sc.nextLine();
            if (esCoche.equalsIgnoreCase("S")) {
                System.out.println("Introduzca el tipo de energía:");
                tipoEnergia = sc.nextLine();
            }
            else {
                tipoEnergia = null;
            }

            String conductor = null;
            System.out.println("¿Hay un conductor asociado? (S/N):");
            String hayConductor = sc.nextLine();
            if (hayConductor.equalsIgnoreCase("S")) {
                System.out.println("Introduzca el DNI del conductor:");
                conductor = sc.nextLine();
            }
            else {
                conductor = null;
                {

                }
            }

            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            PreparedStatement stmt = cn.prepareStatement("INSERT INTO vehiculo(matricula, fechMatriculacion, TipoEnergia, conductor) " +
                    "VALUES(?, ?, ?, ?)");

            stmt.setString(1, matricula);
            stmt.setString(2, fechMatriculacion);
            if (tipoEnergia == null || !tipoEnergia.equals("Gasolina") && !tipoEnergia.equals("Diesel") && !tipoEnergia.equals("Electrico") && !tipoEnergia.equals("Hibrido")) {
                stmt.setNull(3, Types.VARCHAR);
            } else {
                stmt.setString(3, tipoEnergia);
            }
            if (conductor != null) {
                stmt.setString(4, conductor);
            } else {
                stmt.setNull(4, Types.VARCHAR);
            }

            int filasInsertadas = stmt.executeUpdate();

            System.out.println("Filas insertadas: " + filasInsertadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al insertar el vehículo: " + e.getMessage());
        }
    }

    public static void lecturaVehiculo(Connection cn) {
        try {

            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM vehiculo";
            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", matricula: " + resultado.getString("matricula")
                        + ", fechMatriculacion: " + resultado.getDate("FechMatriculacion")
                        + ", TipoEnergia: " + resultado.getString("TipoEnergia")
                        + ", Conductor: " + resultado.getString("Conductor"));
                numFilas++;
            }
            System.out.println("\nFilas leidas: " + numFilas);
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    public static void lecturaVehiculoId(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese el ID del vehiculo a consultar: ");
            int id = sc.nextInt();
            sc.nextLine();

            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM vehiculo WHERE id='" + id + "'";
            System.out.println(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            int numFilas = 0;
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id")
                        + ", matricula: " + resultado.getString("matricula")
                        + ", fechMatriculacion: " + resultado.getString("fechMatriculacion")
                        + ", TipoEnergia: " + resultado.getString("TipoEnergia")
                        + ", conductor " + resultado.getString("conductor"));
                numFilas++;
            }
            System.out.println("\nFilas leídas: " + numFilas);
            stmt.close();
        }
        catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }
    public static void modificarVehiculo(Connection cn) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese el id del vehiculo a modificar: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Ingrese de nuevo la matricula: ");
            String matricula = sc.nextLine();

            System.out.print("Ingrese de nuevo la fecha de matriculacion: ");
            String fechMatriculacion = sc.nextLine();

            System.out.print("Ingrese de nuevo el tipo de energia (dejar en blanco si no es coche): ");
            String tipoEnergia = sc.nextLine();

            System.out.print("Ingrese de nuevo el conductor (dejar en blanco si no tiene conductor): ");
            String conductor = sc.nextLine();

            String sql = "UPDATE vehiculo " +
                    "SET matricula=?, " +
                    "fechMatriculacion=?, " +
                    "TipoEnergia=?, " +
                    "conductor=? " +
                    "WHERE id=?";

            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, matricula);
            stmt.setString(2, fechMatriculacion);

            if (tipoEnergia.isEmpty() || !tipoEnergia.equals("Gasolina") && !tipoEnergia.equals("Diesel") && !tipoEnergia.equals("Electrico") && !tipoEnergia.equals("Hibrido")) {
                stmt.setNull(3, Types.VARCHAR);
            } else {
                stmt.setString(3, tipoEnergia);
            }

            if (conductor.isEmpty()) {
                stmt.setNull(4, Types.VARCHAR);
            } else {
                stmt.setString(4, conductor);
            }

            stmt.setInt(5, id);

            int filasModificadas = stmt.executeUpdate();
            System.out.println("Filas modificadas: " + filasModificadas);

            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void borrarVehiculo(Connection cn){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el id del vehiculo a borrar: ");
            int id = sc.nextInt();
            sc.nextLine();

            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM vehiculo "
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

