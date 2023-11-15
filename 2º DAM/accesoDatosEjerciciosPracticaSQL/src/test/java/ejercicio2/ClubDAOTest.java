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
        dao.crearEvento("Cumpleaños Enrique","2023-11-01");
    }

    @Test
    void añadirSocio() {
    }

    @Test
    void apuntarseEvento() {
    }

    @Test
    void eventosSocio() {
    }

    @Test
    void sociosEvento() {
    }

    @Test
    void resumentEventos() {
        String esperado= "Cata de vinos 2020-11-30 Juan\n"+
                         "Cata de vinos 2020-11-30 Jose\n"+
                         "Fiesta de la espuma 2021-12-20 Juan\n"+
                         "Fiesta de la espuma 2021-12-20 Antonio\n"+
                         "Partido de futbol sala 2023-06-30 Antonio\n";
        String actual= dao.resumentEventos();
        assertEquals(esperado,actual);
    }

    @Test
    void valoracionesEvento() {
    }

    @Test
    void eventoMultitudinario() {
    }

    @Test
    void sinSocios() {
    }

    @Test
    void mejorValorado() {
    }

    @Test
    void borrarEventos() {
    }
}