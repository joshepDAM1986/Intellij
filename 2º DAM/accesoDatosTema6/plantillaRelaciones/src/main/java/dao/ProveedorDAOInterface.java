package dao;

import entidades.Mueble;
import entidades.Proveedor;

import java.util.List;

public interface ProveedorDAOInterface {
    Proveedor crearProveedor(Proveedor p);

    Proveedor buscarPorID(Long id);

}