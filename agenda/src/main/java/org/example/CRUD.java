package org.example;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CRUD {
    /**
     * Insertar en BD
     */
    static public void insertar(EntityManager em)
    {
        em.getTransaction().begin();
        Contact b1=new Contact("Mickey Mouse",
                "Disney");
        Contact b2=new Contact("Donald Duck",
                "Disney");
        Contact b3=new Contact("Hulk",
                "Marvel");
        Contact b4=new Contact("Spiderman",
                "Marvel");
        Contact b5=new Contact("Superman",
                "DC");
            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.persist(b4);
            em.persist(b5);


        em.getTransaction().commit();
    }

    static public void leer(EntityManager em) {

        TypedQuery<Contact> query
                = em.createQuery("SELECT b FROM Contact b",
                Contact.class);
        List<Contact> results = query.getResultList();
        for (Contact bb : results) {
            System.out.println(bb);
        }

        //Buscar a Mickey
        Contact c = em.find(Contact.class, 1);
        System.out.println("Datos de Mickey: "
                + c);
    }

    /**
     * Borrar contacto por id
     * @param em
     * @param id
     */
    static public void borrarContacto(EntityManager em, int id) {
        Contact c = em.find(Contact.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();

    }

    static public void borrar(EntityManager em) {
        for(int i=1;i<=5;i++) {
            borrarContacto(em, i);
        }
    }

    static public int borrar(EntityManager em, String nombre) {
        Query query
                = em.createQuery("DELETE FROM Contact b " +
                        "WHERE b.name = '" + nombre + "'",
                Contact.class);

        em.getTransaction().begin();
        int borrados = query.executeUpdate();
        em.getTransaction().commit();

        return borrados;
    }

    static public int borrar2(EntityManager em, String nombre) {
        int borrados = 0;
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Contact> consulta =
                    cb.createQuery(Contact.class);
            Root<Contact> contactos
                    = consulta.from(Contact.class);
            Predicate predicadoNombre =
                    cb.equal(contactos.get("name"), nombre);
            consulta.select(contactos).where(predicadoNombre);

            em.getTransaction().begin();

            List<Contact> listaPatos = em.createQuery(consulta).getResultList();
            for (Contact pato : listaPatos) {
                em.remove(pato);
                borrados++;
            }

            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return borrados;
    }
}
