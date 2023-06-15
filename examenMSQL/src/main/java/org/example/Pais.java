package org.example;

import java.util.Objects;

/**
 * Esta clase representa un objeto Pais que contiene información sobre un país.
 */
public class Pais {
    private int id;
    private String español;
    private String ingles;

    /**
     * Crea una nueva instancia de Pais sin inicializar los atributos.
     */
    public Pais() {
    }

    /**
     * Crea una nueva instancia de Pais con los atributos especificados.
     *
     * @param español el nombre del país en español.
     * @param ingles  el nombre del país en inglés.
     */
    public Pais(String español, String ingles) {
        this.español = español;
        this.ingles = ingles;
    }

    /**
     * Obtiene el nombre del país en español.
     *
     * @return el nombre del país en español.
     */
    public String getEspañol() {
        return español;
    }

    /**
     * Establece el nombre del país en español.
     *
     * @param español el nombre del país en español.
     */
    public void setEspañol(String español) {
        this.español = español;
    }

    /**
     * Obtiene el nombre del país en inglés.
     *
     * @return el nombre del país en inglés.
     */
    public String getIngles() {
        return ingles;
    }

    /**
     * Establece el nombre del país en inglés.
     *
     * @param ingles el nombre del país en inglés.
     */
    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    /**
     * Devuelve una representación en cadena del país.
     *
     * @return una representación en cadena del país.
     */
    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", español='" + español + '\'' +
                ", ingles='" + ingles + '\'' +
                '}';
    }

    /**
     * Compara si el país actual es igual a otro objeto dado.
     *
     * @param o el objeto a comparar.
     * @return true si el país es igual al objeto dado, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return id == pais.id && Objects.equals(español, pais.español) && Objects.equals(ingles, pais.ingles);
    }
}
