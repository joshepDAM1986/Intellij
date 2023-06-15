package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Vehiculo {

    private int id;
    private String matricula;
    private String fechMatriculacion;

    private String tipoEnergia;

    private String conductor;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String fechMatriculacion) {
        this.matricula = matricula;
        this.fechMatriculacion = fechMatriculacion;
    }

    public Vehiculo(String matricula, String fechMatriculacion, String conductor) {
        this.id = id;
        this.matricula = matricula;
        this.fechMatriculacion = fechMatriculacion;
        this.conductor = conductor;
    }

    public Vehiculo(String matricula, String fechMatriculacion, String tipoEnergia, String conductor) {
        this.id = id;
        this.matricula = matricula;
        this.fechMatriculacion = fechMatriculacion;
        this.tipoEnergia = tipoEnergia;
        this.conductor = conductor;
    }


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

    public String getFechMatriculacion() {
        return fechMatriculacion;
    }

    public void setFechMatriculacion(String fechaMatriculacion) {
        this.fechMatriculacion = fechaMatriculacion;
    }

    public String getConductor() {
        return conductor;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", fechMatriculacion=" + fechMatriculacion +
                ", tipoEnergia=" + tipoEnergia +
                ", conductor=" + conductor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula) &&
                Objects.equals(fechMatriculacion, vehiculo.fechMatriculacion) &&
                Objects.equals(tipoEnergia, vehiculo.tipoEnergia) &&
                Objects.equals(conductor, vehiculo.conductor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, fechMatriculacion, tipoEnergia, conductor);
    }
}



