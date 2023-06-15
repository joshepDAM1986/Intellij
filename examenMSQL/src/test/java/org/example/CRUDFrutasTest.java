package org.example;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class CRUDFrutasTest {


    @Test
    void consultarFrutas() {
        //Given
        Frutas esperada= null;
        Statement stmt = CRUDFrutas.conectar();
        boolean resultadoConsultar = false;
        //When
        if (stmt!=null) {
            esperada = CRUDFrutas.consultarFrutas(stmt,59);
        }
        //Then
        Frutas resultado = CRUDFrutas.consultarFrutas(stmt, 58);
        assertEquals(resultado, esperada);
    }
}

