package ejercicio10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademiaTest {

    Academia dao;

    final static String ruta="src/main/java/ejercicio10/academia.dat";
    final static String ruta_backup="src/main/java/ejercicio10/academia.txt";
    final static String ruta_xml="src/main/java/ejercicio10/academia.xml";
    final static String ruta_json="src/main/java/ejercicio10/academia.json";

    @BeforeEach
    void setUp() {
        dao=new Academia();
        dao.nuevaMatricula("Juan Pérez", 1500.0, 2023, true);
        dao.nuevaMatricula("María García", 1200.0, 2023, false);
        dao.nuevaMatricula("Carlos Rodríguez", 1800.0, 2023, true);
        dao.nuevaMatricula("Ana Martínez", 1350.0, 2023, false);
    }

    @Test
    void visualizarMatriculas() {
        String valor_esperado="=======================\n"
                + "alumno=Juan Pérez\n"
                + "precio=1500\n"
                + "año=2023\n"
                + "pagada=Sí\n"
                +"=======================\n"
                + "alumno=María García\n"
                + "precio=1200\n"
                + "año=2023\n"
                + "pagada=No\n"
                +"=======================\n"
                + "alumno=Carlos Rodríguez\n"
                + "precio=1800\n"
                + "año=2023\n"
                + "pagada=Sí\n"
                +"=======================\n"
                + "alumno=Ana Martínez\n"
                + "precio=1350\n"
                + "año=2023\n"
                + "pagada=No\n";

        String respuesta= dao.visualizarMatriculas();

        assertEquals(valor_esperado,respuesta);

    }

    @Test
    void guardarCargarMatriculas() {
        String valor_esperado=dao.visualizarMatriculas();

        dao.guardarMatriculas(ruta);
        dao.cargarMatriculas(ruta);

        String respuesta=dao.visualizarMatriculas();

        assertEquals(valor_esperado,respuesta);
    }

    @Test
    void sumaPagadas() {
        double suma=dao.sumaPagadas();

        assertEquals(suma,3300);
    }

    @Test
    void matriculasResumen() {
        dao.matriculasResumen(ruta_backup);
    }

    @Test
    void matriculasResumenXML() {
        dao.matriculasResumenXML(ruta_xml);
    }

    @Test
    void matriculasResumenJSON() {
        dao.matriculasResumenJSON(ruta_json);
    }
}