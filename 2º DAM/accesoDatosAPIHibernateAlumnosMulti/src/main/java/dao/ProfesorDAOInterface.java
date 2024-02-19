package dao;

import entidades.Curso;
import entidades.Profesor;

import java.util.List;

public interface ProfesorDAOInterface {
    Profesor crearProfesor(Profesor p);

    List<Profesor> devolverTodosProfesores();

    List<Profesor> devolverTodosProfesores(int pagina, int objetos_por_pagina);

    Long totalProfesores();

    Profesor buscarPorId(Long id);

    Profesor updateByIdProfesores(Profesor profesor);

    boolean deleteByIdProfesores(long id);
}
