package dao;

import entidades.Cliente;
import entidades.Mueble;

import java.util.List;

public interface ClienteDAOInterface {

    Cliente crearCliente(Cliente c);

    Cliente buscarPorId(Long id);


}
