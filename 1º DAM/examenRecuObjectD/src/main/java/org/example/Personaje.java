package org.example;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idPersonaje", nullable = false)
    private int idPersonaje;
    private String nombre;
    private String descripción;
    private int edad;
    private float altura;
    @ManyToOne
    private Especie especie;
    @ManyToOne
    private Arma arma;
    @ManyToOne
    private Afiliacion afiliacion;

    public Personaje() {
    }

    public Personaje(String nombre, Especie especie, String descripción, int edad, float altura, Arma arma, Afiliacion afiliacion) {
        this.nombre = nombre;
        this.descripción = descripción;
        this.edad = edad;
        this.altura = altura;
        this.especie = especie;
        this.arma = arma;
        this.afiliacion = afiliacion;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Afiliacion getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(Afiliacion afiliacion) {
        this.afiliacion = afiliacion;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "idPersonaje=" + idPersonaje +
                ", nombre='" + nombre + '\'' +
                ", descripción='" + descripción + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                ", especie=" + especie +
                ", arma=" + arma +
                ", afiliacion=" + afiliacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return idPersonaje == personaje.idPersonaje && edad == personaje.edad && Float.compare(personaje.altura, altura) == 0 && Objects.equals(nombre, personaje.nombre) && Objects.equals(descripción, personaje.descripción) && Objects.equals(especie, personaje.especie) && Objects.equals(arma, personaje.arma) && Objects.equals(afiliacion, personaje.afiliacion);
    }
}
