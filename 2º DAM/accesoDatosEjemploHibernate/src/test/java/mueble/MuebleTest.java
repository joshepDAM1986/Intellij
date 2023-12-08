package mueble;

import entidades.Mueble;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import util.HibernateUtils;

import java.util.List;

public class MuebleTest {
    @Test
    void Test1() {


        Mueble mueble1 = new Mueble(null,
                "Silla barata",
                "Ikea",
                "silla.jpg",
                27.7
        );


        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();


        session.beginTransaction();


        session.save(mueble1);


        session.getTransaction().commit();


        session.close();
        sessionFactory.close();
        HibernateUtils.shutdown();
    }

    @Test
    void Test2() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        // Consulta HQL
        List<Mueble> todos = session
                .createQuery("from Mueble", Mueble.class).list();
        System.out.println(todos);
        session.close();
        HibernateUtils.shutdown();

    }

    @Test
    void TestPersistencia() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        // Consulta HQL
        List<Mueble> todos = session
                .createQuery("from Mueble", Mueble.class).list();
        session.beginTransaction();
        for (Mueble mu : todos) {
            mu.setPrecio(10.0);
            session.save(mu);
        }

        session.getTransaction().commit();
        session.close();
        HibernateUtils.shutdown();
    }
}
