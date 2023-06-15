package org.example;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperacionesScannerlessTest {
    @Test

    public void testConsultarProductosQueryScannerless() {
        // Configuración previa al test
        EntityManager em = obtenerEntityManager();  // Obtén tu EntityManager
        int idEsperada = 123;  // ID que esperas encontrar

        // Llamada al método a probar
        consultarProductosQueryScannerless(em, idEsperada);

        // Verificación de los resultados
        // Aquí asumimos que solo esperas un único resultado en la lista
        Assert.assertFalse("No se encontraron productos", resultado.isEmpty());
        int idObtenida = resultado.get(0).getId();
        Assert.assertSame("La ID obtenida no coincide con la esperada", idEsperada, idObtenida);
    }

}