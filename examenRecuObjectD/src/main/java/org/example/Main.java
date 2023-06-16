package org.example;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Main {
    public static void main(String[] args) {
        EntityManager em = conectarBaseDatos("Personajes");

        /* CREAR E INSERTAR DATOS */
//        CRUDPersonaje.crearEspecie(em);
//        CRUDPersonaje.crearArma(em);
//        CRUDPersonaje.crearAfiliacion(em);
//        CRUDPersonaje.crearPersonaje(em);

        /* BUSCAR PERSONAJE POR ID */
//       CRUDPersonaje.consultarPersonajeIdQuery(em,1);
        /* BUSCAR PERSONAJE POR NOMBRE (NO FUNCA) */
//        CRUDPersonaje.buscarPersonajePorNombre(em,"Luke Skywalker");
        /* MODIFICAR AFILIACION POR ID */
         CRUDPersonaje.modificarAfiliacion(em,2,"Sith");
        /* BORRAR PERSONAJE POR ID */
      //  CRUDPersonaje.eliminarPersonaje(em,1);
        /* LISTAR PERSONAJES */
        CRUDPersonaje.listarPersonajeOrdenados(em);
    }
    public static EntityManager conectarBaseDatos(String baseDatos)
    {
        try
        {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/" + baseDatos + ".odb");
            return emf.createEntityManager();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}