package dao;

import entidades.Curso;

public interface CursoDAOInterface {

    Curso crearCurso(Curso c);

    Curso buscarPorId(Long id);
}
