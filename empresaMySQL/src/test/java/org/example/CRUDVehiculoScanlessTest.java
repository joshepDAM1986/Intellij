package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class CRUDVehiculoScanlessTest {

    @Test
    void insertarVehiculo() {
        //Given
        Vehiculo esperado= new Vehiculo("1111AAA",
                "2001-01-01",null, null);
        Statement stmt = CRUDVehiculoScanless.conectar();
        boolean resultadoInsertar = false;
        //When
        if (stmt!=null) {
            resultadoInsertar = CRUDVehiculoScanless.insertarVehiculoScanless(stmt,"1111AAA",
                    "2001-01-01",null, null);
        }
        //Then
        assertTrue(resultadoInsertar);

        Vehiculo resultado = CRUDVehiculoScanless.consultarVehiculoScanless(stmt, esperado.getMatricula());
        assertEquals(resultado, esperado);
    }
    @Test
    void consultarVehiculo() {
        //Given
        Vehiculo esperado= null;
        Statement stmt = CRUDVehiculoScanless.conectar();
        boolean resultadoConsultar = false;
        //When
        if (stmt!=null) {
            esperado = CRUDVehiculoScanless.consultarVehiculoScanless(stmt,"1111AAA");
        }
        //Then
        Vehiculo resultado = CRUDVehiculoScanless.consultarVehiculoScanless(stmt, "1111AAA");
        assertEquals(resultado, esperado);
    }

    @Test
        //Given
    void modificarVehiculo(){
        Vehiculo esperado = new Vehiculo ("1111AAA",
                "2012-12-12","Electrico", "75162631B");
        Statement stmt = CRUDVehiculoScanless.conectar();
        Boolean resultadoModificar = false;
        //When
        if (stmt != null) {
            resultadoModificar = CRUDVehiculoScanless.modificarVehiculoScanless(stmt,39,"1111AAA",
                    "2012-12-12","Electrico", "75162631B");
        }
        //Then
        assertTrue(resultadoModificar);

        Vehiculo resultado = CRUDVehiculoScanless.consultarVehiculoScanless(stmt, esperado.getMatricula());
        assertEquals(resultado, esperado);
    }

    @Test
    void borrarVehiculo() {
        //Given
        Vehiculo esperado = null;
        Statement stmt = CRUDVehiculoScanless.conectar();
        Boolean resultadoBorrar = false;
        //When
        if (stmt != null) {
            resultadoBorrar = CRUDVehiculoScanless.borrarVehiculoScanless(stmt, "1111CCC");
        }
        //Then
        assertTrue(resultadoBorrar);
        Persona borrado = CRUDPersonaScanless.consultarPersonaScanless(stmt,"1111CCC");
        assertEquals(borrado,esperado);
    }
}
