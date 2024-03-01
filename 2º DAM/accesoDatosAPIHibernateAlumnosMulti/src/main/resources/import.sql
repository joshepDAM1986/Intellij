INSERT INTO cursos (nombre, tipo, horas) VALUES ('Desarrollo Aplicaciones Multiplataforma', 'Presencial', 2000)
INSERT INTO cursos (nombre, tipo, horas) VALUES ('Desarrollo Aplicaciones Web', 'Presendial', 1800)
INSERT INTO cursos (nombre, tipo, horas) VALUES ('Sistemas Microinformáticos', 'Híbrido', 1700)
INSERT INTO cursos (nombre, tipo, horas) VALUES ('Integración Social', 'Online', 1900)
INSERT INTO cursos (nombre, tipo, horas) VALUES ('Educación Infantil', 'Online', 1600)

INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Inglés', 3, 'Comun');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Emprendimiento e Iniciativa Emprendedora', 3, 'Comun');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Desarrollo de Aplicaciones Móviles', 8, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Diseño de Experiencia de Usuario', 5, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Programación Avanzada en Java', 8, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Gestión de Proyectos Web', 6, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Diseño de Interfaces de Usuario', 7, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Programación Web Avanzada', 5, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Redes de Computadoras', 8, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Sistemas Operativos', 8, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Mantenimiento de Hardware', 8, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Diversidad Funcional', 8, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Psicología Social', 7, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Intervención Socioeducativa', 7, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Desarrollo Infantil', 6, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Didáctica de la Educación Infantil', 4, 'Especifica');
INSERT INTO asignaturas (nombre, horas_semanales, tipo) VALUES ('Metodologías de Enseñanza', 4, 'Especifica');

INSERT INTO profesores (nombre,email) VALUES ('Victor Fernandez', 'victor@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Dani Rodriguez', 'dani@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Juan Lopez', 'juan@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Elena Benavente', 'elena@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Maria Garcia', 'maria@gmail.com')

INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Suspenso', '11111111A', 19, 'alberto.lopez@gmail.com', '2022-03-20', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/alberto.jpg?alt=media&token=c2745636-1d32-482b-9559-f1a944649b98', 'Alberto López', 1.5, 1);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '22222222B', 21, 'ana.martinez@gmail.com', '2022-04-10', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/ana.jpg?alt=media&token=2c6fd210-42dd-41e4-a2a3-3ee1ea787f24', 'Ana Martínez', 8.9, 1);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Suspenso', '33333333C', 23, 'carlos.garcia@gmail.com', '2022-05-05', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/carlos.jpg?alt=media&token=fb6485e7-3cd2-43b2-bbdd-7e815e7e0994', 'Carlos García', 2.8, 1);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Sobresaliente', '44444444D', 20, 'carmen.rodriguez@gmail.com', '2022-06-12', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/carmen.jpg?alt=media&token=190e4c99-cd53-4ecf-8680-01e572ba524e', 'Carmen Rodríguez', 9.5, 2);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '55555555E', 22, 'diego.sanchez@gmail.com', '2022-07-08', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/diego.jpg?alt=media&token=9c6bdb42-2f2e-432d-9c99-c1945b2f2f46', 'Diego Sánchez', 8.0, 2);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '66666666F', 21, 'elena.lopez@gmail.com', '2022-08-19', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/elena.jpg?alt=media&token=bef7cdf2-97b2-4992-89d4-c627f7acc1e9', 'Elena López', 8.7, 2);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '77777777G', 19, 'fernando.gutierrez@gmail.com', '2022-09-25', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/fernando.jpg?alt=media&token=4b8394cb-0a60-4af2-957c-63b91c97c7dd', 'Fernando Gutiérrez', 7.9, 3);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Sobresaliente', '88888888H', 20, 'isabel.fernandez@gmail.com', '2022-10-30', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/isabel.jpg?alt=media&token=fded4432-922d-4b39-beff-3c72be7671db', 'Isabel Fernández', 9.0, 3);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Suspenso', '99999999I', 23, 'javier.martin@gmail.com', '2022-11-15', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/javier.jpg?alt=media&token=05abf304-24df-4c78-9353-73446de0d45e', 'Javier Martín', 3.2, 3);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '10101010J', 21, 'jose.garcia@gmail.com', '2022-12-03', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/jose.jpg?alt=media&token=de07c935-43ff-40e3-a798-b04680173b59', 'Jose García', 8.8, 4);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '12121212K', 22, 'laura.hernandez@gmail.com', '2023-01-22', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/laura.jpg?alt=media&token=fb4cc094-2231-4e32-bd99-ebece0e95a25', 'Laura Hernández', 8.3, 4);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Sobresaliente', '13131313L', 20, 'luis.diaz@gmail.com', '2023-02-14', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/luis.jpg?alt=media&token=f1fda33c-375a-4491-b7cd-54d117d389d3', 'Luis Díaz', 9.1, 4);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '14141414M', 19, 'maria.moreno@gmail.com', '2023-03-08', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/maria.jpg?alt=media&token=bb690123-6f29-4ef2-a67a-e3ba23bacaaf', 'Maria Moreno', 7.7, 5);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '15151515N', 23, 'marta.ortega@gmail.com', '2023-04-19', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/marta.jpg?alt=media&token=c36bd978-5473-475d-b12a-1aa2907ae38e', 'Marta Ortega', 8.6, 5);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Bien', '16161616O', 22, 'miguel.ramirez@gmail.com', '2023-05-27', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/miguel.jpg?alt=media&token=430aa60a-5064-43b8-aadf-07a5ed75d436', 'Miguel Ramírez', 6.5, 5);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Sobresaliente', '17171717P', 21, 'natalia.santos@gmail.com', '2023-06-15', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/natalia.jpg?alt=media&token=119c1138-26d4-4b46-80fd-f4f8d486f100', 'Natalia Santos', 9.3, 1);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Bien', '18181818Q', 20, 'pedro.fernandez@gmail.com', '2023-07-25', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/pedro.jpg?alt=media&token=9a3cbcda-5c9f-483b-9a7d-b60261d9cfa6', 'Pedro Fernández', 7.2, 1);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Sobresaliente', '19191919R', 22, 'raquel.rojas@gmail.com', '2023-08-10', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/raquel.jpg?alt=media&token=3d830f1d-4c8e-4f8a-b83f-b7c7af6487d3', 'Raquel Rojas', 9.8, 2);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Notable', '20202020S', 19, 'roberto.mendez@gmail.com', '2023-09-18', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/roberto.jpg?alt=media&token=4ab4795f-b08f-4e3b-b495-0af0ee3b4e67', 'Roberto Mendez', 8.5, 2);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key) VALUES ('Suspenso', '21212121T', 23, 'sandra.perez@gmail.com', '2023-10-23', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/sandra.jpg?alt=media&token=d29c1949-3beb-413e-b61f-91b79d1a664d', 'Sandra Perez', 4.1, 2);

INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (1, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (1, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (1, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (1, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (1, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (2, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (2, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (2, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (3, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (4, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (4, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (4, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (5, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (5, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (5, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (6, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (6, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (6, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (7, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (7, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (7, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (8, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (8, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (8, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (9, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (9, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (9, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (10, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (10, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (10, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (11, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (11, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (11, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (12, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (12, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (12, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (13, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (13, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (13, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (14, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (14, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (14, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (15, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (15, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (15, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (16, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (16, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (16, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (17, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (17, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (17, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (18, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (18, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (18, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (19, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (19, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (19, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (20, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (20, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (20, 5);

INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (1, 1);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (1, 2);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (1, 3);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (1, 4);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (1, 5);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (2, 1);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (2, 2);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (2, 6);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (2, 7);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (2, 8);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (3, 1);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (3, 2);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (3, 9);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (3, 10);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (3, 11);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (4, 1);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (4, 2);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (4, 12);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (4, 13);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (4, 14);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (5, 1);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (5, 2);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (5, 15);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (5, 16);
INSERT INTO cursos_asignaturas (curso_id, asignatura_id) VALUES (5, 17);
