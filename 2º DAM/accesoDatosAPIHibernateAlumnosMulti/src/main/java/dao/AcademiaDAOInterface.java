package dao;

import entidades.Academia;
import entidades.Curso;

import java.util.List;

public interface AcademiaDAOInterface {
    Academia crearAcademia(Academia ac);

    List<Academia> devolverTodosAcademias();

    List<Academia> devolverTodosAcademias(int pagina, int objetos_por_pagina);

    Long totalAcademias();

    Academia buscarPorId(Long id);

    Academia updateByIdAcademias(Academia academia);

    boolean deleteByIdAcademias(long id);
}
