package entidades;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "academias")
public class Academia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private long id;

    @Column(name="nombre", length = 150, nullable = false)
    @Expose
    private String nombre;

    @Column(name="direccion", length = 200, nullable = false)
    @Expose
    private String direccion;

    @Column(name="email", length = 100, nullable = false)
    @Expose
    private String email;

    @Column(name="telefono", nullable = false)
    @Expose
    private int telefono;

    @OneToMany(mappedBy = "academia", fetch = FetchType.LAZY)
    private List<Alumno> registroAcademia = new ArrayList<>();

    public List<Alumno> getRegistroAcademia() {
        return registroAcademia;
    }

    public void setRegistroAcademia(List<Alumno> registro) {
        this.registroAcademia = registroAcademia;

    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "academia_curso",
            joinColumns= @JoinColumn(name ="academia_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos=new ArrayList<>();

    public List<Curso> getCursos(){
        return cursos;
    }
    public void setCursos(List<Curso> cursos){
        this.cursos=cursos;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "academia_profesor",
            joinColumns= @JoinColumn(name ="academia_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private List<Profesor> profesores=new ArrayList<>();

    public List<Profesor> getProfesores(){
        return profesores;
    }
    public void setProfesores(List<Profesor> profesores){
        this.profesores=profesores;
    }

    public Academia() {
    }

    public Academia(long id, String nombre, String direccion, String email, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Academia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", registroAcademia=" + registroAcademia +
                '}';
    }
}
