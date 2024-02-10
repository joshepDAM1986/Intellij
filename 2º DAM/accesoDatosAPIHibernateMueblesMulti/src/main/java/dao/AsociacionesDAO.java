package dao;

import entidades.Cliente;
import entidades.Mueble;
import entidades.Proveedor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class AsociacionesDAO implements AsociacionesDAOInterface {

    @Override
    public boolean asignarProveedor(Mueble m, Proveedor p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            m.setProv(p);
            session.update(m);
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
    public Proveedor obtenerProvedorMueble(Mueble m) {
        Proveedor proveedor;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Mueble> query = session.createQuery("select m from Mueble m join fetch m.prov where m.id =:id", Mueble.class);
            query.setParameter("id", m.getId());
            proveedor = query.getSingleResult().getProv();

        } catch (NoResultException nre) {
            proveedor=null;
        }
        session.close();


        session.close();


        return proveedor;
    }

    @Override
    public List<Mueble> mueblesProveedor(Proveedor p) {
        List<Mueble> lista_muebles;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Proveedor> query = session.createQuery("select p from Proveedor p join fetch p.almacen  where p.id =:id", Proveedor.class);
            query.setParameter("id", p.getId());
            lista_muebles = query.getSingleResult().getAlmacen();
        } catch (NoResultException nre) {
            lista_muebles = new ArrayList<>();
        }

        session.close();

        return lista_muebles;
    }

    @Override
    public List<Cliente> clientesConMueble(Mueble m) {
        List<Cliente> lista_clientes = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Mueble> query = session.createQuery("select m from Mueble m join fetch m.clientes where m.id =:id", Mueble.class);
            query.setParameter("id", m.getId());
            lista_clientes = query.getSingleResult().getClientes();

        } catch (NoResultException nre) {
            lista_clientes = new ArrayList<>();
        }
        session.close();

        return lista_clientes;
    }

    @Override
    public List<Mueble> mueblesComprados(Cliente c) {
        List<Mueble> lista_muebles = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Cliente> query = session.createQuery("select c from Cliente c join fetch c.muebles where c.id =:id", Cliente.class);
            query.setParameter("id", c.getId());
            lista_muebles = query.getSingleResult().getMuebles();
        } catch (NoResultException nre) {
            lista_muebles = new ArrayList<>();
        }

        session.close();
        return lista_muebles;
    }

    @Override
    public boolean comprarMueble(Mueble m, Cliente c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            List<Mueble> lista_muebles = mueblesComprados(c);
            lista_muebles.add(m);
            c.setMuebles(lista_muebles);

            List<Cliente> lista_clientes = clientesConMueble(m);
            lista_clientes.add(c);
            m.setClientes(lista_clientes);

            session.beginTransaction();

            session.update(m);
            session.update(c);
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
