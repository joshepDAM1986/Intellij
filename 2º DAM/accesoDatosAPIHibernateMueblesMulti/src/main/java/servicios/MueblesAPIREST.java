package servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.*;
import dto.MuebleDTO;
import entidades.Cliente;
import entidades.Mueble;
import entidades.Proveedor;
import spark.Spark;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MueblesAPIREST {
    private MuebleDAOInterface dao_mueble;
    private ProveedorDAOInterface dao_prov;
    private ClienteDAOInterface dao_cli;
    private AsociacionesDAOInterface dao_asoc;
    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public MueblesAPIREST(MuebleDAOInterface implementacion_mueble,ProveedorDAOInterface implementacion_prov,ClienteDAOInterface implementacion_cli,AsociacionesDAOInterface implementacion_asoc) {
        Spark.port(8080);
        dao_mueble = implementacion_mueble;
        dao_prov = implementacion_prov;
        dao_cli = implementacion_cli;
        dao_asoc = implementacion_asoc;

        //...

        // Endpoint para obtener todos los muebles
        Spark.get("/muebles", (request, response) -> {
            List<Mueble> muebles = dao_mueble.devolverTodos();
            System.out.println(muebles);
            response.type("application/json");
            return gson.toJson(muebles);
        });

        //En caso de intentar un endpoint incorrecto
        Spark.notFound((request, response) -> {
            response.type("application/json");
            return "{\"error\": \"Ruta no encontrada\",\"hint1\": \"/muebles\"," +
                    "\"hint2\": \"/muebles/paginado/:pagina/:tam_pagina\",\"hint3\": \"/muebles/id/:id\"}";
        });


        Spark.get("/muebles/paginado/:pagina/:tam_pagina", (request, response) -> {

            Integer pagina = Integer.parseInt(request.params(":pagina"));
            Integer tamaño_pagina = Integer.parseInt(request.params(":tam_pagina"));

            List<Mueble> muebles = dao_mueble.devolverTodos(pagina, tamaño_pagina);

            Long totalElementos = dao_mueble.totalMuebles(); // Obtener el total de muebles


            RespuestaPaginacion paginaResultado = new RespuestaPaginacion<>(muebles, totalElementos, pagina, tamaño_pagina);


            return gson.toJson(paginaResultado);

        });

        // Endpoint para obtener muebles más caros
        Spark.get("/muebles/mascaros", (request, response) -> {
            List<Mueble> masCaros = dao_mueble.devolverMasCaros();
            System.out.println(masCaros);
            return gson.toJson(masCaros);
        });

        // Endpoint para obtener todas las imágenes de muebles
        Spark.get("/muebles/imagenes", (request, response) -> {
            List<String> imagenes = dao_mueble.devolverTodasImages();
            return gson.toJson(imagenes);
        });

        // Endpoint para obtener un resumen con solo el nombre el precio y la URL
        Spark.get("/muebles/resumenobjetos", (request, response) -> {
            //List<Map> resumen = dao.devolverNombreImagenes();
            List<MuebleDTO> resumen = dao_mueble.devolverNombreImagenes();
            return gson.toJson(resumen);
        });


        // Endpoint para obtener un mueble por su ID
        Spark.get("/muebles/id/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            Mueble mueble = dao_mueble.buscarPorId(id);
            if (mueble != null) {
                return gson.toJson(mueble);
            } else {
                response.status(404);
                return "Mueble no encontrado";
            }
        });


        // Endpoint para obtener el total de muebles
        Spark.get("/muebles/total", (request, response) -> {
            Long total = dao_mueble.totalMuebles();
            return total.toString();
        });

        // Endpoint para calcular la media de precios de los muebles
        Spark.get("/muebles/mediaprecios", (request, response) -> {
            Double media = dao_mueble.mediaPrecios();
            return media.toString();
        });

        // Endpoint para calcular la media de precios de los muebles de una marca
        Spark.get("/muebles/mediaprecios/:marca", (request, response) -> {
            String marca = request.params(":marca");
            Double media = dao_mueble.mediaPreciosMarca(marca);
            return media.toString();
        });

        // Endpoint para buscar muebles por nombre (similar a LIKE)
        Spark.get("/muebles/buscar/:nombre", (request, response) -> {
            String nombre = request.params(":nombre");
            List<Mueble> muebles = dao_mueble.buscarPorNombreLike(nombre);
            return gson.toJson(muebles);
        });

        // Endpoint para buscar muebles entre precios mínimos y máximos
        Spark.get("/muebles/buscar/:min/:max", (request, response) -> {
            Double min = Double.parseDouble(request.params(":min"));
            Double max = Double.parseDouble(request.params(":max"));
            List<Mueble> muebles = dao_mueble.buscarEntrePrecios(min, max);
            return gson.toJson(muebles);
        });

        // Endpoint para buscar muebles entre precios mínimos y máximos de una marca
        Spark.get("/muebles/buscar/:min/:max/:marca", (request, response) -> {
            Double min = Double.parseDouble(request.params(":min"));
            Double max = Double.parseDouble(request.params(":max"));
            String marca = request.params(":marca");
            List<Mueble> muebles = dao_mueble.buscarEntrePreciosMarca(min, max, marca);
            return gson.toJson(muebles);
        });

        // Endpoint para buscar muebles entre precios mínimos y máximos de varias marcas
        Spark.get("/muebles/buscarvarias/:min/:max/:listamarcas", (request, response) -> {
            Double min = Double.parseDouble(request.params(":min"));
            Double max = Double.parseDouble(request.params(":max"));
            String marcasParam = request.params(":listamarcas");

            List<String> marcas = Arrays.asList(marcasParam.split(","));
            System.out.println(marcas);

            List<Mueble> muebles = dao_mueble.buscarEntrePreciosMarcas(min, max, marcas);
            return gson.toJson(muebles);
        });

        //CREAR UN MUEBLE CON TODOS LOS DATOS
        Spark.post("/muebles", (request, response) -> {
            String body = request.body();
            Mueble nuevoMueble = gson.fromJson(body, Mueble.class);

            Mueble creado = dao_mueble.create(nuevoMueble);
            return gson.toJson(creado);
        });

        // Endpoint para actualizar un mueble por su ID
        Spark.put("/muebles/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            String body = request.body();
            Mueble muebleActualizado = gson.fromJson(body, Mueble.class);
            muebleActualizado.setId(id);
            Mueble actualizado = dao_mueble.update(muebleActualizado);
            if (actualizado != null) {
                return gson.toJson(actualizado);
            } else {
                response.status(404);
                return "Mueble no encontrado";
            }
        });

        // Endpoint para eliminar un mueble por su ID
        Spark.delete("/muebles/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            boolean eliminado = dao_mueble.deleteById(id);
            if (eliminado) {
                return "Mueble eliminado correctamente";
            } else {
                response.status(404);
                return "Mueble no encontrado";
            }
        });

        //----------------------------END POINT DE RELACIONES------------------------------------------

        // Endpoint localizador de excepciones
        Spark.exception(Exception.class, (e, req, res) -> {
            e.printStackTrace(); // Imprime la excepción en la consola
            res.status(500); // Establece el código de estado HTTP 500
            res.body("Excepcion en tu codigo"); // Mensaje de error para el cliente
        });

        // Endpoint obtener el proveedor de un mueble
        Spark.get("/muebles/proveedor/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            Mueble m= dao_mueble.buscarPorId(id);
            Proveedor p = dao_asoc.obtenerProvedorMueble(m);
            response.type("application/json");
            return gson.toJson(p);
        });

        // Endpoint obtener los muebles de un proveedor
        Spark.get("/proveedor/muebles/:id_prov", (request, response) -> {
            Long id = Long.parseLong(request.params(":id_prov"));
            Proveedor p= dao_prov.buscarPorId(id);
            List<Mueble> m = dao_asoc.mueblesProveedor(p);
            response.type("application/json");
            return gson.toJson(m);
        });

        // Endpoint de proveedor y mueble
        Spark.post("/muebles/proveedor/:idprov/:idmu", (request, response) -> {
            Long idmu = Long.parseLong(request.params(":idmu"));
            Long idprov = Long.parseLong(request.params(":idprov"));
            Mueble m= dao_mueble.buscarPorId(idmu);
            Proveedor p= dao_prov.buscarPorId(idprov);
            response.type("application/json");
            return gson.toJson(dao_asoc.asignarProveedor(m,p));
        });

        // Enpoint obtener muebles de clientes
        Spark.get("/muebles/clientes/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            Mueble m= dao_mueble.buscarPorId(id);
            List<Cliente> c = dao_asoc.clientesConMueble(m);
            response.type("application/json");
            return gson.toJson(c);
        });

        // Enpoint obtener clientes de muebles
        Spark.get("/clientes/muebles/:id_cli", (request, response) -> {
            Long id = Long.parseLong(request.params(":id_cli"));
            Cliente c= dao_cli.buscarPorId(id);
            List<Mueble> m = dao_asoc.mueblesComprados(c);
            response.type("application/json");
            return gson.toJson(m);
        });

        // Endpoint de cliente y mueble
        Spark.post("/muebles/clientes/:idcli/:idmu", (request, response) -> {
            Long idmu = Long.parseLong(request.params(":idmu"));
            Long idcli = Long.parseLong(request.params(":idcli"));
            Mueble m= dao_mueble.buscarPorId(idmu);
            Cliente c= dao_cli.buscarPorId(idcli);
            response.type("application/json");
            return gson.toJson(dao_asoc.comprarMueble(m,c));
        });
    }
}
