package servicios;

import com.google.gson.Gson;
import dao.MuebleDAOInterface;
import dto.MuebleDTO;
import entidades.Mueble;
import spark.Spark;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MueblesAPIREST {
    private MuebleDAOInterface dao;
    private Gson gson = new Gson();

    public MueblesAPIREST(MuebleDAOInterface implementacion) {
        Spark.port(8080);
        dao = implementacion;
        //...

        // Endpoint para obtener todos los muebles
        Spark.get("/muebles", (request, response) -> {
            List<Mueble> muebles = dao.devolverTodos();
            response.type("application/json");
            return gson.toJson(muebles);
        });


// Endpoint para obtener un mueble por su ID
        Spark.get("/muebles/id/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            Mueble mueble = dao.buscarPorId(id);
            response.type("application/json");
            if (mueble != null) {
                return gson.toJson(mueble);
            } else {
                response.status(404);
                return "Mueble no encontrado";
            }
        });


        //==========================================================================================================

        // Endpoint para obtener muebles más caros
        Spark.get("/muebles/mascaros", (request, response) -> {
            List<Mueble> masCaros = dao.devolverMasCaros();
            response.type("application/json");
            return gson.toJson(masCaros);
        });

        // Endpoint para obtener todas las imágenes de muebles
        Spark.get("/muebles/imagenes", (request, response) -> {
            List<String> imagenes = dao.devolverTodasImages();
            response.type("application/json");
            return gson.toJson(imagenes);
        });

        // Endpoint para obtener un resumen con solo el nombre el precio y la URL
        Spark.get("/muebles/resumenobjetos", (request, response) -> {
            //List<Map> resumen = dao.devolverNombreImagenes();
            List<MuebleDTO> resumen = dao.devolverNombreImagenes();
            response.type("application/json");
            return gson.toJson(resumen);
        });


        // Endpoint para obtener el total de muebles
        Spark.get("/muebles/total", (request, response) -> {
            Long total = dao.totalMuebles();
            response.type("application/json");
            return total.toString();
        });

        // Endpoint para calcular la media de precios de los muebles
        Spark.get("/muebles/mediaprecios", (request, response) -> {
            Double media = dao.mediaPrecios();
            response.type("application/json");
            return media.toString();
        });


        //=========================================================================================


        // Endpoint para calcular la media de precios de los muebles de una marca
        Spark.get("/muebles/mediaprecios/:marca", (request, response) -> {
            String marca = request.params(":marca");
            Double media = dao.mediaPreciosMarca(marca);
            response.type("application/json");
            return media.toString();
        });

        // Endpoint para buscar muebles por nombre (similar a LIKE)
        Spark.get("/muebles/buscar/:nombre", (request, response) -> {
            String nombre = request.params(":nombre");
            List<Mueble> muebles = dao.buscarPorNombreLike(nombre);
            response.type("application/json");
            return gson.toJson(muebles);
        });

        // Endpoint para buscar muebles entre precios mínimos y máximos
        Spark.get("/muebles/buscar/:min/:max", (request, response) -> {
            Double min = Double.parseDouble(request.params(":min"));
            Double max = Double.parseDouble(request.params(":max"));
            List<Mueble> muebles = dao.buscarEntrePrecios(min, max);
            response.type("application/json");
            return gson.toJson(muebles);
        });

        // Endpoint para buscar muebles entre precios mínimos y máximos de una marca
        Spark.get("/muebles/buscar/:min/:max/:marca", (request, response) -> {
            Double min = Double.parseDouble(request.params(":min"));
            Double max = Double.parseDouble(request.params(":max"));
            String marca = request.params(":marca");
            List<Mueble> muebles = dao.buscarEntrePreciosMarca(min, max, marca);
            response.type("application/json");
            return gson.toJson(muebles);
        });

        // Endpoint para buscar muebles entre precios mínimos y máximos de varias marcas
        Spark.get("/muebles/buscarvarias/:min/:max/:listamarcas", (request, response) -> {
            Double min = Double.parseDouble(request.params(":min"));
            Double max = Double.parseDouble(request.params(":max"));
            String marcasParam = request.params(":listamarcas");

            List<String> marcas = Arrays.asList(marcasParam.split(","));
            List<Mueble> muebles = dao.buscarEntrePreciosMarcas(min, max, marcas);

            response.type("application/json");

            return gson.toJson(muebles);
        });

        //CREAR UN MUEBLE CON TODOS LOS DATOS
        Spark.post("/muebles", (request, response) -> {
            String body = request.body();
            Mueble nuevoMueble = gson.fromJson(body, Mueble.class);

            Mueble creado = dao.create(nuevoMueble);
            response.type("application/json");
            return gson.toJson(creado);
        });

        // Endpoint para actualizar un mueble por su ID
        Spark.put("/muebles/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            String body = request.body();
            Mueble muebleActualizado = gson.fromJson(body, Mueble.class);
            muebleActualizado.setId(id);
            Mueble actualizado = dao.update(muebleActualizado);
            response.type("application/json");
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
            boolean eliminado = dao.deleteById(id);
            response.type("application/json");
            if (eliminado) {
                return "Mueble eliminado correctamente";
            } else {
                response.status(404);
                return "Mueble no encontrado";
            }
        });

        //DEVOLVER DATOS DE MANERA PAGINADA DE TODOS LOS MUEBLES
        Spark.get("/muebles/paginado/:pagina/:tam_pagina", (request, response) -> {
            Integer pagina = Integer.parseInt(request.params("pagina"));
            Integer tamaño_pagina = Integer.parseInt(request.params("tam_pagina"));

            List<Mueble> muebles = dao.devolverTodos(pagina, tamaño_pagina);
            Long totalElementos = dao.totalMuebles(); // Obtener el total de muebles

            RespuestaPaginacion<Mueble> paginaResultado = new RespuestaPaginacion<>(muebles, totalElementos, pagina, tamaño_pagina);

            return gson.toJson(paginaResultado);
        });




        //En caso de intentar un endpoint incorrecto
        Spark.notFound((request, response) -> {
            response.type("application/json");
            return "{\"error\": \"Ruta no encontrada\",\"hint1\": \"/muebles\"," +
                    "\"hint2\": \"/muebles/paginado/:pagina/:tam_pagina\",\"hint3\": \"/muebles/id/:id\"}";
        });
    }
}
