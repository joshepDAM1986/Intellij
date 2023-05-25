package org.example;


import javax.persistence.*;


@Entity
public class Persona {
    @Id
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
}



