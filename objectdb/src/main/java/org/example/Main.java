package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("$objectdb/db/BBDD.odb");
        EntityManager em;
        em= emf.createEntityManager();
        em.getTransaction().begin();
        Persona p=new Persona();
        p.setNombre("luis");
        p.setDni("2fff");
        Vehiculo v=new Vehiculo();
        v.setMatricula("636GR");
        v.setConductor(p);
        //v.setId(22);

        //en.persistente
        em.persist(v);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}