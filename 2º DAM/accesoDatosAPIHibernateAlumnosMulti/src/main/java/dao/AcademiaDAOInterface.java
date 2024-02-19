package dao;

import entidades.Academia;
import entidades.Curso;

public interface AcademiaDAOInterface {
    Academia crearAcademia(Academia ac);

    Academia buscarPorId(Long id);
}
