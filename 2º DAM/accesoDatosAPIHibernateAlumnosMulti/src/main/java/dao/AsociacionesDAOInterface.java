package dao;

import entidades.Alumno;
import entidades.Asignatura;
import entidades.Curso;
import entidades.Profesor;

import java.util.List;

public interface AsociacionesDAOInterface {


    Curso obtenercursoAlumno(Alumno m);

    List<Alumno> obtenerAlumnosCurso(Curso p);

    boolean asignarCurso(Alumno a, Curso c);

    List<Profesor> alumnosConProfesor(Alumno m);

    List<Alumno> profesoresConAlumnos(Profesor p);

    boolean asignarProfesor(Alumno a, Profesor p);

    List<Asignatura> cursosAsignaturas(Curso c);

    List<Curso> asignaturasCursos(Asignatura as);

    boolean asignarAsignatura(Curso c, Asignatura as);
}
