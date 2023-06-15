package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class JDBCTest {

    @Test
    void insertar() {
        //Given
        Fruta esperado= new Fruta("Sandía23",
        3F, "Fresquita", "España");
        Statement stmt = JDBC.conectar();
        boolean resultadoInsertar = false;
        //When
        if (stmt!=null) {
            resultadoInsertar = JDBC.insertar(stmt, "Sandía23",
                    3F, "Fresquita", "España");
        }
        //Then
        assertTrue(resultadoInsertar);

        Fruta resultado = JDBC.consultar(stmt, esperado.getNombre());
        assertEquals(resultado, esperado);

    }
}