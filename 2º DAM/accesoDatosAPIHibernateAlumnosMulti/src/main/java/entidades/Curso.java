package entidades;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cursos")
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false)
    @Expose
    private String nombre;

    @Column(name = "tipo", length = 50, nullable = false)
    @Expose
    private String tipo;

    @Column(name = "horas", nullable = false)
    @Expose
    private Double horas;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Alumno> registroCurso = new ArrayList<>();

    public List<Alumno> getAlumnos() {
        return this.registroCurso;
    }

    public List<Alumno> getRegistroCurso() {
        return registroCurso;
    }

    public void setRegistroCurso(List<Alumno> registroCurso) {
        this.registroCurso = registroCurso;
    }

    @ManyToMany
    @JoinTable(
            name = "cursos_asignaturas",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id"))
    private List<Asignatura> asignaturas = new ArrayList<>();

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Curso() {
    }

    public Curso(Long id, String nombre, String tipo, Double horas) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.horas = horas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", horas=" + horas +
                '}';
    }
}
