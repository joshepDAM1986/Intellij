package dao;

import entidades.Academia;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.PersistenceException;
import java.util.List;

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

    public List<Academia> devolverTodosAcademias() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Academia> todos=session.createQuery("from Academia", Academia.class).list();

        session.close();

        return todos;
    }

    @Override
    public List<Academia> devolverTodosAcademias(int pagina, int objetos_por_pagina) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Academia", Academia.class);
        query.setMaxResults(objetos_por_pagina);
        query.setFirstResult((pagina - 1) * objetos_por_pagina);

        List<Academia> todos = query.list();

        session.close();

        return todos;
    }

    @Override
    public Long totalAcademias() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Long> query= session.createQuery("select count(ac) from Academia ac", Long.class);
        long contador= query.getSingleResult();
        System.out.println(contador);
        session.close();
        return contador;
    }

    @Override
    public Academia buscarPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Academia ac = session.find(Academia.class, id);
        session.close();

        return ac;
    }

    @Override
    public Academia updateByIdAcademias(Academia academia) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(academia);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return academia;
    }

    @Override
    public boolean deleteByIdAcademias(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Academia academia = this.buscarPorId(id);
            if(academia!=null){
                session.delete(academia);
            }else{
                return false;
            }
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
