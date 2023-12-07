package examen;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private ArrayList<Producto> lista_prods;

    // Constructor

    public Inventario() {
        this.lista_prods = new ArrayList<>();
    }

    private Producto encontrarProducto(String nombre) {
        Producto p = null;
        for (Producto producto : this.lista_prods) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                p = producto;
            }
        }
        return p;
    }

//  EJERCICIO 1  Terminar el método crearProducto que está incompleto para que compruebe previamente que el nombre del producto no existe previamente. En caso de existir muestra un mensaje por pantalla indicando dicha situación.

    public void crearProducto(String nombre, double precio, int stock, String categoria) {
        // Mejorar método
        Producto buscado = encontrarProducto(nombre);
        if (buscado == null) {
            Producto nuevo = new Producto(nombre, categoria, stock, precio);
            this.lista_prods.add(nuevo);
        } else {
            System.out.println("Producto ya existe");
        }
    }

    public String mostrarProductos() {
        String res = "";

        if (this.lista_prods.isEmpty()) {
            res = "No hay cursos";
        } else {
            for (Producto c : this.lista_prods) {
                res += c.toString();
            }
        }

        return res;
    }

    //EJERCICIO 2 Completar el método guardarTexto que crea un fichero con la ruta que se le pasa como parámetro y guarda todos los productos que existan en el ArrayList en ese momento con el mismo formato mostrado en la captura.
    public void guardarTexto(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);
            for (Producto producto : this.lista_prods) {
                pw.println(producto.getNombre() + "|" + producto.getCategoria() + "|" + producto.getStock() + "|" + producto.getPrecio());
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //EJERCICIO 3 Completar el método cargarTexto que abre el fichero con la ruta que se pasa como parámetro y debe leer todos los datos de productos que contiene el fichero y almacenarlos en objetos de la clase Producto añadiéndolos en un ArrayList llamado lista_prods que es un atributo de la clase Inventario. Se debe vaciar previamente los datos del ArrayLisy antes de añadir los datos del fichero y hay que evitar nombre de productos repetidos. Completar el test guardarCargarTexto que prueba los dos metodos anteriores. Usar la variable final ruta_texto.

    public void cargarTexto(String ruta) {
        this.lista_prods.clear();
        String linea, nombre, categoria;
        int stock;
        double precio;
        String[] partes;
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                partes = linea.split("\\|");
                nombre = partes[0];
                categoria = partes[1];
                stock = Integer.parseInt(partes[2]);
                precio = Double.parseDouble(partes[3]);
                crearProducto(nombre, precio, stock, categoria);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //EJERCICIO 4 Completar el método guardarBinario que crea un fichero con la ruta que se le pasa como parámetro. En el guarda todos los productos que existan en el ArrayList con serializacion de ficheros binarios añadiendo los elementos necesarios para que funcione la serializacion.
    public void guardarBinario(String ruta) {
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Producto producto : this.lista_prods) {
                oos.writeObject(producto);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //EJERCICIO 5 Completar el método cargarBinario que abre el fichero que se le pase como parámetro que se guardó con el formato del ejercicio anterior (binario serializado) y debe leer todos los datos de productos que contiene e introducirlos en el ArrayList. Se debe vaciar previamente los datos del ArrayLisy antes y hay que evitar nombre de productos repetidos. Completar el test guardarCargarBinario que prueba los dos metodos anteriores. Usar la variable final ruta_bin.

    public void cargarBinario(String ruta) {
        this.lista_prods.clear();
        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Producto producto = (Producto) ois.readObject();
                lista_prods.add(producto);
            }
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //EJERCICIO 6 Completar el método buscarEnInventario que recibe un parametro String que es el nombre del producto a buacar y devuelve un String con los datos del producto si existe en la lista (toString de la clase Producto) y si no existe ese producto “no se ha encontrado ese producto”. Completar los tests existeProducto y noExisteProducto que prueba el metodo anterior de dos formas distintas.

    public String buscarEnInventario(String nombre) {
        String res = "No se ha encontrado ese producto";
        if (this.lista_prods.isEmpty()) {
            res = "No hay producos ";
        } else {
            for (Producto producto : this.lista_prods) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    res = producto.toString();
                }
            }
        }
        return res;
    }

    //EJERCICIO 7 Completar el método informeInventario que devuelve un String con el dinero total que hay por categoria de productos. Para ello debe multiplicar la cantidad de producto por su PVP y acumularlo en su categoria.

    public String informeInventario() {
        Map<String, Double> hm = new HashMap<>();
        String res = "";
        if (this.lista_prods.isEmpty()) {
            res = "No hay productos";
        } else {
            for (Producto producto : this.lista_prods) {
                if (hm.containsKey(producto.getCategoria())) {
                    double contador = hm.get(producto.getCategoria());
                    hm.put(producto.getCategoria(), contador + producto.getPrecio() * producto.getStock());
                } else {
                    hm.put(producto.getCategoria(), producto.getPrecio() * producto.getStock());
                }
            }
            for (String llave : hm.keySet()) {
                res += llave.toUpperCase() + "=>" + hm.get(llave) + "\n";
            }


        }
        return res;
    }


    //EJERCICIO 8 Completar el método backupXML que crea un fichero con ruta que se le pase como parámetro y guarda los productos que han generado entre 2000 y 3000 € en un fichero XML con el siguiente formato

    public void backupXML(String rutaArchivo) {
        try {
            FileWriter fw = new FileWriter(rutaArchivo);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("<almacenes>");
            for (Producto producto : this.lista_prods) {
                double generado = producto.getPrecio() * producto.getStock();
                if (generado >= 2000 && generado <= 3000) {
                    pw.println("    <producto>\n" +
                            "       <nombre>" + producto.getNombre() + "</nombre>\n" +
                            "       <categoria>" + producto.getCategoria() + "</categoria>\n" +
                            "       <stock>" + producto.getStock() + "</stock>\n" +
                            "       <precio>" + producto.getPrecio() + "</precio>\n" +
                            "    </producto>");
                }
            }
            pw.println("</almacenes>");
            pw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
