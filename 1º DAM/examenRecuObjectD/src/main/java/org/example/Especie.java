package org.example;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idEspecia", nullable = false)
    private int idEspecie;

    private String especie;

    public Especie() {
    }

    public Especie(String especie) {
        this.especie = especie;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Especie{" +
                "idEspecie=" + idEspecie +
                ", especie='" + especie + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especie especie1 = (Especie) o;
        return idEspecie == especie1.idEspecie && Objects.equals(especie, especie1.especie);
    }
}
