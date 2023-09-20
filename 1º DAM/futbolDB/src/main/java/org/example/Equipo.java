package org.example;

class Equipo {
    private int codigo;
    private String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}