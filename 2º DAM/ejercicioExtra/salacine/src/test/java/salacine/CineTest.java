package salacine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CineTest {

    final static String ruta_texto="src/main/java/salacine/cine.txt";
    final static String ruta_bin="src/main/java/salacine/cine.bin";
    final static String ruta_xml="src/main/java/salacine/cine.xml";

    Cine dao;
    @BeforeEach
    void setUp() {
        dao=new Cine();
        dao.añadirPelicula("Los vengadores", "superheroes", 367.86, 140);
        dao.añadirPelicula("La monja", "terror", 123.57, 100);
        dao.añadirPelicula("El reino", "suspense", 21.54, 90);
        dao.añadirPelicula("Scream 3", "terror", 300.12, 123);
        dao.añadirPelicula("Pulp Fiction", "drama", 98.3, 150);
        dao.añadirPelicula("La Liga de la justicia", "superheroes", 190.12, 120);
    }

    @Test
    void visualizarPeliculas() {
        String valor_esperado="-----------------------------\n" +
                "Nombre: Los vengadores\n" +
                "Genero: superheroes\n" +
                "Duracion: 140 minutos\n" +
                "Recaudacion: 367.86 millones de dolares\n" +
                "-----------------------------\n" +
                "Nombre: La monja\n" +
                "Genero: terror\n" +
                "Duracion: 100 minutos\n" +
                "Recaudacion: 123.57 millones de dolares\n" +
                "-----------------------------\n" +
                "Nombre: El reino\n" +
                "Genero: suspense\n" +
                "Duracion: 90 minutos\n" +
                "Recaudacion: 21.54 millones de dolares\n" +
                "-----------------------------\n" +
                "Nombre: Scream 3\n" +
                "Genero: terror\n" +
                "Duracion: 123 minutos\n" +
                "Recaudacion: 300.12 millones de dolares\n" +
                "-----------------------------\n" +
                "Nombre: Pulp Fiction\n" +
                "Genero: drama\n" +
                "Duracion: 150 minutos\n" +
                "Recaudacion: 98.3 millones de dolares\n" +
                "-----------------------------\n" +
                "Nombre: La Liga de la justicia\n" +
                "Genero: superheroes\n" +
                "Duracion: 120 minutos\n" +
                "Recaudacion: 190.12 millones de dolares\n";

        String valor_real=dao.visualizarPeliculas();
        assertEquals(valor_esperado,valor_real);
    }

    @Test
    void guardarCargarTexto() {
        String valor_esperado = dao.visualizarPeliculas();

        dao.guardarTexto(ruta_texto);
        dao.cargarTexto(ruta_texto);

        String respuesta = dao.visualizarPeliculas();

        assertEquals(valor_esperado, respuesta);
    }

    @Test
    void guardarCargarBinario() {
        String valor_esperado=dao.visualizarPeliculas();

        dao.guardarBinario(ruta_bin);
        dao.cargarBinario(ruta_bin);

        String respuesta=dao.visualizarPeliculas();

        assertEquals(valor_esperado,respuesta);
    }

    @Test
    void buscarExiste() {
        String valor_esperado ="-----------------------------\n" +
                "Nombre: Los vengadores\n" +
                "Genero: superheroes\n" +
                "Duracion: 140 minutos\n" +
                "Recaudacion: 367.86 millones de dolares\n";

        String respuesta=dao.buscarPelicula("Los vengadores");
        assertEquals(valor_esperado,respuesta);

    }


    @Test
    void buscarNoExiste() {
        String esperado=null;
        String resultado= dao.buscarPelicula("Los puentes de Madison");
        assertEquals(esperado,resultado);
    }
    @Test
    void dineroSuperheroes() {
        double suma=dao.dineroSuperheroes();
        assertEquals(suma,557.98);
    }

    @Test
    void exportarmejores() { dao.exportarmejores(ruta_xml);
    }
}