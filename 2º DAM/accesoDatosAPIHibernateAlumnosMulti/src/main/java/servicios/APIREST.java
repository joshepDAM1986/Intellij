package servicios;

import com.appslandia.common.gson.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.*;
import dto.AlumnoDTO;
import entidades.Academia;
import entidades.Alumno;
import entidades.Curso;
import entidades.Profesor;
import spark.Spark;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class APIREST {
    private AlumnoDAOInterface dao;
    private CursoDAOInterface dao_curs;
    private ProfesorDAOInterface dao_prof;
    private AcademiaDAOInterface dao_acad;
    private AsociacionesDAOInterface dao_asoc;

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    public APIREST(AlumnoDAOInterface implementacion, CursoDAOInterface implementacion_curs, ProfesorDAOInterface implementacion_prof, AcademiaDAOInterface implementacion_acad, AsociacionesDAOInterface implementacion_asoc) {
        Spark.port(8080);
        dao = implementacion;
        dao_curs = implementacion_curs;
        dao_prof = implementacion_prof;
        dao_acad = implementacion_acad;
        dao_asoc = implementacion_asoc;

        //------------------------------------------END POINT DE ALUMNO------------------------------------------//

        // Mostrar todos
        Spark.get("/alumnos/todos", (request, response) -> {
            response.type("application/json");

            List<Alumno> alumnos = dao.devolverTodos();
            return gson.toJson(alumnos);
        });

        // Mostrar todos paginado
        Spark.get("/alumnos/todos/paginado/:pagina/:tam_pagina", (request, response) -> {
            response.type("application/json");

            Integer pagina = Integer.parseInt(request.params(":pagina"));
            Integer tamaño_pagina = Integer.parseInt(request.params(":tam_pagina"));

            List<Alumno> alumnos = dao.devolverTodos(pagina, tamaño_pagina);
            long totalElementos = dao.totalAlumnos();

            RespuestaPaginacion<Alumno> paginaResultado = new RespuestaPaginacion<>(alumnos, totalElementos, pagina, tamaño_pagina);

            return gson.toJson(paginaResultado);
        });

        // Mostrar solo las imágenes
        Spark.get("/alumnos/imagenes", (request, response) -> {
            response.type("application/json");
            List<String> imagenes = dao.devolverImagenes();
            return gson.toJson(imagenes);
        });

        // Mostrar mayores de edad
        Spark.get("/alumnos/mayores", (request, response) -> {
            response.type("application/json");
            List<Alumno> masCaros = dao.mayoresEdad();
            System.out.println(masCaros);
            return gson.toJson(masCaros);
        });

        // Buscar por id
        Spark.get("/alumnos/buscarid/:id", (request, response) -> {
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

        // Buscar por nombre like
        Spark.get("/alumnos/buscarnombre/:nombre", (request, response) -> {
            response.type("application/json");

            String nombre = request.params(":nombre");
            List<Alumno> alumnos = dao.buscarByNombreLike(nombre);
            return gson.toJson(alumnos);
        });

        // Buscar en categoria
        Spark.get("/alumnos/buscarcategoria/:categoria", (request, response) -> {
            response.type("application/json");

            String categoria = request.params(":categoria");
            List<AlumnoDTO> alumnos = dao.buscarByCategoria(categoria);
            return gson.toJson(alumnos);
        });

        // Buscar en lista categorias
        Spark.get("/alumnos/buscarlistacategorias/:categorias", (request, response) -> {
            response.type("application/json");
            String categoriasParam = request.params(":categorias");
            List<String> categorias = Arrays.asList(categoriasParam.split(","));
            List<AlumnoDTO> alumnos = dao.buscarByListaCategoria(categorias);
            return gson.toJson(alumnos);
        });

        // Buscar entre años
        Spark.get("/alumnos/buscarentreanios/:min/:max", (request, response) -> {
            response.type("application/json");
            int min = Integer.parseInt(request.params(":min"));
            int max = Integer.parseInt(request.params(":max"));
            List<Alumno> alumnos= dao.buscarBetweenAnios(min, max);
            return gson.toJson(alumnos);
        });

        // Buscar entre años en categoria
        Spark.get("/alumnos/buscarentreanioslistacategorias/:min/:max/:categorias", (request, response) -> {
            response.type("application/json");
            int min = Integer.parseInt(request.params(":min"));
            int max = Integer.parseInt(request.params(":max"));
            String categoriasParam = request.params(":categorias");
            List<String> categorias = Arrays.asList(categoriasParam.split(","));
            List<Alumno> alumnos= dao.buscarBetweenAniosCategorias(min, max, categorias);
            return gson.toJson(alumnos);
        });

        // Calcular nota media
        Spark.get("/alumnos/mediatotal", (request, response) -> {
            response.type("application/json");

            Double media = dao.notaMedia();
            return "Nota media total: "+media.toString();
        });

        // Calcular nota media en categoria
        Spark.get("/alumnos/mediatotalcategoria/:categoria", (request, response) -> {
            String categoria = request.params(":categoria");
            Double media = dao.notaMediaCategoria(categoria);
            return "Nota media total de "+ categoria +":" +media.toString();
        });

        // Crear
        Spark.post("/alumnos/crear", (request, response) -> {
            response.type("application/json");

            String body = request.body();
            Alumno nuevoAlumno = gson.fromJson(body, Alumno.class);
            Alumno creado = dao.create(nuevoAlumno);
            return gson.toJson(creado);
        });

        // Modificar
        Spark.put("/alumnos/modificar/:id", (request, response) -> {
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

        // Borrar
        Spark.delete("/alumnos/borrar/:id", (request, response) -> {
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

        //------------------------------------------END POINT DE CURSO------------------------------------------//

        // Mostrar todos
        Spark.get("/cursos/todos", (request, response) -> {
            response.type("application/json");

            List<Curso> cursos = dao_curs.devolverTodosCursos();
            return gson.toJson(cursos);
        });

        // Mostrar todos paginado
        Spark.get("/cursos/todos/paginado/:pagina/:tam_pagina", (request, response) -> {
            response.type("application/json");

            Integer pagina = Integer.parseInt(request.params(":pagina"));
            Integer tamaño_pagina = Integer.parseInt(request.params(":tam_pagina"));

            List<Curso> cursos = dao_curs.devolverTodosCursos(pagina, tamaño_pagina);
            long totalElementos = dao_curs.totalCursos();

            RespuestaPaginacion<Curso> paginaResultado = new RespuestaPaginacion<>(cursos, totalElementos, pagina, tamaño_pagina);

            return gson.toJson(paginaResultado);
        });

        // Crear
        Spark.post("/cursos/crear", (request, response) -> {
            response.type("application/json");

            String body = request.body();
            Curso nuevoCurso = gson.fromJson(body, Curso.class);
            Curso creado = dao_curs.crearCurso(nuevoCurso);
            return gson.toJson(creado);
        });

        // Modificar
        Spark.put("/cursos/modificar/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            String body = request.body();
            Curso cursoActualizado = gson.fromJson(body, Curso.class);
            cursoActualizado.setId(id);
            Curso actualizado = dao_curs.updateByIdCurso(cursoActualizado);
            if (actualizado != null) {
                return gson.toJson(actualizado);
            } else {
                response.status(404);
                return "Curso no encontrado";
            }
        });

        // Borrar
        Spark.delete("/cursos/borrar/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            boolean eliminado = dao_curs.deleteByIdCurso(id);
            if (eliminado) {
                return "Curso eliminado correctamente";
            } else {
                response.status(404);
                return "Curso no encontrado";
            }
        });

        //------------------------------------------END POINT DE PROFESORES------------------------------------------//

        // Mostrar todos
        Spark.get("/profesores/todos", (request, response) -> {
            response.type("application/json");

            List<Profesor> profesores = dao_prof.devolverTodosProfesores();
            return gson.toJson(profesores);
        });

        // Mostrar todos paginado
        Spark.get("/profesores/todos/paginado/:pagina/:tam_pagina", (request, response) -> {
            response.type("application/json");

            Integer pagina = Integer.parseInt(request.params(":pagina"));
            Integer tamaño_pagina = Integer.parseInt(request.params(":tam_pagina"));

            List<Profesor> profesores = dao_prof.devolverTodosProfesores(pagina, tamaño_pagina);
            long totalElementos = dao_prof.totalProfesores();

            RespuestaPaginacion<Profesor> paginaResultado = new RespuestaPaginacion<>(profesores, totalElementos, pagina, tamaño_pagina);

            return gson.toJson(paginaResultado);
        });

        // Crear
        Spark.post("/profesores/crear", (request, response) -> {
            response.type("application/json");

            String body = request.body();
            Profesor nuevoProfesor = gson.fromJson(body, Profesor.class);
            Profesor creado = dao_prof.crearProfesor(nuevoProfesor);
            return gson.toJson(creado);
        });

        // Modificar
        Spark.put("/profesores/modificar/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            String body = request.body();
            Profesor profesorActualizado = gson.fromJson(body, Profesor.class);
            profesorActualizado.setId(id);
            Profesor actualizado = dao_prof.updateByIdProfesores(profesorActualizado);
            if (actualizado != null) {
                return gson.toJson(actualizado);
            } else {
                response.status(404);
                return "Profesor no encontrado";
            }
        });

        // Borrar
        Spark.delete("/profesores/borrar/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            boolean eliminado = dao_prof.deleteByIdProfesores(id);
            if (eliminado) {
                return "Profesor eliminado correctamente";
            } else {
                response.status(404);
                return "Profesor no encontrado";
            }
        });

        //------------------------------------------END POINT DE ACADEMIA------------------------------------------//

        // Mostrar todos
        Spark.get("/academias/todos", (request, response) -> {
            response.type("application/json");

            List<Academia> academias = dao_acad.devolverTodosAcademias();
            return gson.toJson(academias);
        });

        // Mostrar todos paginado
        Spark.get("/academias/todos/paginado/:pagina/:tam_pagina", (request, response) -> {
            response.type("application/json");

            Integer pagina = Integer.parseInt(request.params(":pagina"));
            Integer tamaño_pagina = Integer.parseInt(request.params(":tam_pagina"));

            List<Academia> academias = dao_acad.devolverTodosAcademias(pagina, tamaño_pagina);
            long totalElementos = dao_acad.totalAcademias();

            RespuestaPaginacion<Academia> paginaResultado = new RespuestaPaginacion<>(academias, totalElementos, pagina, tamaño_pagina);

            return gson.toJson(paginaResultado);
        });

        // Crear
        Spark.post("/academias/crear", (request, response) -> {
            response.type("application/json");

            String body = request.body();
            Academia nuevaAcademia = gson.fromJson(body, Academia.class);
            Academia creado = dao_acad.crearAcademia(nuevaAcademia);
            return gson.toJson(creado);
        });

        // Modificar
        Spark.put("/academias/modificar/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            String body = request.body();
            Academia academiaActualizada = gson.fromJson(body, Academia.class);
            academiaActualizada.setId(id);
            Academia actualizada = dao_acad.updateByIdAcademias(academiaActualizada);
            if (actualizada != null) {
                return gson.toJson(actualizada);
            } else {
                response.status(404);
                return "Academia no encontrada";
            }
        });

        // Borrar
        Spark.delete("/academias/borrar/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            boolean eliminada = dao_acad.deleteByIdAcademias(id);
            if (eliminada) {
                return "Academia eliminada correctamente";
            } else {
                response.status(404);
                return "academia no encontrada";
            }
        });

        //------------------------------------------END POINT DE RELACIONES------------------------------------------//

        // Entpoint localizador de excepciones
        Spark.exception(Exception.class, (exception, request, response) -> {
            response.type("application/json");
            exception.printStackTrace(); // Imprime la excepción en la consola
            response.status(500); // Establece el código de estado HTTP 500
            response.body("Excepcion en tu codigo"); // Mensaje de error para el cliente
        });

        // Entpoint obtener el curso de un alumno
        Spark.get("/alumnos/cursos/:idal", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Alumno a= dao.buscarById(idal);
            Curso c = dao_asoc.obtenercursoAlumno(a);
            response.type("application/json");
            if (c!=null) {
                return gson.toJson(c);
            }
            else{
                return "No existe ese curso";
            }
        });

        // Entpoint obtener los alumnos de un curso
        Spark.get("/cursos/alumnos/:idcurs", (request, response) -> {
            Long id = Long.parseLong(request.params(":idcurs"));
            Curso p= dao_curs.buscarPorId(id);
            List<Alumno> a = dao_asoc.alumnosCurso(p);
            response.type("application/json");
            if (a!=null) {
                return gson.toJson(a);
            }
            else{
                return "No existe ese alumno";
            }
        });

        // Entpoint Asignar curso a alumno
        Spark.post("/cursos/alumnos/:idcurs/:idal", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Long idcurs = Long.parseLong(request.params(":idcurs"));
            Alumno a= dao.buscarById(idal);
            Curso c= dao_curs.buscarPorId(idcurs);
            response.type("application/json");
            return gson.toJson(dao_asoc.asignarCurso(a,c));
        });

        // Entpoint obtener profesores de un alumno
        Spark.get("/alumnos/profesores/:idal", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Alumno a= dao.buscarById(idal);
            List<Profesor> p = dao_asoc.alumnosConProfesor(a);
            response.type("application/json");
            if (p!=null) {
                return gson.toJson(p);
            }
            else{
                return "No existe ese profesor";
            }
        });

        // Entpoint obtener alumnos de un profesor
        Spark.get("/profesores/alumnos/:idprof", (request, response) -> {
            Long id = Long.parseLong(request.params(":idprof"));
            Profesor p= dao_prof.buscarPorId(id);
            List<Alumno> a = dao_asoc.profesoresConAlumnos(p);
            response.type("application/json");
            if (a!=null) {
                return gson.toJson(a);
            }
            else{
                return "No existe ese alumno";
            }
        });

        // Entpoint Asignar profesor a alumno
        Spark.post("/alumnos/profesor/:idal/:idprof", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Long idprof = Long.parseLong(request.params(":idprof"));
            Alumno a= dao.buscarById(idal);
            Profesor p= dao_prof.buscarPorId(idprof);
            response.type("application/json");
            return gson.toJson(dao_asoc.asignarProfesor(a,p));
        });

        // Entpoint obtener la academia de un alumno
        Spark.get("/alumnos/academias/:idal", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Alumno a= dao.buscarById(idal);
            Academia ac = dao_asoc.obtenerAcademiaAlumno(a);
            response.type("application/json");
            if (ac!=null) {
                return gson.toJson(ac);
            }
            else{
                return "No existe esa academia";
            }
        });

        // Entpoint obtener los alumnos de una academia
        Spark.get("/academias/alumnos/:idac", (request, response) -> {
            Long idac = Long.parseLong(request.params(":idac"));
            Academia ac= dao_acad.buscarPorId(idac);
            List<Alumno> a = dao_asoc.alumnosAcademia(ac);
            response.type("application/json");
            if (a!=null) {
                return gson.toJson(a);
            }
            else{
                return "No existe ese alumno";
            }
        });

        // Entpoint Asignar academia a alumno
        Spark.post("/alumnos/academias/:idal/:idac", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Long idac = Long.parseLong(request.params(":idac"));
            Alumno a= dao.buscarById(idal);
            Academia ac= dao_acad.buscarPorId(idac);
            response.type("application/json");
            return gson.toJson(dao_asoc.asignarAcademiaAlumno(a,ac));
        });

        // Entoint obtener academias de un curso
        Spark.get("/cursos/academias/:idcur", (request, response) -> {
            Long idcur = Long.parseLong(request.params(":idcur"));
            Curso c= dao_curs.buscarPorId(idcur);
            List<Academia> ac = dao_asoc.cursosConAcademias(c);
            response.type("application/json");
            if (ac!=null) {
                return gson.toJson(ac);
            }
            else{
                return "No existe esa academia";
            }
        });

        // Entpoint obtener cursos de una academia
        Spark.get("/academias/cursos/:idac", (request, response) -> {
            Long idaca = Long.parseLong(request.params(":idac"));
            Academia ac= dao_acad.buscarPorId(idaca);
            List<Curso> c = dao_asoc.academiasConCursos(ac);
            response.type("application/json");
            if (c!=null) {
                return gson.toJson(c);
            }
            else{
                return "No existe ese curso ";
            }
        });

        // Entpoint Asignar curso a academia
        Spark.post("/cursos/academias/:idcurs/:idac", (request, response) -> {
            Long idcurs = Long.parseLong(request.params(":idcurs"));
            Long idaca = Long.parseLong(request.params(":idac"));
            Curso c= dao_curs.buscarPorId(idcurs);
            Academia ac= dao_acad.buscarPorId(idaca);
            response.type("application/json");
            return gson.toJson(dao_asoc.asignarAcademiaCurso(c,ac));
        });

        // Entoint obtener academias de un profesor
        Spark.get("/profesores/academias/:idprof", (request, response) -> {
            Long idprof = Long.parseLong(request.params(":idprof"));
            Profesor p= dao_prof.buscarPorId(idprof);
            List<Academia> ac = dao_asoc.profesoresConAcademias(p);
            response.type("application/json");
            if (ac!=null) {
                return gson.toJson(ac);
            }
            else{
                return "No existe esa academia";
            }
        });

        // Entpoint obtener profesores de una academia
        Spark.get("/academias/profesores/:idac", (request, response) -> {
            Long idaca = Long.parseLong(request.params(":idac"));
            Academia ac= dao_acad.buscarPorId(idaca);
            List<Profesor> p = dao_asoc.academiasConProfesores(ac);
            response.type("application/json");
            if (p!=null) {
                return gson.toJson(p);
            }
            else{
                return "No existe ese profesor ";
            }
        });

        // Entpoint Asignar profesor a academia
        Spark.post("/profesores/academias/:idprof/:idac", (request, response) -> {
            Long idprof = Long.parseLong(request.params(":idprof"));
            Long idaca = Long.parseLong(request.params(":idac"));
            Profesor p= dao_prof.buscarPorId(idprof);
            Academia ac= dao_acad.buscarPorId(idaca);
            response.type("application/json");
            return gson.toJson(dao_asoc.asignarAcademiaProfesores(p,ac));
        });
    }
}


