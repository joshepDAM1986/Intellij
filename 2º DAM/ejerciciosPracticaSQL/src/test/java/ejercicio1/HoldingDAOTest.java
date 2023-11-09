package ejercicio1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.BasesDatos;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HoldingDAOTest {

    HoldingDAO dao;

    @BeforeEach
    void setUp() {
        String ruta_scrip = "src/main/java/ejercicio1/script_datos.sql";
        BasesDatos.borrarDatos("holding");
        BasesDatos.volcarDatos(ruta_scrip,"holding");

        dao = new HoldingDAO("localhost", "holding", "root", "");
    }

    @Test
    void agregarEmpleado() {
        dao.agregarEmpleado("Jose","García","1986-01-01","Desarrollador", "josegarcia@gmail.com", "2024-07-15",1900.0,"CodeCrafters");
    }

    @Test
    void subirSueldo() {
        dao.subirSueldo("Innovatech Solutions",300.0);
    }

    @Test
    void trasladarEmpleado() {
        dao.trasladarEmpleado( "Juan","Synergetic Systems");
    }

    @Test
    void empleadosEmpresa() {
        String esperado="Juan\n" +
                        "Carlos\n";
        String actual=dao.empleadosEmpresa("Innovatech Solutions");
        assertEquals(esperado, actual);
    }

    @Test
    void crearCoche() {
        dao.crearCoche("BMW","318",2500.0,1995,"Laura");
    }

    @Test
    void costeProyecto() {
        Double esperado=6300.0;
        Double actual=dao.costeProyecto("CodeFusion");
        assertEquals(esperado,actual);
        System.out.println(actual);
    }

    @Test
    void resumenProyectos() {
    }

    @Test
    void empleadosSinCoche() {
    }

    @Test
    void borrarProyectosSinEmp() {
    }

    @Test
    void borrarAño() {
    }
}