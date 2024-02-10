package entidades;

import com.google.gson.annotations.Expose;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Cursos")
public class Curso implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false)
    @Expose
    private String nombre;

    @Column(name = "horas", nullable = false)
    @Expose
    private Double horas;

    @OneToMany(mappedBy = "curs", fetch = FetchType.LAZY)
    private List<Alumno> registro=new ArrayList<>();

    public List<Alumno> getRegistro(){return registro;}

    public void setRegistro(List<Alumno> registro){this.registro= registro;}

    public Curso() {
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
                ", horas=" + horas +
                '}';
    }
}
