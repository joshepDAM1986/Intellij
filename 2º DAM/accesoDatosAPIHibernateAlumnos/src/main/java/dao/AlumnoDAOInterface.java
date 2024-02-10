package dao;

import dto.AlumnoDTO;
import entidades.Alumno;
import java.util.List;

public interface AlumnoDAOInterface {
    List<Alumno> devolverTodos();

    List<Alumno> devolverTodos(int página, int tamaño);

    List<String> devolverImagenes();

    List<Alumno> mayoresEdad();

    Alumno buscarById(long id);

    List<Alumno> buscarByNombreLike(String nombre);
    List<AlumnoDTO> buscarByCategoria(String categoria);

    List<AlumnoDTO> buscarByListaCategoria(List<String> categorias);

    List<Alumno> buscarBetweenAnios(int min, int max);

    List<Alumno> buscarBetweenAniosCategorias(int min, int max, List<String> categorias);

    Double notaMedia();

    Double notaMediaCategoria(String categoria);

    Alumno create(Alumno alumno);

    Alumno updateById(Alumno alumno);

    boolean deleteById(long id);

    Long totalAlumnos();

}
