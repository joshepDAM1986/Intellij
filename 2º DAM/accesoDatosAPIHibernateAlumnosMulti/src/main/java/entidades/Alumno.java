package entidades;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private long id;

    @Column(name = "dni", length = 100, unique = true)
    @Expose
    private String dni;

    @Column(name = "nombre", length = 150, nullable = false)
    @Expose
    private String nombre;

    @Column(name = "email", length = 100, nullable = false)
    @Expose
    private String email;

    @Column(name = "imagen_url")
    @Expose
    private String imagen_url;

    @Column(name = "edad", nullable = false)
    @Expose
    private Integer edad;

    @Column(name = "nota", nullable = false)
    @Expose
    private Double nota;

    @Column(name = "fecha_matriculacion", nullable = false)
    @Expose
    private LocalDate fecha_matriculacion;

    @Column(name = "categoria", nullable = false)
    @Expose
    private String categoria;

    //Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_key",
            foreignKey = @ForeignKey(name = "fk_alumno_curso"))
    private Curso curso;

    @ManyToMany
    @JoinTable(
            name = "profesor_alumno",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private List<Profesor> profesores = new ArrayList<>();

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    //Constructores
    public Alumno() {
    }

    public Alumno(long id, String dni, String nombre, String email, String imagen_url, Integer edad, Double nota, LocalDate fecha_matriculacion, String categoria) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.imagen_url = imagen_url;
        this.edad = edad;
        this.nota = nota;
        this.fecha_matriculacion = fecha_matriculacion;
        this.categoria = categoria;
    }

    //Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public LocalDate getFecha_matriculacion() {
        return fecha_matriculacion;
    }

    public void setFecha_matriculacion(LocalDate fecha_matriculacion) {
        this.fecha_matriculacion = fecha_matriculacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", imagen_url='" + imagen_url + '\'' +
                ", edad=" + edad +
                ", nota=" + nota +
                ", fecha_matriculacion=" + fecha_matriculacion +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}