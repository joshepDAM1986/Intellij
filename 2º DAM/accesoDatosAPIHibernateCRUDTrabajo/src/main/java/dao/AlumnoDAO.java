package dao;

import dto.AlumnoDTO;
import entidades.Alumno;
import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.PersistenceException;
import java.util.List;

public class AlumnoDAO implements AlumnoDAOInterface {

    public List<Alumno> devolverTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Alumno> todos=session.createQuery("from Alumno", Alumno.class).list();

        session.close();

        return todos;
    }

    @Override
    public List<Alumno> devolverTodos(int pagina, int objetos_por_pagina) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Alumno", Alumno.class);
        query.setMaxResults(objetos_por_pagina);
        query.setFirstResult((pagina - 1) * objetos_por_pagina);

        List<Alumno> todos = query.list();

        session.close();

        return todos;
    }

    @Override
    public Alumno create(Alumno alumno) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(alumno);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return alumno;
    }

    @Override
    public Alumno buscarById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Alumno alumno = session.find(Alumno.class, id);
        session.close();

        return alumno;
    }

    @Override
    public List<Alumno> buscarByNombreLike(String busqueda) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Alumno> query = session.createQuery("from Alumno a where a.nombre like :busqueda", Alumno.class);
        List<Alumno> filtro=query.setParameter("busqueda", "%"+busqueda+"%").list();

        session.close();

        return filtro;
    }

    @Override
    public List<AlumnoDTO> buscarByCategoria(String categoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<AlumnoDTO> query = session.createQuery("select new dto.AlumnoDTO(a.nombre, a.apellidos, a.categoria, a.nota) from Alumno a where a.categoria = :categoria", AlumnoDTO.class);
        List<AlumnoDTO> calificacion=query.setParameter("categoria", categoria).list();

        session.close();

        return calificacion;
    }

    @Override
    public List<Alumno> buscarByListaCategoria(List<String> categorias) {
        Session session = HibernateUtil.getSessionFactory().openSession();


        Query<Alumno> query = session.createQuery("from Alumno a where a.categoria in :categorias", Alumno.class);
        List<Alumno> alumnos = query.setParameterList("categorias", categorias).list();

        return alumnos;
    }

    @Override
    public Double notaMedia() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Double media = session.createQuery("select round(avg(a.nota),2) from Alumno a", Double.class).getSingleResult();

        session.close();

        return media;
    }

    @Override
    public Alumno updateById(Alumno alumno) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(alumno);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return alumno;
    }

    @Override
    public boolean deleteById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Alumno mueble = this.buscarById(id);
            if(mueble!=null){
                session.delete(mueble);
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

    @Override
    public Long totalAlumnos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Long> query= session.createQuery("select count(a) from Alumno a", Long.class);
        long contador= query.getSingleResult();
        System.out.println(contador);
        session.close();

        return contador;
    }
}
