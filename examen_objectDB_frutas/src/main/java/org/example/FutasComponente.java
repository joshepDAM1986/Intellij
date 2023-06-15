package org.example;

import javax.persistence.*;

@Entity
public class FutasComponente{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int idPais;
    private String pais;

    public FutasComponente() {
    }

    public FutasComponente(String pais) {
        this.pais = pais;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "FutasComponente {" +
                "idPais=" + idPais +
                ", pais='" + pais + '\'' +
                '}';
    }

}
