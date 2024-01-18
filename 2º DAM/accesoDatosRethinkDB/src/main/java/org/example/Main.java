package org.example;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final RethinkDB r = RethinkDB.r;
    private static final String dbName = "miBaseDatos";
    private static final String tableName = "2DAM";

    public static void main(String[] args) {
        Connection conn = r.connection().hostname("localhost").port(28015).connect();

        // Crear la base de datos solo si no existe
        if (!r.dbList().contains(dbName).run(conn).equals(true)) {
            r.dbCreate(dbName).run(conn);
        }

        // Usar la base de datos recién creada
        conn.use(dbName);

        // Crear la tabla solo si no existe
        if (!r.tableList().contains(tableName).run(conn).equals(true)) {
            r.tableCreate(tableName).run(conn);
        }

        // Insertar datos de ejemplo
        insertarAlumno(conn, "12345678A", "Juan", "Pérez", 7.5);
        insertarAlumno(conn, "98765432B", "Ana", "Gómez", 4.8);
        insertarAlumno(conn, "11122334C", "Pedro", "López", 6.2);
        insertarAlumno(conn, "55556666D", "Sofía", "Martínez", 8.9);
        insertarAlumno(conn, "77778888E", "Luis", "Fernández", 3.5);
        insertarAlumno(conn, "99990000F", "Laura", "García", 9.7);
        insertarAlumno(conn, "12121212G", "Miguel", "Rodríguez", 5.1);
        insertarAlumno(conn, "13131313H", "María", "Díaz", 6.8);
        insertarAlumno(conn, "14141414I", "Carlos", "Hernández", 4.3);
        insertarAlumno(conn, "15151515J", "Elena", "Sánchez", 7.0);

        // Mostrar todos los alumnos
        System.out.println("Alumnos antes de la actualización:");
        mostrarAlumnos(conn);

        // Actualizar un alumno
        actualizarAlumno(conn, "12345678A", "Juanito", "Pérez", 8.0);

        // Mostrar todos los alumnos después de la actualización
        System.out.println("Alumnos después de la actualización:");
        mostrarAlumnos(conn);

        // Eliminar un alumno
        eliminarAlumno(conn, "12345678A");

        // Mostrar todos los alumnos después de la eliminación
        System.out.println("Alumnos después de la eliminación:");
        mostrarAlumnos(conn);

        // Borrar todos los alumnos
        borrarTodosLosAlumnos(conn);

        // Mostrar todos los alumnos después de borrarlos
        System.out.println("Alumnos después de borrar todos:");
        mostrarAlumnos(conn);

        // Cerrar la conexión
        conn.close();
    }

    private static void insertarAlumno(Connection conn, String dni, String nombre, String apellidos, double notaMedia) {
        Map<String, Object> alumno = new HashMap<>();
        alumno.put("dni", dni);
        alumno.put("nombre", nombre);
        alumno.put("apellidos", apellidos);
        alumno.put("nota_media", notaMedia);
        alumno.put("aprobado", notaMedia >= 5.0);

        r.table(tableName).insert(alumno).run(conn);
    }

    private static void mostrarAlumnos(Connection conn) {
        Cursor<Map<String, Object>> cursor = r.table(tableName).run(conn);
        cursor.forEachRemaining(System.out::println);
    }

    private static void actualizarAlumno(Connection conn, String dni, String nuevoNombre, String nuevosApellidos, double nuevaNotaMedia) {
        r.table(tableName)
                .filter(r.hashMap("dni", dni))
                .update(
                        r.hashMap("nombre", nuevoNombre)
                                .with("apellidos", nuevosApellidos)
                                .with("nota_media", nuevaNotaMedia)
                                .with("aprobado", nuevaNotaMedia >= 5.0)
                )
                .run(conn);
    }

    private static void eliminarAlumno(Connection conn, String dni) {
        r.table(tableName)
                .filter(r.hashMap("dni", dni))
                .delete()
                .run(conn);
    }

    private static void borrarTodosLosAlumnos(Connection conn) {
        r.table(tableName).delete().run(conn);
    }
}
