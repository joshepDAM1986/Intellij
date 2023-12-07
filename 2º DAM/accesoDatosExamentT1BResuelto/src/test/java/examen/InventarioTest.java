package examen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventarioTest {

    final static String ruta_texto="src/main/java/examen/productos.txt";
    final static String ruta_bin="src/main/java/examen/productos.bin";
    final static String ruta_xml="src/main/java/examen/productos.xml";

    Inventario dao;

    @BeforeEach
    void setUp(){
        dao=new Inventario();
        dao.crearProducto("Televisor LED", 499.99, 5, "Electrónica");
        dao.crearProducto("Tablet", 199.99, 15, "Electrónica");
        dao.crearProducto("Auriculares Bluetooth", 59.99, 30, "Electrónica");
        dao.crearProducto("Cámara DSLR", 899.99, 8, "Fotografía");
        dao.crearProducto("Impresora Multifunción", 149.99, 12, "Oficina");
        dao.crearProducto("Altavoz Inteligente", 79.99, 18, "Electrónica");
        dao.crearProducto("Teclado Mecánico", 89.99, 25, "Computadoras");
        dao.crearProducto("Mouse Inalámbrico", 29.99, 22, "Computadoras");
    }

    @Test
    void testVisualizar(){
        String valor_esperado="Producto{\n" +
                "\tnombre=Televisor LED\n" +
                "\tcategoria=Electrónica\n" +
                "\tstock=5\n" +
                "\tprecio=499.99\n" +
                "}\n" +
                "Producto{\n" +
                "\tnombre=Tablet\n" +
                "\tcategoria=Electrónica\n" +
                "\tstock=15\n" +
                "\tprecio=199.99\n" +
                "}\n" +
                "Producto{\n" +
                "\tnombre=Auriculares Bluetooth\n" +
                "\tcategoria=Electrónica\n" +
                "\tstock=30\n" +
                "\tprecio=59.99\n" +
                "}\n" +
                "Producto{\n" +
                "\tnombre=Cámara DSLR\n" +
                "\tcategoria=Fotografía\n" +
                "\tstock=8\n" +
                "\tprecio=899.99\n" +
                "}\n" +
                "Producto{\n" +
                "\tnombre=Impresora Multifunción\n" +
                "\tcategoria=Oficina\n" +
                "\tstock=12\n" +
                "\tprecio=149.99\n" +
                "}\n" +
                "Producto{\n" +
                "\tnombre=Altavoz Inteligente\n" +
                "\tcategoria=Electrónica\n" +
                "\tstock=18\n" +
                "\tprecio=79.99\n" +
                "}\n" +
                "Producto{\n" +
                "\tnombre=Teclado Mecánico\n" +
                "\tcategoria=Computadoras\n" +
                "\tstock=25\n" +
                "\tprecio=89.99\n" +
                "}\n" +
                "Producto{\n" +
                "\tnombre=Mouse Inalámbrico\n" +
                "\tcategoria=Computadoras\n" +
                "\tstock=22\n" +
                "\tprecio=29.99\n" +
                "}\n";

        assertEquals(valor_esperado,dao.mostrarProductos());

    }

    @Test
    void guardarCargarTexto() {
            String esperado = dao.mostrarProductos();
            dao.guardarTexto(ruta_texto);
            dao.cargarTexto(ruta_texto);
            String res = dao.mostrarProductos();
            assertEquals(esperado,res);
    }

    @Test
    void guardarCargarBinario() {
        String esperado = dao.mostrarProductos();
        dao.guardarBinario(ruta_bin);
        dao.cargarBinario(ruta_bin);
        String res = dao.mostrarProductos();
        assertEquals(esperado,res);
    }

    @Test
    void existeProducto() {
        String esperado = "Producto{\n" +
                "\tnombre=Tablet\n" +
                "\tcategoria=Electrónica\n" +
                "\tstock=15\n" +
                "\tprecio=199.99\n" +
                "}\n";
        String res = dao.buscarEnInventario("Tablet");
        assertEquals(esperado,res);
    }

    @Test
    void noexisteProducto() {
        String esperado = "No se ha encontrado ese producto";
        String res = dao.buscarEnInventario("Móvil");
        assertEquals(esperado,res);
    }


    @Test
    void informeInventario() {
        String valor_esperado="COMPUTADORAS=>2909.5299999999997\n" +
                "ELECTRÓNICA=>8739.32\n" +
                "OFICINA=>1799.88\n" +
                "FOTOGRAFÍA=>7199.92\n";


        assertEquals(valor_esperado,dao.informeInventario());
    }

    @Test
    void backupXML() {
        dao.backupXML(ruta_xml);
    }
}