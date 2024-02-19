package dao;

import entidades.Academia;
import entidades.Alumno;
import entidades.Curso;
import entidades.Profesor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class AsociacionesDAO implements AsociacionesDAOInterface {
    @Override
    public boolean asignarCurso(Alumno a, Curso c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            a.setCurso(c);
            session.update(a);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        session.close();
        return true;
    }

    @Override
    public Curso obtenercursoAlumno(Alumno a) {
        Curso curso;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Alumno> query = session.createQuery("select a from Alumno a join fetch a.curso where a.id =:id", Alumno.class);
            query.setParameter("id", a.getId());
            curso = query.getSingleResult().getCurso();

        } catch (NoResultException nre) {
            curso=null;
        }catch(NullPointerException npe){
            return null;
        }
        session.close();

        return curso;
    }

    @Override
    public List<Alumno> alumnosCurso(Curso c) {
        List<Alumno> lista_alumnos;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Curso> query = session.createQuery("select c from Curso c join fetch c.registroCurso where c.id =:id", Curso.class);
            query.setParameter("id", c.getId());
            lista_alumnos = query.getSingleResult().getRegistroCurso();
        } catch (NoResultException nre) {
            lista_alumnos = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }
        session.close();
        return lista_alumnos;
    }

    @Override
    public boolean asignarProfesor(Alumno a, Profesor p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Alumno> lista_alumnos = profesoresConAlumnos(p);
            lista_alumnos.add(a);
            p.setAlumnos(lista_alumnos);

            List<Profesor> lista_profesores = alumnosConProfesor(a);
            lista_profesores.add(p);
            a.setProfesores(lista_profesores);

            session.beginTransaction();

            session.update(a);
            session.update(p);
            session.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        session.close();
        return true;
    }

    @Override
    public List<Profesor> alumnosConProfesor(Alumno a) {
        List<Profesor> lista_profesores = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Alumno> query = session.createQuery("select a from Alumno a join fetch a.profesores where a.id =:id", Alumno.class);
            query.setParameter("id", a.getId());
            lista_profesores = query.getSingleResult().getProfesores();

        } catch (NoResultException nre) {
            lista_profesores = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }
        session.close();

        return lista_profesores;
    }

    @Override
    public List<Alumno> profesoresConAlumnos(Profesor p) {
        List<Alumno> lista_alumnos = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Profesor> query = session.createQuery("select p from Profesor p join fetch p.alumnos where p.id =:id", Profesor.class);
            query.setParameter("id", p.getId());
            lista_alumnos = query.getSingleResult().getAlumnos();
        } catch (NoResultException nre) {
            lista_alumnos = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }

        session.close();
        return lista_alumnos;
    }

    @Override
    public Academia obtenerAcademiaAlumno(Alumno a) {
        Academia academia;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Alumno> query = session.createQuery("select a from Alumno a join fetch a.academia where a.id =:id", Alumno.class);
            query.setParameter("id", a.getId());
            academia = query.getSingleResult().getAcademia();

        } catch (NoResultException nre) {
            academia=null;
        }catch(NullPointerException npe){
            return null;
        }
        session.close();

        return academia;
    }

    @Override
    public List<Alumno> alumnosAcademia(Academia ac) {
        List<Alumno> lista_alumnos;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Academia> query = session.createQuery("select ac from Academia ac join fetch ac.registroAcademia where ac.id =:id", Academia.class);
            query.setParameter("id", ac.getId());
            lista_alumnos = query.getSingleResult().getRegistroAcademia();
        } catch (NoResultException nre) {
            lista_alumnos = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }
        session.close();
        return lista_alumnos;
    }

    @Override
    public boolean asignarAcademiaAlumno(Alumno a, Academia ac) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            a.setAcademia(ac);
            session.update(a);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        session.close();
        return true;
    }

    @Override
    public List<Academia> cursosConAcademias(Curso c) {
        List<Academia> lista_academias = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Curso> query = session.createQuery("select c from Curso c join fetch c.academias where c.id =:id", Curso.class);
            query.setParameter("id", c.getId());
            lista_academias = query.getSingleResult().getAcademias();

        } catch (NoResultException nre) {
            lista_academias = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }
        session.close();
        return lista_academias;
    }

    @Override
    public List<Curso> academiasConCursos(Academia ac) {
        List<Curso> lista_cursos = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Academia> query = session.createQuery("select ac from Academia ac join fetch ac.cursos where ac.id =:id", Academia.class);
            query.setParameter("id", ac.getId());
            lista_cursos = query.getSingleResult().getCursos();
        } catch (NoResultException nre) {
            lista_cursos = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }
        session.close();
        return lista_cursos;
    }
    @Override
    public boolean asignarAcademiaCurso(Curso c, Academia ac) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Curso> lista_cursos = academiasConCursos(ac);
            lista_cursos.add(c);
            ac.setCursos(lista_cursos);

            List<Academia> lista_academias = cursosConAcademias(c);
            lista_academias.add(ac);
            c.setAcademias(lista_academias);

            session.beginTransaction();

            session.update(c);
            session.update(ac);
            session.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        session.close();
        return true;
    }
    @Override
    public List<Academia> profesoresConAcademias(Profesor p) {
        List<Academia> lista_academias = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Profesor> query = session.createQuery("select p from Profesor p join fetch p.academias where p.id =:id", Profesor.class);
            query.setParameter("id", p.getId());
            lista_academias = query.getSingleResult().getAcademias();

        } catch (NoResultException nre) {
            lista_academias = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }
        session.close();
        return lista_academias;
    }

    @Override
    public List<Profesor> academiasConProfesores(Academia ac) {
        List<Profesor> lista_profesores = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Academia> query = session.createQuery("select ac from Academia ac join fetch ac.profesores where ac.id =:id", Academia.class);
            query.setParameter("id", ac.getId());
            lista_profesores = query.getSingleResult().getProfesores();
        } catch (NoResultException nre) {
            lista_profesores = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }
        session.close();
        return lista_profesores;
    }

    @Override
    public boolean asignarAcademiaProfesores(Profesor p, Academia ac) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Profesor> lista_profesores = academiasConProfesores(ac);
            lista_profesores.add(p);
            ac.setProfesores(lista_profesores);

            List<Academia> lista_academias = profesoresConAcademias(p);
            lista_academias.add(ac);
            p.setAcademias(lista_academias);

            session.beginTransaction();

            session.update(p);
            session.update(ac);
            session.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        session.close();
        return true;
    }
}
