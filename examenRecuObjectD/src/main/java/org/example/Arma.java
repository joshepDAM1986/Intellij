package org.example;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idArma", nullable = false)
    private int idArma;
    private String arma;

    public Arma() {
    }

    public Arma(String arma) {
        this.arma = arma;
    }

    public int getIdArma() {
        return idArma;
    }

    public void setIdArma(int idArma) {
        this.idArma = idArma;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "idArma=" + idArma +
                ", arma='" + arma + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arma arma1 = (Arma) o;
        return idArma == arma1.idArma && Objects.equals(arma, arma1.arma);
    }
}
