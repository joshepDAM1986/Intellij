package ejercicio2;

import ejercicio1.HoldingDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.BasesDatos;

import static org.junit.jupiter.api.Assertions.*;

class ClubDAOTest {


    ClubDAO dao;
    @BeforeEach
    void setUp() {
        String ruta_scrip = "src/main/java/ejercicio2/script_datos.sql";
        BasesDatos.borrarDatos("club");
        BasesDatos.volcarDatos(ruta_scrip,"club");

        dao = new ClubDAO("localhost", "club", "root", "");

    }

    @Test
    void crearEvento() {
    }

    @Test
    void añadirSocio() {
    }

    @Test
    void apuntarseEvento() {
        dao.apuntarseEvento("Jose","Partido de futbol sala");
    }

    @Test
    void eventosSocio() {
    }

    @Test
    void sociosEvento() {
    }

    @Test
    void resumentEventos() {
        String esperado=
                "Fiesta de la espuma\n" +
                "Fecha:2021-12-20\n" +
                "Juan\n" +
                "Antonio\n" +
                "======================\n" +
                "Cata de vinos\n" +
                "Fecha:2020-11-30\n" +
                "Juan\n" +
                "Jose\n" +
                "======================\n" +
                "Maraton de cine\n" +
                "Fecha:2022-05-30\n" +
                "======================\n" +
                "Partido de futbol sala\n" +
                "Fecha:2023-06-30\n" +
                "Antonio\n" +
                "======================\n";
        String actual=dao.resumentEventos();
        assertEquals(esperado,actual);
    }

    @Test
    void valoracionesEvento() {
    }

    @Test
    void eventoMultitudinario() {
        String valor_esperado="Fiesta de la espuma";

        assertEquals(valor_esperado,dao.eventoMultitudinario());
    }

    @Test
    void sinSocios() {
    }

    @Test
    void mejorValorado() {
        String valor_esperado="Partido de futbol sala";

        assertEquals(valor_esperado,dao.mejorValorado());
    }

    @Test
    void borrarEventos() {
    }
}