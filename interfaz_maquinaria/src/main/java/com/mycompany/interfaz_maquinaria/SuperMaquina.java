
package com.mycompany.interfaz_maquinaria;

/**
 *
 * @author garci
 */
public class SuperMaquina {
    private String nSerie;
    private String modelo;
    private int horas;

    public SuperMaquina(String nSerie, String modelo) {
        this.nSerie = nSerie;
        this.modelo = modelo;
        horas=0;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

}
