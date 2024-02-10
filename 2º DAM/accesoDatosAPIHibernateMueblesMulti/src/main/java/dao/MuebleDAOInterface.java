package dao;

import dto.MuebleDTO;
import entidades.Cliente;
import entidades.Mueble;
import entidades.Proveedor;

import java.util.List;
import java.util.Map;

public interface MuebleDAOInterface {

    List<Mueble> devolverTodos();

    List<Mueble> devolverTodos(int pagina,int tamaño);

    List<Mueble> devolverMasCaros();

    List<String> devolverTodasImages();

    //List<Map> devolverNombreImagenes();
    List<MuebleDTO> devolverNombreImagenes();

    Long totalMuebles();

    Mueble buscarPorId(Long id);

    Double mediaPrecios();

    Double mediaPreciosMarca(String marca);

    List<Mueble> buscarPorNombreLike(String nombre);

    List<Mueble> buscarEntrePrecios(Double min, Double max);

    List<Mueble> buscarEntrePreciosMarca(Double min, Double max,String marca);

    List<Mueble> buscarEntrePreciosMarcas(Double min, Double max,List<String> marcas);

    Mueble create(Mueble mueble);

    Mueble update(Mueble mueble);

    boolean deleteById(Long id);

    boolean deleteAll();


}
