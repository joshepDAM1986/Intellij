package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {


    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "id", nullable = false)

    private int id;
    private String matricula;
    @Embedded private Persona conductor; // campo tipo Persona
    public Vehiculo() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }
}