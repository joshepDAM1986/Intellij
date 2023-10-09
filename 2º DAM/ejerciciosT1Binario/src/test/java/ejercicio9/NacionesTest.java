package ejercicio9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class NacionesTest {

    Naciones dao;
    final String ruta_bin="src/main/java/ejercicio9/paises.bin";
    final String ruta_texto="src/main/java/ejercicio9/paises.txt";
    final String ruta_xml="src/main/java/ejercicio9/paises.xml";
    final String ruta_json="src/main/java/ejercicio9/paises.json";

    @BeforeEach
    void setUp() {
        dao=new Naciones();
        dao.añadirPais("Estados Unidos", "Washington D.C.", 331002651, 1776);
        dao.añadirPais("China", "Pekín", 1439323776, 221);
        dao.añadirPais("Brasil", "Brasilia", 212559417, 1822);
        dao.añadirPais("India", "Nueva Delhi", 1380004385, 1947);

    }



    @Test
    void guardarCargarPaises() {
        String valor_esperado=dao.mostrarTodo();

        dao.guardarPaises(ruta_bin);
        dao.cargarPaises(ruta_bin);

        String respuesta=dao.mostrarTodo();

        assertEquals(valor_esperado,respuesta);
    }

    @Test
    void mostrarTodo() {
        String valor_esperado="=======================\n"
                + "nombre=Estados Unidos\n"
                + "capital=Washington D.C.\n"
                + "habitantes=331002651\n"
                + "fundacion=1776\n"
        +"=======================\n"
                + "nombre=China\n"
                + "capital=Pekín\n"
                + "habitantes=1439323776\n"
                + "fundacion=221\n"
        +"=======================\n"
                + "nombre=Brasil\n"
                + "capital=Brasilia\n"
                + "habitantes=212559417\n"
                + "fundacion=1822\n"
        +"=======================\n"
                + "nombre=India\n"
                + "capital=Nueva Delhi\n"
                + "habitantes=1380004385\n"
                + "fundacion=1947\n";
        String respuesta=dao.mostrarTodo();
        assertEquals(valor_esperado,respuesta);

    }

    @Test
    void backupTexto() {
        dao.backupTexto(ruta_texto);
        //comprobar que el fichero contiene los datos de iniciales de los paises


    }

    @Test
    void backupXML() {
        dao.backupXML(ruta_xml);
    }

    @Test
    void backupJSON() {
        dao.backupJSON(ruta_json);
    }
}