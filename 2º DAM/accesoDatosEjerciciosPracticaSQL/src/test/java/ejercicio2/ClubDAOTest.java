package ejercicio2;

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
        {dao.añadirSocio("Josele");}
    }

    @Test
    void apuntarseEvento() {
        dao.apuntarseEvento("Juan","Partido de futbol sala");
    }

    @Test
    void eventosSocio() {
        String esperado= "Cata de vinos\n" +
                         "Fiesta de la espuma\n";
        String actual=dao.eventosSocio("Juan");
        assertEquals(esperado,actual);
    }

    @Test
    void resumenEventos() {
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
        String actual=dao.resumenEventos();
        assertEquals(esperado,actual);
    }


    @Test
    void valoracionesEvento() {
        String esperado= "Gran evento, mucha diversión\n"+
                         "Divertido pero podría haber más actividades\n";
        String actual= dao.valoracionesEvento("Fiesta de la espuma");
        assertEquals(esperado,actual);
    }

    @Test
    void eventoMultitudinario() {
        String esperado= "Cata de vinos";
        String actual=dao.eventoMultitudinario();
        assertEquals(esperado,actual);
    }

    @Test
    void sinSocios() {
        String resultado="Maraton de cine";
        String actual= dao.sinSocios();
        assertEquals(resultado,actual);
    }

    @Test
    void mejorValorado() {
       String esperado="Evento: Fiesta de la espuma\n" +
                       "Puntuacion: 4.2\n";
       String actual=dao.mejorValorado();
       assertEquals(esperado,actual);
    }

    @Test
    void borrarEventos() {
        dao.borrarEventos(2023);
    }
}