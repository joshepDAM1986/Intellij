package dao;

import entidades.Academia;
import entidades.Alumno;
import entidades.Curso;
import entidades.Profesor;

import java.util.List;

public interface AsociacionesDAOInterface {
    boolean asignarCurso(Alumno a, Curso c);

    Curso obtenercursoAlumno(Alumno m);

    List<Alumno> alumnosCurso(Curso p);

    List<Profesor> alumnosConProfesor(Alumno m);

    List<Alumno> profesoresConAlumnos(Profesor p);

    boolean asignarProfesor(Alumno a, Profesor p);

    Academia obtenerAcademiaAlumno(Alumno a);

    List<Alumno> alumnosAcademia(Academia ac);

    boolean asignarAcademiaAlumno(Alumno a, Academia ac);

    List<Academia> cursosConAcademias(Curso c);

    List<Curso> academiasConCursos(Academia ac);

    boolean asignarAcademiaCurso(Curso c, Academia ac);

    List<Academia> profesoresConAcademias(Profesor p);

    List<Profesor> academiasConProfesores(Academia ac);

    boolean asignarAcademiaProfesores(Profesor p, Academia ac);
}
