package ejercicio1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.BasesDatos;
import java.time.LocalDate;

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
        dao.agregarEmpleado("Antonio",
                           "Ruiz Lopez",
                "2019-05-10",
                "Desarrollador",
                "antoñito@correo.es",
                "2023-10-15",
                1500.0,
                "Synergetic Systems");
    }

    @Test
    void subirSueldo() {
    }

    @Test
    void trasladarEmpleado() {
    }

    @Test
    void empleadosEmpresa() {
    }

    @Test
    void crearCoche() {
    }

    @Test
    void costeProyecto() {
        Double valor_esperador=6300.0;

        assertEquals(valor_esperador,dao.costeProyecto("QuantumQuest"));
    }

    @Test
    void resumenProyectos() {
        String valor_esperado=
                "CodeFusion\n" +
                "Fecha:2023-01-01\n"+
                "Juan Pérez\n"+
                "María Gómez\n"+
                "Coste:6300.0\n"+
                "======================\n"+
                "FusionWorks\n" +
                "Fecha:2022-05-15\n"+
                "Carlos Martínez\n"+
                "Coste:4500.0\n"+
                "======================\n"+
                "CyberPulse\n" +
                "Fecha:2023-03-10\n"+
                "Laura Sánchez\n"+
                "Coste:3800.0\n"+
                "======================\n"+
                "QuantumQuest\n" +
                "Fecha:2022-11-20\n"+
                "Coste:0.0\n"+
                "======================\n";

        assertEquals(valor_esperado,dao.resumenProyectos());
    }

    @Test
    void empleadosSinCoche() {
    }

    @Test
    void borrarProyectosSinEmp() {
        dao.BorrarProyectosSinEmp();
    }

    @Test
    void borrarAño() {
        dao.BorrarAño(2022);
    }

}