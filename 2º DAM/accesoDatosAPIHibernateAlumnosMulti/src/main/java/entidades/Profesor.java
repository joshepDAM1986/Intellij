package entidades;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;

    @Column(name = "nombre", length = 150, nullable = false)
    @Expose
    private String nombre;

    @Column(name = "email", length = 100, nullable = false)
    @Expose
    private String email;

    @ManyToMany(mappedBy = "profesores")
    private List<Alumno> alumnos = new ArrayList<>();

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Profesor() {
    }

    public Profesor(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}