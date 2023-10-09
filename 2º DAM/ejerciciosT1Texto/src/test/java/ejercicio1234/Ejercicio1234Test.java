package ejercicio1234;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ejercicio1234Test {

    Ejercicio1234 dao;
    final String url_empleados = "src/main/java/ejercicio1234/empleados.txt";
    final String url = "src/main/java/ejercicio1234/numeros.txt";

    @BeforeEach
    void setUp() {
        dao = new Ejercicio1234();

    }

    @Test
    void ejercicio1() {
        assertEquals(152, dao.ejercicio1(url), "Test ejercicio1");
    }

    @Test
    void ejercicio2() {
        final String resultado = "Antonio\n" +
                "Sonia\n" +
                "Jose\n" +
                "Fernando\n";
        assertEquals(resultado, dao.ejercicio2(url_empleados), "Test ejercicio2");
    }

    @Test
    void ejercicio3() {
        final String url_salida = "src/main/java/ejercicio1234/empleados_mod.txt";
        dao.ejercicio3(url_empleados,url_salida);

    }

    @Test
    void ejercicio4() {

        final String url_salida = "src/main/java/ejercicio1234/provincias.txt";
        dao.ejercicio4(url_empleados,url_salida);

     }



}