package servicios;

import com.appslandia.common.gson.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.AlumnoDAOInterface;
import dto.AlumnoDTO;
import entidades.Alumno;
import spark.Spark;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AlumnoAPIREST {
    private AlumnoDAOInterface dao;

    private Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    public AlumnoAPIREST(AlumnoDAOInterface implementacion) {
        Spark.port(8080);
        dao = implementacion;


        // Mostrar todos
        Spark.get("/alumnos/mostrartodos", (request, response) -> {
            response.type("application/json");

            List<Alumno> alumnos = dao.devolverTodos();
            return gson.toJson(alumnos);
        });

        // Mostrar todos paginado
        Spark.get("/alumnos/mostrartodos/paginado/:pagina/:tam_pagina", (request, response) -> {
            response.type("application/json");

            Integer pagina = Integer.parseInt(request.params(":pagina"));
            Integer tamaño_pagina = Integer.parseInt(request.params(":tam_pagina"));

            List<Alumno> alumnos = dao.devolverTodos(pagina, tamaño_pagina);
            long totalElementos = dao.totalAlumnos();

            RespuestaPaginacion<Alumno> paginaResultado = new RespuestaPaginacion<>(alumnos, totalElementos, pagina, tamaño_pagina);

            return gson.toJson(paginaResultado);
        });

        // Añadir
        Spark.post("/alumnos/aniadiralumno", (request, response) -> {
            response.type("application/json");

            String body = request.body();
            Alumno nuevoAlumno = gson.fromJson(body, Alumno.class);
            Alumno creado = dao.create(nuevoAlumno);
            return gson.toJson(creado);
        });

        // Buscar por id
        Spark.get("/alumnos/buscarxid/:id", (request, response) -> {
            response.type("application/json");
            long id = Long.parseLong(request.params(":id"));
            System.out.println("ID del alumno a buscar: " + id);
            Alumno alumno = dao.buscarById(id);
            if (alumno != null) {
                return gson.toJson(alumno);
            } else {
                response.status(404);
                return "Alumno no encontrado";
            }
        });

        //Buscar por nombre like
        Spark.get("/alumnos/buscarxnombre/:nombre", (request, response) -> {
            response.type("application/json");

            String nombre = request.params(":nombre");
            List<Alumno> alumnos = dao.buscarByNombreLike(nombre);
            return gson.toJson(alumnos);
        });

        //Buscar en categoria
        Spark.get("/alumnos/buscarxcategoria/:categoria", (request, response) -> {
            response.type("application/json");

            String categoria = request.params(":categoria");
            List<AlumnoDTO> alumnos = dao.buscarByCategoria(categoria);
            return gson.toJson(alumnos);
        });

        // Buscar en lista categorias
        Spark.get("/alumnos/buscarxlistacategorias/:categorias", (request, response) -> {
            response.type("application/json");

            // Obtén las categorías de la URL y conviértelas en una lista
            String categoriasParam = request.params(":categorias");
            List<String> categorias = Arrays.asList(categoriasParam.split(","));

            // Llama al método con la lista de categorías
            List<AlumnoDTO> alumnos = dao.buscarByListaCategoria(categorias);
            return gson.toJson(alumnos);
        });

        // Calcular nota media
        Spark.get("/alumnos/mostrarmediatotal", (request, response) -> {
            response.type("application/json");

            Double media = dao.notaMedia();
            return "Nota media total: "+media.toString();
        });

        // Modificar por id
        Spark.put("/alumnos/modificarxid/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            String body = request.body();
            Alumno alumnoActualizado = gson.fromJson(body, Alumno.class);
            alumnoActualizado.setId(id);
            Alumno actualizado = dao.updateById(alumnoActualizado);
            if (actualizado != null) {
                return gson.toJson(actualizado);
            } else {
                response.status(404);
                return "Alumno no encontrado";
            }
        });

        // Borrar por id
        Spark.delete("/alumnos/borrarxid/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            boolean eliminado = dao.deleteById(id);
            if (eliminado) {
                return "Alumno eliminado correctamente";
            } else {
                response.status(404);
                return "Alumno no encontrado";
            }
        });

        // Error de ruta
        Spark.notFound((request, response) -> {
            response.type("application/json");

            response.type("application/json");
            return "{\"error\": \"Ruta no encontrada\",\"hint1\": \"/alumnos\"," +
                    "\"hint2\": \"/alumnos/paginado/:pagina/:tam_pagina\",\"hint3\": \"/alumnos/id/:id\"}";
        });

    }
}


