DROP TABLE IF EXISTS CANCIONES;
DROP TABLE IF EXISTS ALBUMES;
CREATE TABLE ALBUMES (
        id INTEGER(4) AUTO_INCREMENT,
        titulo VARCHAR(40) UNIQUE,
        autor VARCHAR(40),
        genero VARCHAR(30),
        fecha DATE,
        precio DOUBLE,
        PRIMARY KEY(id)
        );
CREATE TABLE CANCIONES (
        id INTEGER(4) AUTO_INCREMENT,
        titulo VARCHAR(40) UNIQUE,
        duracion INTEGER(2),
        orden INTEGER(2),
        id_album INTEGER(4),
        PRIMARY KEY(id)
        );


    