package dao;

import entidades.Asignatura;

import java.util.List;

public interface AsignaturaDAOInterface {
    Asignatura crearAsignatura(Asignatura as);

    List<Asignatura> devolverTodosAsignaturas();

    List<Asignatura> devolverTodosAsignaturas(int pagina, int objetos_por_pagina);

    Long totalAsignaturas();

    Asignatura buscarPorId(long id);

    Asignatura updateByIdAsignatura(Asignatura asignatura);

    boolean deleteByIdAsignatura(long id);
}
