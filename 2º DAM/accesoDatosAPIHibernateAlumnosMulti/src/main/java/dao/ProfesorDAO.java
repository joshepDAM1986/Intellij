package dao;

import entidades.Profesor;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.PersistenceException;

public class ProfesorDAO implements ProfesorDAOInterface{
    @Override
    public Profesor crearProfesor(Profesor p) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return p;
    }
    @Override
    public Profesor buscarPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Profesor p = session.find(Profesor.class, id);
        session.close();

        return p;
    }
}
