package entidades;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="alumnos")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dni", length = 100, unique = true)
    private String dni;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "imagen_url")
    private String imagen_url;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "nota", nullable = false)
    private Double nota;

    @Column(name = "fecha_matriculacion", nullable = false)
    private LocalDate fecha_matriculacion;

    @Column(name="categoria", nullable = false)
    private String categoria;

    public Alumno() {
    }

    public Alumno(long id, String dni, String nombre, String apellidos, String imagen_url, Integer edad, Double nota, LocalDate fecha_matriculacion, String categoria) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.imagen_url = imagen_url;
        this.edad = edad;
        this.nota = nota;
        this.fecha_matriculacion = fecha_matriculacion;
        this.categoria = categoria;
    }

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", imagen_url='" + imagen_url + '\'' +
                ", edad=" + edad +
                ", nota=" + nota +
                ", fecha_matriculacion=" + fecha_matriculacion +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}