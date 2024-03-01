package dao;

import entidades.Asignatura;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.PersistenceException;
import java.util.List;

public class AsignaturaDAO implements AsignaturaDAOInterface{
    @Override
    public Asignatura crearAsignatura(Asignatura as) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(as);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return as;
    }


    public List<Asignatura> devolverTodosAsignaturas() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Asignatura> todos=session.createQuery("from Asignatura", Asignatura.class).list();

        session.close();

        return todos;
    }

    @Override
    public List<Asignatura> devolverTodosAsignaturas(int pagina, int objetos_por_pagina) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Asignatura", Asignatura.class);
        query.setMaxResults(objetos_por_pagina);
        query.setFirstResult((pagina - 1) * objetos_por_pagina);

        List<Asignatura> todos = query.list();

        session.close();

        return todos;
    }

    @Override
    public Long totalAsignaturas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Long> query= session.createQuery("select count(as) from Asignatura as", Long.class);
        long contador= query.getSingleResult();
        System.out.println(contador);
        session.close();
        return contador;
    }
    @Override
    public Asignatura buscarPorId(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Asignatura as = session.find(Asignatura.class, id);
        session.close();

        return as;
    }

    @Override
    public Asignatura updateByIdAsignatura(Asignatura asignatura) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(asignatura);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return asignatura;
    }

    @Override
    public boolean deleteByIdAsignatura(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Asignatura asignatura = this.buscarPorId(id);
            if(asignatura!=null){
                session.delete(asignatura);
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

