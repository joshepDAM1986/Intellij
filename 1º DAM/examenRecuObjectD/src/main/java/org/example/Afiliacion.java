package org.example;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Afiliacion {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idAfiliacion", nullable = false)
    private int idAfiliacion;
    private String afiliacion;

    public Afiliacion() {
    }

    public Afiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public int getIdAfiliacion() {
        return idAfiliacion;
    }

    public void setIdAfiliacion(int idAfiliacion) {
        this.idAfiliacion = idAfiliacion;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    @Override
    public String toString() {
        return "Afiliacion{" +
                "idAfiliacion=" + idAfiliacion +
                ", afiliacion='" + afiliacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Afiliacion that = (Afiliacion) o;
        return idAfiliacion == that.idAfiliacion && Objects.equals(afiliacion, that.afiliacion);
    }
}
