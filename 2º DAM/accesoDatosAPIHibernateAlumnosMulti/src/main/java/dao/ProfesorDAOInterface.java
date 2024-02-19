package dao;

import entidades.Profesor;

public interface ProfesorDAOInterface {
    Profesor crearProfesor(Profesor p);

    Profesor buscarPorId(Long id);
}
