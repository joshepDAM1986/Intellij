package preliminares;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaDAOTest {

    EmpresaDAO dao;

    @BeforeEach
    void setUp() {
        String ruta_scrip = "src/main/java/preliminares/script_datos.sql";
        borrarDatos();
        volcarDatos(ruta_scrip);

        dao = new EmpresaDAO("localhost", "empresa", "root", "");
    }

    @Test
    void ejercicio1() {
        dao.ejercicio1("RECURSOS HUMANOS", "MIAMI");
    }

    @Test
    void ejercicio2() {
        dao.ejercicio1("RECURSOS HUMANOS", "MIAMI");
        dao.ejercicio2("RECURSOS HUMANOS");
    }

    @Test
    void ejercicio3() {
        dao.ejercicio3("JAMES");
    }

    @Test
    void ejercicio4() {
        dao.ejercicio4(10.0);
    }

    @Test
    void ejercicio5() {
        dao.ejercicio5(350.0, "ASESOR");
    }

    @Test
    void ejercicio6() {
        String valor_esperado = "JONES\n" +
                "BLAKE\n" +
                "SCOTT\n" +
                "KING\n" +
                "FORD\n";
        String resultado = dao.ejercicio6(2500.0);

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio7() {
        String valor_esperado = "ALLEN\n" +
                "TURNER\n";
        String resultado = dao.ejercicio7(1400.0, "COMERCIAL");

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio8() {
        Double valor_esperado = 29025.0;
        Double resultado = dao.ejercicio8();

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio9() {
        String valor_esperado = "SMITH\n" +
                "ALLEN\n" +
                "WARD\n" +
                "JONES\n" +
                "MARTIN\n" +
                "BLAKE\n" +
                "CLARK\n" +
                "KING\n" +
                "TURNER\n" +
                "JAMES\n";

        String resultado = dao.ejercicio9(1982);

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio10() {
        Double valor_esperado = 5600.0;
        Double resultado = dao.ejercicio10("COMERCIAL");

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio11() {
        String valor_esperado = "ASESOR\n" +
                "COMERCIAL\n" +
                "MANAGER\n" +
                "ANALISTA\n" +
                "PRESIDENTE\n" +
                "EMPLEADO\n";
        String resultado = dao.ejercicio11();

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio12() {
        String valor_esperado = "ASESOR:1750\n" +
                "COMERCIAL:5600\n" +
                "MANAGER:8275\n" +
                "ANALISTA:6000\n" +
                "PRESIDENTE:5000\n" +
                "EMPLEADO:2400\n";
        String resultado = dao.ejercicio12();

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio13() {
        String valor_esperado = "KING\n";
        String resultado = dao.ejercicio13();

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio14() {
        String valor_esperado = "KING\n";
        String resultado = dao.ejercicio14();

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio15() {
        String valor_esperado = "SMITH\n";
        String resultado = dao.ejercicio15();

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio16() {
        String valor_esperado = "INVESTIGACION\n";
        String resultado = dao.ejercicio16("SMITH");

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio17() {
        String valor_esperado = "CLARK\n" +
                "KING\n" +
                "MILLER\n";
        String resultado = dao.ejercicio17("CONTABILIDAD");

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio18() {
        String valor_esperado = "ALLEN\n" +
                "WARD\n" +
                "MARTIN\n" +
                "TURNER\n" +
                "JAMES\n";
        String resultado = dao.ejercicio18("BLAKE");

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio19() {
        String valor_esperado = "SMITH\n" +
                "ALLEN\n" +
                "WARD\n" +
                "MARTIN\n" +
                "TURNER\n" +
                "ADAMS\n" +
                "JAMES\n" +
                "MILLER\n";
        String resultado = dao.ejercicio19();

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio20() {
        String valor_esperado =
                "CONTABILIDAD:8750.0\n"+
                "INVESTIGACION:10875.0\n"+
                "VENTAS:9400.0\n"+
                "OPERACIONES:0.0\n";
        String resultado = dao.ejercicio20();

        assertEquals(valor_esperado, resultado);
    }

    @Test
    void ejercicio21() {
        dao.ejercicio21("VILLAR", "VICEPRESIDENTE", 3400.0, 1000.0, "OPERACIONES");
    }


    void volcarDatos(String ruta_script) {
        Connection conexion = null;
        Statement statement = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa",
                    "root", //usuario de la BD
                    ""); //contraseña

            BufferedReader reader = new BufferedReader(new FileReader(ruta_script));
            statement = conexion.createStatement();
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                statement.executeUpdate(line);
            }
            reader.close();

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro del fichero\n" + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void borrarDatos() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Statement tablas_statement = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa",
                    "root", //usuario de la BD
                    ""); //contraseña

            statement = conexion.createStatement();

            tablas_statement=conexion.createStatement();
            resultSet = tablas_statement.executeQuery("SHOW TABLES");

            while (resultSet.next()) {
                String tableName = resultSet.getString(1);
                // Eliminar la tabla
                statement.executeUpdate("DELETE FROM " + tableName);
                System.out.println("Tabla " + tableName + " vaciada.");
            }

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
                if (resultSet != null) resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}