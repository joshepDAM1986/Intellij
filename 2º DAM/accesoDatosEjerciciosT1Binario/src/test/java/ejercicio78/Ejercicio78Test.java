package ejercicio78;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Ejercicio78Test {

    final String ruta_binario="src/main/java/ejercicio78/alumnos.bin";
    final String ruta_texto="src/main/java/ejercicio78/alumnos.dat";
    final String nuevo_texto="src/main/java/ejercicio78/alumnos.txt";

    Ejercicio78 dao;
    @BeforeEach
    void setUp() {
        dao=new Ejercicio78();
    }

    @Test
    void crearTexto2Binario2Texto() {

        dao.crearBinario(ruta_texto,ruta_binario);
        dao.crearTexto(ruta_binario,nuevo_texto);

        //comprobar que alumnos.dat y alumnos.txt coincide
    }

}