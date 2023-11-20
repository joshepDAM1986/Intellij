package ejercicio4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import utilidades.BasesDatos;

class DiscografiaDAOTest {

    DiscograficaDAO dao;
    @BeforeEach
    void setUp() {
        String ruta_scrip = "src/main/java/ejercicio4/script_datos.sql";
        BasesDatos.borrarDatos("discografica");
        BasesDatos.volcarDatos(ruta_scrip,"discografica");

        dao = new DiscograficaDAO("localhost", "discografica", "root", "");
    }
    @Test
    void aumentarPrecio() {
        dao.aumentarPrecio("Rock",10.0);
    }
    @Test
    void masReciente() {
        String esperado="Listen 2014-01-01\n";
        String actual=dao.masReciente();
        assertEquals(esperado,actual);
    }
    @Test
    void calificacionAlbun() {
        System.out.println(dao.calificacionAlbun("Death Magnetic"));
    }
}