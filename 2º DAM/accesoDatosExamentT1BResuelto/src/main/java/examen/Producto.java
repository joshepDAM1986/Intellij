package examen;

import java.io.Serializable;

public class Producto implements Serializable {
    private final static long serialVersionUID = 1128564234553423455L;
    private String nombre;
    private String categoria;
    private int stock;
    private double precio;

    // Constructor
    public Producto(String nombre, String categoria, int stock, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + '\n' +
                "\tnombre=" + nombre + '\n' +
                "\tcategoria=" + categoria + '\n' +
                "\tstock=" + stock + '\n' +
                "\tprecio=" + precio + '\n' +
                '}' + '\n';
    }
}
