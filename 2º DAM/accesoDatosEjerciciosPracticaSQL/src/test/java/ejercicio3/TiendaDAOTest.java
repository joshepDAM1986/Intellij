package ejercicio3;

import ejercicio2.ClubDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.BasesDatos;

import static org.junit.jupiter.api.Assertions.*;

class TiendaDAOTest {

    TiendaDAO dao;

    @BeforeEach
    void setUp() {

        String ruta_scrip = "src/main/java/ejercicio3/script_datos.sql";
        BasesDatos.borrarDatos("tienda");
        BasesDatos.volcarDatos(ruta_scrip,"tienda");

        dao = new TiendaDAO("localhost", "tienda", "root", "");
    }

    @Test
    void añadirVenta() {
        dao.añadirVenta("Paco Menendez","Barra de pan",5);
    }

    @Test
    void comprasCliente() {
        String esperado="Botella de vino 3\n" +
                "Botella de agua 10\n";
        String actual=dao.comprasCliente("Pepe Luis Jimenez");
        assertEquals(esperado,actual);
    }

    @Test
    void recaudacionTotal() {
        Double esperado=224.0;
        Double actual=dao.recaudacionTotal();
        assertEquals(esperado,actual);
    }

    @Test
    void porCategorias() {
        String esperado="Bebida 24\n" +
                "Comida 5\n" +
                "Otros 0\n";
        String actual=dao.porCategorias();
        assertEquals(esperado,actual);
    }

    @Test
    void ultimaVenta() {
        String esperado="Paco Menendez Plato de macarrones 2021-10-11\n";

        String actual=dao.ultimaVenta();
        assertEquals(esperado,actual);
    }

    @Test
    void masVendido() {
        String esperado="Botella de agua 17\n";
        String actual=dao.masVendido();
        assertEquals(esperado,actual);
    }

    @Test
    void sinVentas() {
        String esperado="Barra de pan\n";
        String actual=dao.sinVentas();
        assertEquals(esperado,actual);
    }


    @Test
    void borrarProveedor() {
        dao.borrarProveedor("Innovate Supply Co.");
    }
}