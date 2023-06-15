package scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDScanner {

    // BASE DE DATOS
    public static Connection conectar() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduce el usuario de la base de datos:");
            String user = sc.nextLine();
            System.out.println("Introduce la contraseña:");
            String password = sc.nextLine();

            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, user, password);
            Statement stmt = cn.createStatement();
            System.out.println("Conexión establecida correctamente");
            return cn;
        } catch(Exception e) {
            System.out.println("Error al conectarse a la base de datos " + e.getMessage());
        }
        return null;
    }



    // PERSONA
    public static void addPerson() {

        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca el DNI de la persona:");
            String dni = sc.nextLine();
            System.out.println("Introduzca su nombre:");
            String nombre = sc.nextLine();
            System.out.println("Introduzca el primer apellido:");
            String apellido1 = sc.nextLine();
            System.out.println("Introduzca el segundo apellido:");
            String apellido2 = sc.nextLine();
            System.out.println("Introduzca su fecha de nacimiento:");
            String fechaNacimiento = sc.nextLine();

            String sql = "INSERT INTO empresa.persona(dni, nombre, apellido1, apellido2, fechaNacimiento) "
                    + "VALUES('" + dni + "', '" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', '" + fechaNacimiento + "');";

            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al introducir una persona en la base de datos " + e.getMessage());
        }
    }


    public static void addEmployee() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el DNI de la persona que quiere hacer trabajador/a de la empresa:");
            String dni = sc.nextLine();
            System.out.println("Introduce el Número de Registro de personal:");
            int numeroRegistroPersonal = sc.nextInt();
            sc.nextLine();
            System.out.println("Introduce la fecha de incorporación en la empresa:");
            String fechaIncorporacion = sc.nextLine();
            System.out.println("Introduce el puesto que pertenece en la empresa");
            String puesto = sc.nextLine();

            String sql = "INSERT INTO trabajador(numeroRegistroPersonal, fechaIncorporacion, puesto, dni) "
                    + "VALUES('" + numeroRegistroPersonal + "', '" + fechaIncorporacion + "', '" + puesto + "', '" + dni + "');";

            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al introducir un trabajador en la base de datos " + e.getMessage());
        }
    }


    public static void readPeople() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            String sql = "SELECT * FROM persona";

            ResultSet resultados = stmt.executeQuery(sql);
            System.out.println("Listado de personas");
            System.out.println("--------------------" + "\n");

            int nFilas = 0;
            while(resultados.next()) {
                System.out.println("DNI: " + resultados.getString("dni") + "\n"
                        + "Nombre: " + resultados.getString("nombre") + "\n"
                        + "Apellidos: " + resultados.getString("apellido1") + " " + resultados.getString("apellido2") + "\n"
                        + "Fecha de nacimiento: " + resultados.getDate("fechaNacimiento") + "\n");
                nFilas++;
            }
            System.out.println("Filas leídas: " + nFilas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al leer los datos de las personas de la base de datos " + e.getMessage());
        }
    }


    public static void readEmployees() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            String sql = "SELECT * FROM trabajador";

            ResultSet resultados = stmt.executeQuery(sql);
            System.out.println("Listado de trabajadores");
            System.out.println("--------------------" + "\n");

            int nFilas = 0;
            while(resultados.next()) {
                System.out.println("DNI: " + resultados.getString("dni") + "\n"
                        + "Número de Registro de Personal: " + resultados.getString("numeroRegistroPersonal") + "\n"
                        + "Fecha de incorporación: " + resultados.getDate("fechaIncorporacion") + "\n"
                        + "Puesto: " + resultados.getString("puesto") + "\n");
                nFilas++;
            }
            System.out.println("Filas leídas: " + nFilas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al leer los datos de los trabajadores de la base de datos " + e.getMessage());
        }
    }


    public static void readPerson() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el DNI de la persona que quiere obtener los datos:");
            String dni = sc.nextLine();

            String sql = "SELECT * FROM persona WHERE dni='" + dni + "'";

            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println();
            System.out.println("Datos de la persona con DNI: " + dni);
            System.out.println("--------------------------------------------" + "\n");

            int nFilas = 0;
            while(resultado.next()) {
                System.out.println("DNI: " + resultado.getString("dni") + "\n"
                        + "Nombre: " + resultado.getString("nombre") + "\n"
                        + "Apellidos: " + resultado.getString("apellido1") + " " + resultado.getString("apellido2") + "\n"
                        + "Fecha de nacimiento: " + resultado.getDate("fechaNacimiento") + "\n");
                nFilas++;
            }
            System.out.println("\nFilas leídas: " + nFilas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al leer los datos de la persona solicitada " + e.getMessage());
        }
    }


    public static void readEmployee() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el Número de Registro de Personal del trabajador que quiere obtener los datos:");
            int numeroRegistroPersonal = sc.nextInt();
            sc.nextLine();

            String sql = "SELECT * FROM trabajador WHERE numeroRegistroPersonal='" + numeroRegistroPersonal + "'";

            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println();
            System.out.println("Datos del trabajador con Número de Registro de Personal: " + numeroRegistroPersonal);
            System.out.println("---------------------------------------------------------------------------------------" + "\n");

            int nFilas = 0;
            while(resultado.next()) {
                System.out.println("DNI: " + resultado.getString("dni") + "\n"
                        + "Número de Registro de Personal: " + resultado.getString("numeroRegistroPersonal") + "\n"
                        + "Fecha de incorporación: " + resultado.getDate("fechaIncorporacion") + "\n"
                        + "Puesto: " + resultado.getString("puesto") + "\n");
                nFilas++;
            }
            System.out.println("\nFilas leídas: " + nFilas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al leer los datos del trabajador solicitado " + e.getMessage());
        }
    }


    public static void updatePersona() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el DNI de la persona que quiera modificar sus datos");
            String dni = sc.nextLine();

            System.out.println("¿Qué dato desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Fecha de nacimiento");
            int option = sc.nextInt();
            sc.nextLine();

            if(option == 1) {
                System.out.println("Introduzca el nuevo nombre:");
                String nuevoNombre = sc.nextLine();
                String sql = "UPDATE persona SET nombre ='" + nuevoNombre + "' WHERE dni='" + dni + "'";
                int filasActualizadas = stmt.executeUpdate(sql);
                System.out.println("Filas modificadas: " + filasActualizadas);
            } else if(option == 2) {
                System.out.println("Introduzca los nuevos apellidos:");
                String nuevoApellido1 = sc.nextLine();
                String nuevoApellido2 = sc.nextLine();
                String sql = "UPDATE persona SET apellido1 ='" + nuevoApellido1 + "'," + " apellido2='" + nuevoApellido2 + "' WHERE dni='" + dni + "'";
                int filasActualizadas = stmt.executeUpdate(sql);
                System.out.println("Filas modificadas: " + filasActualizadas);
            } else if(option == 3) {
                System.out.println("Introduzca la nueva fecha de nacimiento:");
                String nuevaFechaNacimiento = sc.nextLine();
                String sql = "UPDATE persona SET fechaNacimiento ='" + nuevaFechaNacimiento + "' WHERE dni='" + dni + "'";
                int filasActualizadas = stmt.executeUpdate(sql);
                System.out.println("Filas modificadas: " + filasActualizadas);
            } else {
                System.out.println("No ha elegido una opción correcta.");
            }
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al modificar los datos de la persona " + e.getMessage());
        }
    }


    public static void updateEmployee() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el Número de Registro de Personal del trabajador que quiera modificar sus datos");
            String numeroRegistroPersonal = sc.nextLine();

            System.out.println("¿Qué dato desea modificar?");
            System.out.println("1. Fecha de incorporación");
            System.out.println("2. Puesto");
            System.out.println("3. DNI");
            int option = sc.nextInt();
            sc.nextLine();

            if(option == 1) {
                System.out.println("Introduzca la nueva fecha de incorporación:");
                String fechaIncorporacion = sc.nextLine();
                String sql = "UPDATE trabajador SET fechaIncorporacion ='" + fechaIncorporacion + "' WHERE numeroRegistroPersonal='" + numeroRegistroPersonal + "'";
                int filasActualizadas = stmt.executeUpdate(sql);
                System.out.println("Filas modificadas: " + filasActualizadas);
            } else if(option == 2) {
                System.out.println("Introduzca el nuevo puesto de trabajo:");
                String puesto = sc.nextLine();
                String sql = "UPDATE trabajador SET puesto ='" + puesto + "' WHERE numeroRegistroPersonal='" + numeroRegistroPersonal + "'";
                int filasActualizadas = stmt.executeUpdate(sql);
                System.out.println("Filas modificadas: " + filasActualizadas);
            } else if(option == 3) {
                System.out.println("Introduzca el nuevo DNI del trabajador:");
                String dni = sc.nextLine();
                String sql = "UPDATE persona SET dni ='" + dni + "' WHERE numeroRegistroPersonal='" + numeroRegistroPersonal + "'";
                int filasActualizadas = stmt.executeUpdate(sql);
                System.out.println("Filas modificadas: " + filasActualizadas);
            } else {
                System.out.println("No ha elegido una opción correcta.");
            }
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al modificar los datos del trabajador " + e.getMessage());
        }
    }


    public static void deletePerson() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el DNI de la persona que desea eliminar de la base de datos");
            String dni = sc.nextLine();

            String sql = "DELETE FROM persona WHERE dni='" + dni + "'";

            int filasEliminadas = stmt.executeUpdate(sql);
            System.out.println("Filas eliminadas: " + filasEliminadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar los datos de una persona de la base de datos " + e.getMessage());
        }
    }


    public static void deleteEmployee() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el Número de Registro de Personal del trabajador que desea eliminar de la base de datos");
            String numeroRegistroPersonal = sc.nextLine();

            String sql = "DELETE FROM trabajador WHERE numeroRegistroPersonal='" + numeroRegistroPersonal + "'";

            int filasEliminadas = stmt.executeUpdate(sql);
            System.out.println("Filas eliminadas: " + filasEliminadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar los datos de una persona de la base de datos " + e.getMessage());
        }
    }
}