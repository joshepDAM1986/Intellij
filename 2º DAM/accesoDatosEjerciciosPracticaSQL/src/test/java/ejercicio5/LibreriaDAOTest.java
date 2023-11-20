package ejercicio5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.BasesDatos;
import static org.junit.jupiter.api.Assertions.*;

class LibreriaDAOTest {

    LibreriaDAO dao;

    @BeforeEach
    void setUp() {
        String ruta_scrip = "src/main/java/ejercicio5/script_datos.sql";
        BasesDatos.borrarDatos("libreria");
        BasesDatos.volcarDatos(ruta_scrip,"libreria");

        dao = new LibreriaDAO("localhost", "libreria", "root", "");
    }

    @Test
    void agregarLibro() {
        dao.agregarLibro("12345678CI","Crónicas de Idum","Gloria Escoria");
    }

    @Test
    void realizarPrestamo() {
        dao.realizarPrestamo("21212121UI","74727472R");
    }

    @Test
    void masActivo() {
        String esperado="74727472R\n";
        String actual=dao.masActivo();
        assertEquals(esperado,actual);
    }

    @Test
    void borrarSinUso() {
        dao.borrarSinUso();
    }
}