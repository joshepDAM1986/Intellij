
package com.mycompany.ejercicio_9_2;

import java.util.HashMap;

/**
 *
 * @author garci
 */

public class Pedido {
    private String id;
    private Clientes clientes;
    private HashMap<Producto, Integer> articulos;

    public Pedido(String id, Clientes clientes) {
        this.id = id;
        this.clientes = clientes;
        this.articulos = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public HashMap<Producto, Integer> getArticulos() {
        return articulos;
    }

    public void addArticulos(Producto producto, int unidades) {
        if (articulos.containsKey(producto))
            this.articulos.replace(producto, this.articulos.get(producto) + unidades);
        else
            this.articulos.put(producto, unidades);
    }
    
    public void borrarArticulos(Pedido  producto) {
        if (articulos.containsKey(producto)) {
            articulos.remove(producto); 
        }
    }
}