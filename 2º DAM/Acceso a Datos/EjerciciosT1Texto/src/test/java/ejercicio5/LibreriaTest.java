package ejercicio5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.Utils;

import static org.junit.jupiter.api.Assertions.*;

class LibreriaTest {
    Libreria dao;

    final static String ruta_salida = "src/main/java/ejercicio5/salida.txt";

    @BeforeEach
    void setUp() {

        dao = new Libreria();
        dao.añadirLibro("Harry Potter y el caliz de fuego", "JK Rowling", 15.6, 900);
        dao.añadirLibro("La historia interminable", "Michael Ende", 5.96, 9);
        dao.añadirLibro("Codigo Da Vinci", "Dan Brown", 10.95, 20);
        dao.añadirLibro("Harry Potter y la piedra filosofal", "JK Rowling", 20.95, 300);
    }


    @Test
    void visualizarLibros() {
        String respuesta = dao.visualizarLibros();
        String valor_esperado = "=======================\n" +
                "titulo=Harry Potter y el caliz de fuego\n" +
                "precio=15.6\n" +
                "autor=JK Rowling\n" +
                "numero_ejemplares=900\n" +

                "=======================\n" +
                "titulo=La historia interminable\n" +
                "precio=5.96\n" +
                "autor=Michael Ende\n" +
                "numero_ejemplares=9\n" +

                "=======================\n" +
                "titulo=Codigo Da Vinci\n" +
                "precio=10.95\n" +
                "autor=Dan Brown\n" +
                "numero_ejemplares=20\n" +

                "=======================\n" +
                "titulo=Harry Potter y la piedra filosofal\n" +
                "precio=20.95\n" +
                "autor=JK Rowling\n" +
                "numero_ejemplares=300\n";

        assertEquals(valor_esperado, respuesta);
    }

    @Test
    void visualizarLibrosVacios() {
        String respuesta = dao.visualizarLibros(); //Comentar la linea 17 para poder probarlo con exito
        assertEquals("Librería vacía", respuesta);
    }

    @Test
    void guardarCargarLibros() {
        String valor_esperado = dao.visualizarLibros();

        dao.guardarLibros(ruta_salida);
        dao.cargarLibros(ruta_salida);

        String respuesta = dao.visualizarLibros();

        assertEquals(valor_esperado, respuesta);
    }

    @Test
    void buscarTitulo() {
        String valor_esperado = "=======================\n" +
                "titulo=La historia interminable\n" +
                "precio=5.96\n" +
                "autor=Michael Ende\n" +
                "numero_ejemplares=9\n";

        String respuesta = dao.buscarTitulo("La historia interminable");
        assertEquals(valor_esperado, respuesta);
    }

    @Test
    void buscarTituloNoExiste() {
        String respuesta = dao.buscarTitulo("Dune");
        assertEquals("No se encuentra el libro", respuesta);
    }

    @Test
    void buscarLibrosAutor() {
        String valor_esperado = "=======================\n" +
                "titulo=Harry Potter y el caliz de fuego\n" +
                "precio=15.6\n" +
                "autor=JK Rowling\n" +
                "numero_ejemplares=900\n" +
                "=======================\n" +
                "titulo=Harry Potter y la piedra filosofal\n" +
                "precio=20.95\n" +
                "autor=JK Rowling\n" +
                "numero_ejemplares=300\n";

        String respuesta = dao.buscarLibrosAutor("JK Rowling");
        assertEquals(valor_esperado, respuesta);

    }

    @Test
    void buscarLibrosAutorNoExiste() {
        String respuesta = dao.buscarLibrosAutor("Arturo Perez Reverte");
        assertEquals("No hay libros del autor buscado", respuesta);
    }


    @Test
    void modificarTitulo() {

        String valor_esperado = "=======================\n" +
                "titulo=Harry Potter y camara de los secretos\n" +
                "precio=15.6\n" +
                "autor=JK Rowling\n" +
                "numero_ejemplares=900\n" +

                "=======================\n" +
                "titulo=La historia interminable\n" +
                "precio=5.96\n" +
                "autor=Michael Ende\n" +
                "numero_ejemplares=9\n" +

                "=======================\n" +
                "titulo=Codigo Da Vinci\n" +
                "precio=10.95\n" +
                "autor=Dan Brown\n" +
                "numero_ejemplares=20\n" +

                "=======================\n" +
                "titulo=Harry Potter y la piedra filosofal\n" +
                "precio=20.95\n" +
                "autor=JK Rowling\n" +
                "numero_ejemplares=300\n";

        dao.modificarTitulo("Harry Potter y el caliz de fuego",
                "Harry Potter y camara de los secretos");
        assertEquals(valor_esperado, dao.visualizarLibros());
    }

    @Test
    void borrarLibro() {
        String valor_esperado = "=======================\n" +
                "titulo=Harry Potter y camara de los secretos\n" +
                "precio=15.6\n" +
                "autor=JK Rowling\n" +
                "numero_ejemplares=900\n" +

                "=======================\n" +
                "titulo=Codigo Da Vinci\n" +
                "precio=10.95\n" +
                "autor=Dan Brown\n" +
                "numero_ejemplares=20\n" +

                "=======================\n" +
                "titulo=Harry Potter y la piedra filosofal\n" +
                "precio=20.95\n" +
                "autor=JK Rowling\n" +
                "numero_ejemplares=300\n";

        dao.borrarLibro("La historia interminable");
        assertEquals(valor_esperado, dao.visualizarLibros());
    }
}