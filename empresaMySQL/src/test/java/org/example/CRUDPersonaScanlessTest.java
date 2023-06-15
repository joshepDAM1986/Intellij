package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class CRUDPersonaScanlessTest {
    @Test
    void insertarPersona() {
        //Given
        Persona esperado= new Persona("75162631B",
                "Joselito Garcia Navarro", 958);
        Statement stmt = CRUDPersonaScanless.conectar();
        boolean resultadoInsertar = false;
        //When
        if (stmt!=null) {
            resultadoInsertar = CRUDPersonaScanless.insertarPersonaScanless(stmt,"75162631B",
                    "Joselito Garcia Navarro", 958);
        }
        //Then
        assertTrue(resultadoInsertar);

        Persona resultado = CRUDPersonaScanless.consultarPersonaScanless(stmt, esperado.getDni());
        assertEquals(resultado, esperado);
    }
    @Test
    void consultarPersona() {
        //Given
        Persona esperada= null;
        Statement stmt = CRUDPersonaScanless.conectar();
        boolean resultadoConsultar = false;
        //When
        if (stmt!=null) {
            esperada = CRUDPersonaScanless.consultarPersonaScanless(stmt,"75162631B");
        }
        //Then
        Persona resultado = CRUDPersonaScanless.consultarPersonaScanless(stmt, "75162631B");
        assertEquals(resultado, esperada);
    }

    @Test
    //Given
    void modificarPersona(){
        Persona esperada = new Persona ("75162631C","Joselito Garcia Casas",627);
        Statement stmt = CRUDPersonaScanless.conectar();
        Boolean resultadoModificar = false;
        //When
        if (stmt != null) {
            resultadoModificar = CRUDPersonaScanless.modificarPersonaScanless(stmt,79, "75162631C", "Joselito Garcia Casas",627);
        }
        //Then
        assertTrue(resultadoModificar);

        Persona resultado = CRUDPersonaScanless.consultarPersonaScanless(stmt, esperada.getDni());
        assertEquals(resultado, esperada);
    }

    @Test
    void borrarPersona() {
        //Given
        Persona esperada = null;
        Statement stmt = CRUDPersonaScanless.conectar();
        Boolean resultadoBorrar = false;
        //When
        if (stmt != null) {
            resultadoBorrar = CRUDPersonaScanless.borrarPersonaScanless(stmt, "75127845D");
        }
        //Then
        assertTrue(resultadoBorrar);
        Persona borrada = CRUDPersonaScanless.consultarPersonaScanless(stmt,"75127845D ");
        assertEquals(borrada,esperada);
    }
}
