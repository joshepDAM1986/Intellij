package dao;

import entidades.Profesor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.PersistenceException;
import java.util.List;

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

    public List<Profesor> devolverTodosProfesores() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Profesor> todos=session.createQuery("from Profesor", Profesor.class).list();

        session.close();

        return todos;
    }

    @Override
    public List<Profesor> devolverTodosProfesores(int pagina, int objetos_por_pagina) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Profesor", Profesor.class);
        query.setMaxResults(objetos_por_pagina);
        query.setFirstResult((pagina - 1) * objetos_por_pagina);

        List<Profesor> todos = query.list();

        session.close();

        return todos;
    }

    @Override
    public Long totalProfesores() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Long> query= session.createQuery("select count(p) from Profesor p", Long.class);
        long contador= query.getSingleResult();
        System.out.println(contador);
        session.close();
        return contador;
    }
    @Override
    public Profesor buscarPorId(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Profesor p = session.find(Profesor.class, id);
        session.close();

        return p;
    }

    @Override
    public Profesor updateByIdProfesores(Profesor profesor) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(profesor);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return profesor;
    }

    @Override
    public boolean deleteByIdProfesores(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Profesor profesor = this.buscarPorId(id);
            if(profesor!=null){
                session.delete(profesor);
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
