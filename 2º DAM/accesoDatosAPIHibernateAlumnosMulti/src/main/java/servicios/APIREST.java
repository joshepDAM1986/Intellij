package servicios;

import com.appslandia.common.gson.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.*;
import dto.AlumnoDTO;
import entidades.Alumno;
import entidades.Asignatura;
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
    private AsignaturaDAOInterface dao_asig;

    private AsociacionesDAOInterface dao_asoc;

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    public APIREST(AlumnoDAOInterface implementacion, CursoDAOInterface implementacion_curs, ProfesorDAOInterface implementacion_prof, AsignaturaDAOInterface implementacion_asig, AsociacionesDAOInterface implementacion_asoc) {
        Spark.port(8080);
        dao = implementacion;
        dao_curs = implementacion_curs;
        dao_prof = implementacion_prof;
        dao_asig = implementacion_asig;
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

        //------------------------------------------END POINT DE ASIGNATURA------------------------------------------//

        // Mostrar todos
        Spark.get("/asignaturas/todos", (request, response) -> {
            response.type("application/json");

            List<Asignatura> asignaturas = dao_asig.devolverTodosAsignaturas();
            return gson.toJson(asignaturas);
        });

        // Mostrar todos paginado
        Spark.get("/asignaturas/todos/paginado/:pagina/:tam_pagina", (request, response) -> {
            response.type("application/json");

            Integer pagina = Integer.parseInt(request.params(":pagina"));
            Integer tamaño_pagina = Integer.parseInt(request.params(":tam_pagina"));

            List<Asignatura> asignaturas = dao_asig.devolverTodosAsignaturas(pagina, tamaño_pagina);
            long totalElementos = dao_prof.totalProfesores();

            RespuestaPaginacion<Asignatura> paginaResultado = new RespuestaPaginacion<>(asignaturas, totalElementos, pagina, tamaño_pagina);

            return gson.toJson(paginaResultado);
        });

        // Crear
        Spark.post("/asignaturas/crear", (request, response) -> {
            response.type("application/json");

            String body = request.body();
            Asignatura nuevaAsignatura = gson.fromJson(body, Asignatura.class);
            Asignatura creada = dao_asig.crearAsignatura(nuevaAsignatura);
            return gson.toJson(creada);
        });

        // Modificar
        Spark.put("/asignaturas/modificar/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            String body = request.body();
            Asignatura asignaturaActualizada = gson.fromJson(body, Asignatura.class);
            asignaturaActualizada.setId(id);
            Asignatura actualizada = dao_asig.updateByIdAsignatura(asignaturaActualizada);
            if (actualizada != null) {
                return gson.toJson(actualizada);
            } else {
                response.status(404);
                return "Asignatura no encontrado";
            }
        });

        // Borrar
        Spark.delete("/asignaturas/borrar/:id", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            boolean eliminado = dao_asig.deleteByIdAsignatura(id);
            if (eliminado) {
                return "Asignatura eliminada correctamente";
            } else {
                response.status(404);
                return "Asignatura no encontrada";
            }
        });

        //------------------------------------------END POINT DE RELACIONES------------------------------------------//

        // Crear alumno y asignar curso y profesor
        Spark.post("/alumnos/crear/:cursoId/:profesorId", (request, response) -> {
            response.type("application/json");

            String body = request.body();
            Alumno nuevoAlumno = gson.fromJson(body, Alumno.class);

            // Obtén la ID del curso y del profesor de la ruta
            Long cursoId = Long.parseLong(request.params(":cursoId"));
            Long profesorId = Long.parseLong(request.params(":profesorId"));

            // Verifica si el curso y el profesor existen antes de asignarlos al alumno
            Curso curso = dao_curs.buscarPorId(cursoId);
            Profesor profesor = dao_prof.buscarPorId(profesorId);

            if (curso != null && profesor != null) {
                // Los curso y profesor existen, asígnalos al alumno
                nuevoAlumno.setCurso(curso);
                nuevoAlumno.getProfesores().add(profesor);

                // Realiza la creación del alumno y la asignación del curso y profesor
                Alumno creado = dao.create(nuevoAlumno);

                return gson.toJson(creado);
            } else {
                response.status(404);
                return "Curso o profesor no encontrado";
            }
        });

        // Modificar alumno y asignar curso y profesor
        Spark.put("/alumnos/modificar/:id/:cursoId/:profesorId", (request, response) -> {
            response.type("application/json");

            long id = Long.parseLong(request.params(":id"));
            Alumno alumnoActualizado = gson.fromJson(request.body(), Alumno.class);
            alumnoActualizado.setId(id);

            // Obtén la ID del nuevo curso y del nuevo profesor de la ruta
            Long nuevoCursoId = Long.parseLong(request.params(":cursoId"));
            Long nuevoProfesorId = Long.parseLong(request.params(":profesorId"));

            // Modifica el alumno y asigna el nuevo curso
            Alumno actualizado = dao.updateById(alumnoActualizado);

            if (actualizado != null) {
                // Obtén el curso y profesor por sus IDs
                Curso nuevoCurso = dao_curs.buscarPorId(nuevoCursoId);
                Profesor nuevoProfesor = dao_prof.buscarPorId(nuevoProfesorId);

                if (nuevoCurso != null && nuevoProfesor != null) {
                    // Asigna el nuevo curso y profesor al alumno
                    actualizado.setCurso(nuevoCurso);

                    // Agrega el nuevo profesor a la lista
                    actualizado.getProfesores().add(nuevoProfesor);

                    // Actualiza nuevamente el alumno en la base de datos
                    dao.updateById(actualizado);

                    return gson.toJson(actualizado);
                } else {
                    response.status(404);
                    return "Curso o profesor no encontrado";
                }
            } else {
                response.status(404);
                return "Alumno no encontrado";
            }
        });

        // Localizador de excepciones
        Spark.exception(Exception.class, (exception, request, response) -> {
            response.type("application/json");
            exception.printStackTrace(); // Imprime la excepción en la consola
            response.status(500); // Establece el código de estado HTTP 500
            response.body("Excepcion en tu codigo"); // Mensaje de error para el cliente
        });

        // Obtener el curso de un alumno
        Spark.get("/alumnos/cursos/:idal", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Alumno a= dao.buscarById(idal);
            Curso c = dao_asoc.obtenercursoAlumno(a);
            response.type("application/json");
            if (c!=null) {
                return gson.toJson(c);
            }
            else{
                return "No existe ese alumno";
            }
        });

        // Obtener los alumnos de un curso
        Spark.get("/cursos/alumnos/:idcurs", (request, response) -> {
            Long id = Long.parseLong(request.params(":idcurs"));
            Curso p= dao_curs.buscarPorId(id);
            List<Alumno> a = dao_asoc.obtenerAlumnosCurso(p);
            response.type("application/json");
            if (a!=null) {
                return gson.toJson(a);
            }
            else{
                return "No existe ese curso";
            }
        });

        // Asignar curso a alumno
        Spark.post("/cursos/alumnos/:idcurs/:idal", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Long idcurs = Long.parseLong(request.params(":idcurs"));
            Alumno a= dao.buscarById(idal);
            Curso c= dao_curs.buscarPorId(idcurs);
            response.type("application/json");
            return gson.toJson(dao_asoc.asignarCurso(a,c));
        });

        // Obtener profesores de un alumno
        Spark.get("/alumnos/profesores/:idal", (request, response) -> {
            Long idal = Long.parseLong(request.params(":idal"));
            Alumno a= dao.buscarById(idal);
            List<Profesor> p = dao_asoc.alumnosConProfesor(a);
            response.type("application/json");
            if (p!=null) {
                return gson.toJson(p);
            }
            else{
                return "No existe ese alumno";
            }
        });

        // Obtener alumnos de un profesor
        Spark.get("/profesores/alumnos/:idprof", (request, response) -> {
            Long id = Long.parseLong(request.params(":idprof"));
            Profesor p= dao_prof.buscarPorId(id);
            List<Alumno> a = dao_asoc.profesoresConAlumnos(p);
            response.type("application/json");
            if (a!=null) {
                return gson.toJson(a);
            }
            else{
                return "No existe ese profesor";
            }
        });

            // Asignar profesor a alumno
            Spark.post("/profesores/alumnos/:idprof/:idal", (request, response) -> {
                Long idal = Long.parseLong(request.params(":idal"));
                Long idprof = Long.parseLong(request.params(":idprof"));
                Alumno a= dao.buscarById(idal);
                Profesor p= dao_prof.buscarPorId(idprof);
                response.type("application/json");
                return gson.toJson(dao_asoc.asignarProfesor(a,p));
        });

        // Obtener asignaturas de un curso
        Spark.get("/cursos/asignaturas/:idcurs", (request, response) -> {
            Long idcurs = Long.parseLong(request.params(":idcurs"));
            Curso c= dao_curs.buscarPorId(idcurs);
            List<Asignatura> as = dao_asoc.cursosAsignaturas(c);
            response.type("application/json");
            if (as!=null) {
                return gson.toJson(as);
            }
            else{
                return "No existe ese curso";
            }
        });

        // Obtener cursos de una asignatura
        Spark.get("/asignaturas/cursos/:idasig", (request, response) -> {
            Long idasig = Long.parseLong(request.params(":idasig"));
            Asignatura as= dao_asig.buscarPorId(idasig);
            List<Curso> c = dao_asoc.asignaturasCursos(as);
            response.type("application/json");
            if (c!=null) {
                return gson.toJson(c);
            }
            else{
                return "No existe esa asignatura";
            }
        });

        // Asignar asignatura a curso
        Spark.post("/asignaturas/cursos/:idasig/:idcurs", (request, response) -> {
            Long idcurs = Long.parseLong(request.params(":idcurs"));
            Long idasig = Long.parseLong(request.params(":idasig"));
            Curso c= dao_curs.buscarPorId(idcurs);
            Asignatura as= dao_asig.buscarPorId(idasig);
            response.type("application/json");
            return gson.toJson(dao_asoc.asignarAsignatura(c,as));
        });
    }
}


