import Utils.BDUtils;
import Dominio.Usuario;
import Dominio.Comunidad;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.*;

import javax.persistence.NoResultException;
import javax.persistence.Query;
public class MainApi {
    /*public void insertPersona() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction txPersona = session.beginTransaction();
        try {
            Query query3 = session.createSQLQuery("INSERT INTO persona VALUES (:valor1,:valor2)");
            Random random = new Random();
            query3.setParameter("valor1", random.nextInt());
            query3.setParameter("valor2", "Prueba");
            query3.executeUpdate();
            txPersona.commit();
        } catch (Exception e) {
            txPersona.rollback();
            throw e;
        } finally {
            session.close();
        }
    }*/

    public List<Usuario> obtenerUsuarios() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, puntosConfianza, gradoConfianza, activo FROM usuario");
            List<Object[]> rows = query.getResultList();
            List<Usuario> usuarios = new ArrayList<>();
            for (Object[] row : rows) {
                Usuario usuario = new Usuario();
                usuario.setId(Long.parseLong(row[0].toString()));
                usuario.setPuntosConfianza(Float.parseFloat(row[1].toString()));
                usuario.setGradoConfianza(row[2].toString());
                usuario.setActivo(Boolean.parseBoolean(row[3].toString()));
                usuarios.add(usuario);
            }
            tx.commit();
            return usuarios;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Usuario obtenerUsuario(long id) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, puntosConfianza, gradoConfianza, activo FROM usuario WHERE id = :id");
            query.setParameter("id", id);
            Object[] row = (Object[]) query.getSingleResult();
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setPuntosConfianza(Float.parseFloat(row[1].toString()));
            usuario.setGradoConfianza(row[2].toString());
            usuario.setActivo(Boolean.parseBoolean(row[3].toString()));
            tx.commit();
            return usuario;
        } catch (NoResultException e) {
            tx.rollback();
            throw new RuntimeException("No se encontró ningun usuario con el ID especificado: " + id);
        } finally {
            session.close();
        }
    }

    public List<Comunidad> obtenerComunidades() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, puntosConfianza, gradoConfianza, activo FROM comunidad");
            List<Object[]> rows = query.getResultList();
            List<Comunidad> comunidades = new ArrayList<>();
            for (Object[] row : rows) {
                Comunidad comunidad = new Comunidad();
                comunidad.setId(Long.parseLong(row[0].toString()));
                comunidad.setPuntosConfianza(Float.parseFloat(row[1].toString()));
                comunidad.setGradoConfianza(row[2].toString());
                comunidad.setActivo(Boolean.parseBoolean(row[3].toString()));
                comunidades.add(comunidad);
            }
            tx.commit();
            return comunidades;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Comunidad obtenerComunidad(long id) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, puntosConfianza, gradoConfianza, activo FROM comunidad WHERE id = :id");
            query.setParameter("id", id);
            Object[] row = (Object[]) query.getSingleResult();
            Comunidad comunidad = new Comunidad();
            comunidad.setId(id);
            comunidad.setPuntosConfianza(Float.parseFloat(row[1].toString()));
            comunidad.setGradoConfianza(row[2].toString());
            comunidad.setActivo(Boolean.parseBoolean(row[3].toString()));
            tx.commit();
            return comunidad;
        } catch (NoResultException e) {
            tx.rollback();
            throw new RuntimeException("No se encontró ninguna comunidad con el ID especificado: " + id);
        } finally {
            session.close();
        }
    }

}