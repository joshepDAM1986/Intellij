package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "$objectdb/db/address-book.odb");
        EntityManager em = emf.createEntityManager();
        CRUD.insertar(em);
        //CRUD.insertar(em);
        //CRUD.insertar(em);
        //CRUD.borrar(em);
        //System.out.println("Borrados: " + CRUD.borrar(em, "Donald Duck"));
        //System.out.println("Borrados: " + CRUD.borrar2(em,"Mickey Mouse"));
        CRUD.leer(em);


        em.close();
        emf.close();
    }
}