package dao;

import dto.AlumnoDTO;
import entidades.Alumno;
import java.util.List;

public interface AlumnoDAOInterface {
    List<Alumno> devolverTodos();

    List<Alumno> buscarByNombreLike(String nombre);

    Alumno create(Alumno alumno);

    Alumno buscarById(long id);
    List<AlumnoDTO> buscarByCategoria(String categoria);

    List<AlumnoDTO> buscarByListaCategoria(List<String> categorias);

    Double notaMedia();

    Alumno updateById(Alumno alumno);

    boolean deleteById(long id);

    List<Alumno> devolverTodos(int página, int tamaño);

    Long totalAlumnos();

}
