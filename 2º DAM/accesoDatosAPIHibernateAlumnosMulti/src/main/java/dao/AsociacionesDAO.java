package dao;

import entidades.Alumno;
import entidades.Asignatura;
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
    public List<Alumno> obtenerAlumnosCurso(Curso c) {
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
    public List<Asignatura> cursosAsignaturas(Curso c) {
        List<Asignatura> lista_asignaturas = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Curso> query = session.createQuery("select c from Curso c join fetch c.asignaturas where c.id =:id", Curso.class);
            query.setParameter("id", c.getId());
            lista_asignaturas = query.getSingleResult().getAsignaturas();

        } catch (NoResultException nre) {
            lista_asignaturas = new ArrayList<>();
        }catch(NullPointerException npe){
            return null;
        }
        session.close();

        return lista_asignaturas;
    }

    @Override
    public List<Curso> asignaturasCursos(Asignatura as) {
        List<Curso> lista_cursos = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Asignatura> query = session.createQuery("select a from Asignatura a join fetch a.cursos where a.id =:id", Asignatura.class);
            query.setParameter("id", as.getId());
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
    public boolean asignarAsignatura(Curso c, Asignatura as) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Curso> lista_cursos = asignaturasCursos(as);
            lista_cursos.add(c);
            as.setCursos(lista_cursos);

            List<Asignatura> lista_asignaturas = cursosAsignaturas(c);
            lista_asignaturas.add(as);
            c.setAsignaturas(lista_asignaturas);

            session.beginTransaction();

            session.update(c);
            session.update(as);
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
