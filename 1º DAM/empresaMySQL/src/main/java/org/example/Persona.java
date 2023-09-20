package org.example;

import java.util.Objects;

public class Persona {
    private int id;
    private String dni;
    private String nombre;
    private int numRegistro;

    public Persona() {
    }

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Persona(String dni, String nombre, int numRegistro) {
        this.dni = dni;
        this.nombre = nombre;
        this.numRegistro = numRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona {");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');

        if (numRegistro > 0) {
            sb.append(", numRegistro=").append(numRegistro);
        }

        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id &&
                numRegistro == persona.numRegistro &&
                Objects.equals(dni, persona.dni) &&
                Objects.equals(nombre, persona.nombre);
    }
}