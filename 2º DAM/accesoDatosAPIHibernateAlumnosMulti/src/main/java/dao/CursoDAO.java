package dao;

import entidades.Curso;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.PersistenceException;
import java.util.List;

public class CursoDAO implements CursoDAOInterface{

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
    public List<Curso> devolverTodosCursos() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Curso> todos=session.createQuery("from Curso", Curso.class).list();

        session.close();

        return todos;
    }

    @Override
    public List<Curso> devolverTodosCursos(int pagina, int objetos_por_pagina) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Curso", Curso.class);
        query.setMaxResults(objetos_por_pagina);
        query.setFirstResult((pagina - 1) * objetos_por_pagina);

        List<Curso> todos = query.list();

        session.close();

        return todos;
    }

    @Override
    public Long totalCursos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Long> query= session.createQuery("select count(c) from Curso c", Long.class);
        long contador= query.getSingleResult();
        System.out.println(contador);
        session.close();
        return contador;
    }

    @Override
    public Curso buscarPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Curso c = session.find(Curso.class, id);
        session.close();

        return c;
    }

    @Override
    public Curso updateByIdCurso(Curso curso) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(curso);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return curso;
    }

    @Override
    public boolean deleteByIdCurso(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Curso curso = this.buscarPorId(id);
            if(curso!=null){
                session.delete(curso);
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