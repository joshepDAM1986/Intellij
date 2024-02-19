INSERT INTO cursos (nombre, nivel, horas) VALUES ('Desarrollo Aplicaciones Multiplataforma', 'Superior', 2000)
INSERT INTO cursos (nombre, nivel, horas) VALUES ('Desarrollo Aplicaciones WEB', 'Superior', 1800)
INSERT INTO cursos (nombre, nivel, horas) VALUES ('Sistemas Microinformáticos', 'Medio', 1700)
INSERT INTO cursos (nombre, nivel, horas) VALUES ('Integración Social', 'Superior', 1900)
INSERT INTO cursos (nombre, nivel, horas) VALUES ('Educación Infantil', 'Superior', 1600)

INSERT INTO profesores (nombre,email) VALUES ('Victor Fernandez', 'victor@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Dani Rodriguez', 'dani@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Juan Lopez', 'juan@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Elena Benavente', 'elena@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Maria Garcia', 'maria@gmail.com')
INSERT INTO profesores (nombre,email) VALUES ('Gloria Fraga', 'gloria@gmail.com')

INSERT INTO academias (direccion, email, nombre, telefono) VALUES ('Calle Gran Vía, 123', 'info@academiaprimaria.es', 'Academia Primaria', 912345678);
INSERT INTO academias (direccion, email, nombre, telefono) VALUES ('Avenida de la Constitución, 456', 'contacto@institutoexcelencia.es', 'Instituto Excelencia', 678901234);
INSERT INTO academias (direccion, email, nombre, telefono) VALUES ('Plaza Mayor, 789', 'info@centroeducativoandaluz.es', 'Centro Educativo Andaluz', 345678901);
INSERT INTO academias (direccion, email, nombre, telefono) VALUES ('Calle del Prado, 101', 'administracion@colegioiberico.es', 'Colegio Ibérico', 890123456);
INSERT INTO academias (direccion, email, nombre, telefono) VALUES ('Paseo del Retiro, 111', 'info@academiadelarte.es', 'Academia del Arte', 567890123);

INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Suspenso', '11111111A', 19, 'carlos.lopez@gmail.com', '2022-03-20', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/carlos.jpg?alt=media&token=fb6485e7-3cd2-43b2-bbdd-7e815e7e0994', 'Carlos López', 1.5, 1, 3);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Notable', '22222222B', 21, 'ana.martinez@gmail.com', '2022-04-10', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/ana.jpg?alt=media&token=2c6fd210-42dd-41e4-a2a3-3ee1ea787f24', 'Ana Martínez', 8.9, 1, 1);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Suspenso', '33333333C', 23, 'luis.garcia@gmail.com', '2022-05-05', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/luis.jpg?alt=media&token=f1fda33c-375a-4491-b7cd-54d117d389d3', 'Luis García', 2.8, 1, 5);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Sobresaliente', '44444444D', 20, 'elena.rodriguez@gmail.com', '2022-06-12', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/elena.jpg?alt=media&token=bef7cdf2-97b2-4992-89d4-c627f7acc1e9', 'Elena Rodríguez', 9.5, 2, 2);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Notable', '55555555E', 22, 'pedro.sanchez@gmail.com', '2022-07-08', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/pedro.jpg?alt=media&token=9a3cbcda-5c9f-483b-9a7d-b60261d9cfa6', 'Pedro Sánchez', 8.0, 2, 4);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Notable', '66666666F', 21, 'laura.lopez@gmail.com', '2022-08-19', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/laura.jpg?alt=media&token=fb4cc094-2231-4e32-bd99-ebece0e95a25', 'Laura López', 8.7, 2, 1);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Notable', '77777777G', 19, 'jose.gutierrez@gmail.com', '2022-09-25', 'https://console.firebase.google.com/project/joshepapihibernate/storage/joshepapihibernate.appspot.com/files?hl=es', 'José Gutiérrez', 7.9, 3, 5);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Sobresaliente', '88888888H', 20, 'carmen.fernandez@gmail.com', '2022-10-30', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/carmen.jpg?alt=media&token=190e4c99-cd53-4ecf-8680-01e572ba524e', 'Carmen Fernández', 9.0, 3, 5);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Suspenso', '99999999I', 23, 'miguel.martin@gmail.com', '2022-11-15', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/miguel.jpg?alt=media&token=430aa60a-5064-43b8-aadf-07a5ed75d436', 'Miguel Martín', 3.2, 3, 2);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Notable', '10101010J', 21, 'raquel.garcia@gmail.com', '2022-12-03', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/raquel.jpg?alt=media&token=3d830f1d-4c8e-4f8a-b83f-b7c7af6487d3', 'Raquel García', 8.8, 4, 3);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Notable', '12121212K', 22, 'alberto.hernandez@gmail.com', '2023-01-22', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/alberto.jpg?alt=media&token=c2745636-1d32-482b-9559-f1a944649b98', 'Alberto Hernández', 8.3, 4, 1);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Sobresaliente', '13131313L', 20, 'isabel.diaz@gmail.com', '2023-02-14', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/isabel.jpg?alt=media&token=fded4432-922d-4b39-beff-3c72be7671db', 'Isabel Díaz', 9.1, 4, 2);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Notable', '14141414M', 19, 'fernando.moreno@gmail.com', '2023-03-08', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/fernando.jpg?alt=media&token=4b8394cb-0a60-4af2-957c-63b91c97c7dd', 'Fernando Moreno', 7.7, 5, 4);
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Notable', '15151515N', 23, 'sandra.ortega@gmail.com', '2023-04-19', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/sandra.jpg?alt=media&token=d29c1949-3beb-413e-b61f-91b79d1a664d', 'Sandra Ortega', 8.6, 5, 4;
INSERT INTO alumnos (categoria, dni, edad, email, fecha_matriculacion, imagen_url, nombre, nota, curso_key, academia_key) VALUES ('Bien', '16161616O', 22, 'javier.ramirez@gmail.com', '2023-05-27', 'https://firebasestorage.googleapis.com/v0/b/joshepapihibernate.appspot.com/o/javier.jpg?alt=media&token=05abf304-24df-4c78-9353-73446de0d45e', 'Javier Ramírez', 6.5, 5, 2);

INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (1, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (1, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (1, 6);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (2, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (3, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (4, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (5, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (6, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (7, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (8, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (8, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (9, 6);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (10, 2);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (11, 5);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (12, 1);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (12, 4);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (13, 3);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (14, 6);
INSERT INTO profesor_alumno (alumno_id, profesor_id) VALUES (15, 4);

INSERT INTO academia_curso (academia_id, curso_id) VALUES (1, 3);
INSERT INTO academia_curso (academia_id, curso_id) VALUES (1, 5);
INSERT INTO academia_curso (academia_id, curso_id) VALUES (2, 2);
INSERT INTO academia_curso (academia_id, curso_id) VALUES (3, 4);
INSERT INTO academia_curso (academia_id, curso_id) VALUES (4, 1);

INSERT INTO academia_profesor (academia_id, profesor_id) VALUES (2, 3);
INSERT INTO academia_profesor (academia_id, profesor_id) VALUES (3, 1);
INSERT INTO academia_profesor (academia_id, profesor_id) VALUES (3, 5);
INSERT INTO academia_profesor (academia_id, profesor_id) VALUES (4, 2);
INSERT INTO academia_profesor (academia_id, profesor_id) VALUES (5, 4);

