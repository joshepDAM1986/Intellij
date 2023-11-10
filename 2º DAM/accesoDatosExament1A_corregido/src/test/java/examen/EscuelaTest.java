package examen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EscuelaTest {

    final static String ruta_texto="src/main/java/examen/cursos.txt";
    final static String ruta_bin="src/main/java/examen/cursos.bin";
    final static String ruta_xml="src/main/java/examen/cursos.xml";

    Escuela dao;

    @BeforeEach
    void setUp(){
        dao=new Escuela();
        dao.insertarCurso("Iniciacion a la magia", "presencial", 140, 367.86);
        dao.insertarCurso("Programacion en Java", "online", 100, 123.57);
        dao.insertarCurso("Jardineria avanzada", "presencial", 90, 21.54);
        dao.insertarCurso("Como ser influencer", "online", 123, 300.12);
        dao.insertarCurso("Marketing online", "mixta", 150, 98.3);
        dao.insertarCurso("Ciencia de los datos", "online", 120, 190.12);
    }

    @Test
    void testVisualizar(){
        String valor_esperado="###########################\n" +
                "Nombre:Iniciacion a la magia\n" +
                "Modalidad:presencial\n" +
                "Matriculados:140 alumnos\n" +
                "Precio:367.86 euros\n" +
                "###########################\n" +
                "Nombre:Programacion en Java\n" +
                "Modalidad:online\n" +
                "Matriculados:100 alumnos\n" +
                "Precio:123.57 euros\n" +
                "###########################\n" +
                "Nombre:Jardineria avanzada\n" +
                "Modalidad:presencial\n" +
                "Matriculados:90 alumnos\n" +
                "Precio:21.54 euros\n" +
                "###########################\n" +
                "Nombre:Como ser influencer\n" +
                "Modalidad:online\n" +
                "Matriculados:123 alumnos\n" +
                "Precio:300.12 euros\n" +
                "###########################\n" +
                "Nombre:Marketing online\n" +
                "Modalidad:mixta\n" +
                "Matriculados:150 alumnos\n" +
                "Precio:98.3 euros\n" +
                "###########################\n" +
                "Nombre:Ciencia de los datos\n" +
                "Modalidad:online\n" +
                "Matriculados:120 alumnos\n" +
                "Precio:190.12 euros\n";

        assertEquals(valor_esperado,dao.visualizarCursos());
    }

    @Test
    void guardarCargarTexto() {
        String esperado= dao.visualizarCursos();
        dao.guardarTexto(ruta_texto);
        dao.cargarTexto(ruta_texto);
        String actual= dao.visualizarCursos();
        assertEquals(esperado,actual);

    }

    @Test
    void guardarCargarBinario() {
        String esperado= dao.visualizarCursos();
        dao.guardarBinario(ruta_bin);
        dao.cargarBinario(ruta_bin);
        String actual= dao.visualizarCursos();
        assertEquals(esperado,actual);

    }

    @Test
    void hayCursosOnline() {
        String esperado="###########################\n" +
                "Nombre:Programacion en Java\n" +
                "Modalidad:online\n" +
                "Matriculados:100 alumnos\n" +
                "Precio:123.57 euros\n" +
                "###########################\n"+
                "Nombre:Ciencia de los datos\n" +
                "Modalidad:online\n" +
                "Matriculados:120 alumnos\n" +
                "Precio:190.12 euros\n";
        String actual = dao.cursosOnline();
        assertEquals(esperado,actual);

    }

    @Test
    void noHayCursosOnline() {
        String esperado="";
        String actual =dao.cursosOnline();
        assertEquals(esperado,actual);
    }


    @Test
    void resumenAlumnos() {
        String valor_esperado="MIXTA:14745.0\n" +
                "ONLINE:72086.16\n" +
                "PRESENCIAL:53439.0\n";

        assertEquals(valor_esperado,dao.resumenAlumnos());
    }

    @Test
    void backupXML() {
        dao.backupXML(ruta_xml);
    }
}