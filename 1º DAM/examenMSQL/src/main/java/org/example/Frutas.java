package org.example;

import java.util.Objects;

/**
 * Esta clase representa un objeto Frutas que contiene información sobre una fruta.
 */
public class Frutas {
    private int id;
    private String nommbre;
    private String descripciopn;
    private float precio;
    private int pais;

    /**
     * Crea una nueva instancia de Frutas sin inicializar los atributos.
     */
    public Frutas() {
    }

    /**
     * Crea una nueva instancia de Frutas con los atributos especificados.
     *
     * @param nommbre      el nombre de la fruta.
     * @param descripciopn la descripción de la fruta.
     * @param precio       el precio de la fruta.
     * @param pais         el identificador del país de origen de la fruta.
     */
    public Frutas(String nommbre, String descripciopn, float precio, int pais) {
        this.nommbre = nommbre;
        this.descripciopn = descripciopn;
        this.precio = precio;
        this.pais = pais;
    }

    /**
     * Obtiene el identificador de la fruta.
     *
     * @return el identificador de la fruta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la fruta.
     *
     * @param id el identificador de la fruta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la fruta.
     *
     * @return el nombre de la fruta.
     */
    public String getNommbre() {
        return nommbre;
    }

    /**
     * Establece el nombre de la fruta.
     *
     * @param nommbre el nombre de la fruta.
     */
    public void setNommbre(String nommbre) {
        this.nommbre = nommbre;
    }

    /**
     * Obtiene la descripción de la fruta.
     *
     * @return la descripción de la fruta.
     */
    public String getDescripciopn() {
        return descripciopn;
    }

    /**
     * Establece la descripción de la fruta.
     *
     * @param descripciopn la descripción de la fruta.
     */
    public void setDescripciopn(String descripciopn) {
        this.descripciopn = descripciopn;
    }

    /**
     * Obtiene el precio de la fruta.
     *
     * @return el precio de la fruta.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la fruta.
     *
     * @param precio el precio de la fruta.
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el identificador del país de origen de la fruta.
     *
     * @return el identificador del país de origen de la fruta.
     */
    public int getPais() {
        return pais;
    }

    /**
     * Establece el identificador del país de origen de la fruta.
     *
     * @param pais el identificador del país de origen de la fruta.
     */
    public void setPais(int pais) {
        this.pais = pais;
    }

    /**
     * Devuelve una representación en cadena de la fruta.
     *
     * @return una representación en cadena de la fruta.
     */
    @Override
    public String toString() {
        return "Frutas{" +
                "id=" + id +
                ", nommbre='" + nommbre + '\'' +
                ", descripciopn='" + descripciopn + '\'' +
                ", precio=" + precio +
                ", pais=" + pais +
                '}';
    }

    /**
     * Compara si la fruta actual es igual a otro objeto dado.
     *
     * @param o el objeto a comparar.
     * @return true si la fruta es igual al objeto dado, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frutas frutas = (Frutas) o;
        return id == frutas.id && Float.compare(frutas.precio, precio) == 0 && pais == frutas.pais && Objects.equals(nommbre, frutas.nommbre) && Objects.equals(descripciopn, frutas.descripciopn);
    }
}
