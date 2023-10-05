package ejercicio6;

import ejercicio5.Libreria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.Utils;

import static org.junit.jupiter.api.Assertions.*;

class LigaTest {
    Liga dao;
    final static String ruta_salida = "src/main/java/ejercicio6/salida.txt";
    final static String ruta_salida_xml = "src/main/java/ejercicio6/salida.xml";
    final static String ruta_salida_json = "src/main/java/ejercicio6/salida.json";

    @BeforeEach
    void setUp() {

        dao = new Liga();
        dao.añadirFutbolista("Messi", "PSG", "delantero", 40);
        dao.añadirFutbolista("Sergio Ramos", "PSG", "defensa", 15);
        dao.añadirFutbolista("Cristiano Ronaldo", "Manchester United", "delantero", 41);
        dao.añadirFutbolista("Gerard Pique", "FC Barcelona", "defensa", 6);
        dao.añadirFutbolista("Luka Modric", "Real Madrid", "centrocampista", 7);
        dao.añadirFutbolista("Kilyan Mbappe", "PSG", "delantero", 20);
        dao.añadirFutbolista("Martin Braithwate", "FC Barcelona", "delantero", 10);
    }

    @Test
    void visualizarFutbolistas() {
        String valor_esperado = "=======================\n" +
                "Nombre=Messi\n" +
                "Club=PSG\n" +
                "Posicion=delantero\n" +
                "Goles=40\n" +
                "=======================\n" +
                "Nombre=Sergio Ramos\n" +
                "Club=PSG\n" +
                "Posicion=defensa\n" +
                "Goles=15\n" +
                "=======================\n" +
                "Nombre=Cristiano Ronaldo\n" +
                "Club=Manchester United\n" +
                "Posicion=delantero\n" +
                "Goles=41\n" +
                "=======================\n" +
                "Nombre=Gerard Pique\n" +
                "Club=FC Barcelona\n" +
                "Posicion=defensa\n" +
                "Goles=6\n" +
                "=======================\n" +
                "Nombre=Luka Modric\n" +
                "Club=Real Madrid\n" +
                "Posicion=centrocampista\n" +
                "Goles=7\n" +
                "=======================\n" +
                "Nombre=Kilyan Mbappe\n" +
                "Club=PSG\n" +
                "Posicion=delantero\n" +
                "Goles=20\n" +
                "=======================\n" +
                "Nombre=Martin Braithwate\n" +
                "Club=FC Barcelona\n" +
                "Posicion=delantero\n" +
                "Goles=10\n";

        String respuesta = dao.visualizarFutbolistas();
        assertEquals(valor_esperado, respuesta);
    }

    @Test
    void visualizarFutbolistasVacio() {
        String respuesta = dao.visualizarFutbolistas();
        assertEquals("Plantilla Vacía", respuesta);
    }

    @Test
    void guardarCargarFutbolistas() {
    String valor_esperado = dao.visualizarFutbolistas();
    dao.guardarFutbolistas(ruta_salida);
    dao.cargarFutbolistas(ruta_salida);
    String respuesta = dao.visualizarFutbolistas();
    assertEquals(valor_esperado, respuesta);
    }

    @Test
    void buscarFutbolista() {
        String valor_esperado = "=======================\n" +
                "Nombre=Messi\n" +
                "Club=PSG\n" +
                "Posicion=delantero\n" +
                "Goles=40\n";

        String respuesta = dao.buscarFutbolista("Messi");
        assertEquals(valor_esperado, respuesta);
    }

    @Test
    void buscarFutbolistaNoExiste() {
        String respuesta = dao.buscarFutbolista("Josele");
        assertEquals("No se encuentra el jugador", respuesta);
    }

    @Test
    void defensasGoleadores() {
    }

    @Test
    void defensasGoleadoresNoExisten() {
    }

    @Test
    void añadirFutbolistas() {

    }

    @Test
    void modificarNombre() {
    }

    @Test
    void backupFutbolistas() {
    }

    @Test
    void backupFutbolistasXML() {
    }

    @Test
    void backupFutbolistasJSON() {
    }

    @Test
    void resumenEquipos() {
    }
}