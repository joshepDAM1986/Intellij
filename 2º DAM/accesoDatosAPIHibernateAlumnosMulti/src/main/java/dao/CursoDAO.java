package dao;

import entidades.Curso;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.PersistenceException;

public class CursoDAO implements CursoDAOInterface{
    @Override
    public Curso crearCurso(Curso c) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return c;
    }

    @Override
    public Curso buscarPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Curso c = session.find(Curso.class, id);
        session.close();

        return c;
    }
}