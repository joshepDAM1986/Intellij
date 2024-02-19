package dao;

import entidades.Academia;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.PersistenceException;

public class AcademiaDAO implements AcademiaDAOInterface {
    @Override
    public Academia crearAcademia(Academia ac) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(ac);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return ac;
    }

    @Override
    public Academia buscarPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Academia ac = session.find(Academia.class, id);
        session.close();

        return ac;
    }
}
