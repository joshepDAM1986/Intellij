package entidades;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignaturas")
public class Asignatura implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Expose
        private long id;

        @Column(name = "nombre", length = 150, nullable = false)
        @Expose
        private String nombre;

        @Column(name = "tipo", length = 150, nullable = false)
        @Expose
        private String tipo;

        @Column(name = "horas_semanales")
        @Expose
        private int horas_semanales;

        @ManyToMany(mappedBy = "asignaturas")
        private List<Curso> cursos = new ArrayList<>();

        public List<Curso> getCursos() {
                return cursos;
        }

        public void setCursos(List<Curso> cursos) {
                this.cursos = cursos;
        }

        public Asignatura() {
        }

        public Asignatura(long id, String nombre, int horas_semanales, List<Curso> cursos) {
                this.id = id;
                this.nombre = nombre;
                this.horas_semanales = horas_semanales;
                this.cursos = cursos;
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

        public int getHoras_semanales() {
                return horas_semanales;
        }

        public void setHoras_semanales(int horas_semanales) {
                this.horas_semanales = horas_semanales;
        }

        @Override
        public String toString() {
                return "Asignatura{" +
                        "id=" + id +
                        ", nombre='" + nombre + '\'' +
                        ", horas_semanales=" + horas_semanales +
                        ", cursos=" + cursos +
                        '}';
        }
}
