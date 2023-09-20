package org.example;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue
    @Column (name = "id", nullable = false)
    private int id;
    private String matricula;
    private LocalDate fechaMatriculacion;
    @Enumerated(EnumType.STRING)
    private TipoEnergia tipoEnergia;
    @Embedded
    private Persona conductor;

    public Vehiculo() {
    }

    public Vehiculo( String matricula,LocalDate fechaMatriculacion, Persona conductor) {
        this.id = id;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.conductor = conductor;
    }

    public Vehiculo(String matricula, LocalDate fechaMatriculacion, TipoEnergia tipoEnergia, Persona conductor) {
        this.id = id;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.tipoEnergia = tipoEnergia;
        this.conductor = conductor;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public Persona getConductor() {
        return conductor;
    }

    public TipoEnergia getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(TipoEnergia tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehículo {");
        sb.append("id='").append(id).append('\'');
        sb.append("matricula='").append(matricula).append('\'');
        sb.append(", fechaMatriculacion='").append(fechaMatriculacion).append('\'');

        if (tipoEnergia == TipoEnergia.GASOLINA || tipoEnergia == TipoEnergia.DIESEL ||
                tipoEnergia == TipoEnergia.ELECTRICO || tipoEnergia == TipoEnergia.HIBRIDO ) {
            sb.append(", tipoEnergia=").append(tipoEnergia);
        }

        sb.append(", conductor='").append(conductor).append('\'');

        sb.append('}');
        return sb.toString();
    }
}
