package dao;

import entidades.Curso;

import java.util.List;

public interface CursoDAOInterface {

    Curso crearCurso(Curso c);

    List<Curso> devolverTodosCursos();

    List<Curso> devolverTodosCursos(int pagina, int objetos_por_pagina);

    Long totalCursos();

    Curso buscarPorId(Long id);

    Curso updateByIdCurso(Curso curso);

    boolean deleteByIdCurso(long id);
}
