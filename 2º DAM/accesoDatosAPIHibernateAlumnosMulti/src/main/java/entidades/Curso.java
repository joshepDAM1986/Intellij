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

    @Column(name = "nivel", length = 50, nullable = false)
    @Expose
    private String nivel;

    @Column(name = "horas", nullable = false)
    @Expose
    private Double horas;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<Alumno> registroCurso = new ArrayList<>();

    @ManyToMany(mappedBy = "cursos")
    private List<Academia> academias = new ArrayList<>();

    public List<Academia> getAcademias() {
        return academias;
    }

    public void setAcademias(List<Academia> academias) {
        this.academias = academias;
    }

    public List<Alumno> getRegistroCurso() {
        return registroCurso;
    }

    public void setRegistroCurso(List<Alumno> registroCurso) {
        this.registroCurso = registroCurso;
    }

    public Curso() {
    }

    public Curso(Long id, String nombre, String nivel, Double horas) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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
                ", nivel='" + nivel + '\'' +
                ", horas=" + horas +
                '}';
    }
}
