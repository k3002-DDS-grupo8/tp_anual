import Utils.BDUtils;
import Dominio.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.*;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class MainApi {
    public ArrayList<Entidad> obtenerEntidades() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT  id, nombre, email, descripcion FROM entidad");
            List<Object[]> rows = query.getResultList();
            ArrayList<Entidad> entidades = new ArrayList<>();
            for (Object[] row : rows) {
                Entidad entidad = new Entidad();
                entidad.setId(Long.parseLong(row[0].toString()));
                entidad.setNombre(row[1].toString());
                entidad.setEmail(row[2].toString());
                entidad.setDescripcion(row[3].toString());
                entidades.add(entidad);
            }
            tx.commit();
            return entidades;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void insertarEntidad(Entidad entidad) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query  query = session.createSQLQuery("INSERT INTO entidad VALUES (:id,:nombre,:descripcion,:email)");
            query.setParameter("id", entidad.getId());
            query.setParameter("nombre", entidad.getNombre());
            query.setParameter("descripcion", entidad.getDescripcion());
            query.setParameter("email", entidad.getEmail());
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public ArrayList<Incidente> obtenerIncidentesComunidad(long idComunidad) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT comunidad, servicio, estado, id FROM incidente WHERE comunidad = :idComunidad");
            query.setParameter("idComunidad", idComunidad);
            List<Object[]> rows = query.getResultList();
            ArrayList<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente();
                incidente.setIdComunidad(Long.parseLong(row[0].toString()));
                incidente.setIdServicio(Long.parseLong(row[1].toString()));
                incidente.setEstado(EstadoIncidente.valueOf(row[2].toString()));
                incidente.setId(Long.parseLong(row[3].toString()));
                incidentes.add(incidente);
            }
            tx.commit();
            return incidentes;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void abrirIncidente(Incidente incidente) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query  query = session.createSQLQuery("INSERT INTO incidente VALUES (:id,:comunidad,:servicio,:detalle,:estado,:usuarioApertura)");
            query.setParameter("id", incidente.getId());
            query.setParameter("comunidad", incidente.getIdComunidad());
            query.setParameter("servicio", incidente.getIdServicio());
            query.setParameter("detalle", incidente.getObservaciones());
            query.setParameter("estado", incidente.getEstado());
            query.setParameter("usuarioApertura", incidente.getIdUsuarioApertura());
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void cerrarIncidente(Long id, Long usuarioCierre) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("UPDATE incidente SET estado = :nuevoEstado, idUsuarioCierre = :usuarioCierre WHERE id = :id");
            query.setParameter("id", id);
            query.setParameter("nuevoEstado", EstadoIncidente.CERRADO);
            query.setParameter("idUsuarioCierre", usuarioCierre);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public ArrayList<TipoUsuario> obtenerTiposUsuario() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT  id, nombre FROM tipoUsuario");
            List<Object[]> rows = query.getResultList();
            ArrayList<TipoUsuario> tiposUsuario = new ArrayList<>();
            for (Object[] row : rows) {
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setId(Long.parseLong(row[0].toString()));
                tipoUsuario.setNombre(row[1].toString());
                tiposUsuario.add(tipoUsuario);
            }
            tx.commit();
            return tiposUsuario;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void insertarTipoUsuario(long id, String nombre) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query  query = session.createSQLQuery("INSERT INTO tipoUsuario VALUES (:id,:nombre)");
            query.setParameter("id", id);
            query.setParameter("nombre", nombre);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void eliminarTipoUsuario(long id) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("DELETE FROM tipoUsuario WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public ArrayList<Entidad> obtenerRankingEntidades(long idRanking) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id_entidad, nombre_entidad FROM ranking JOIN entidad ON id_entidad = id WHERE id_ranking = :idRanking");
            List<Object[]> rows = query.getResultList();
            ArrayList<Entidad> entidades = new ArrayList<>();
            for (Object[] row : rows) {
                Entidad entidad = new Entidad();
                entidad.setId(Long.parseLong(row[0].toString()));
                entidad.setNombre(row[1].toString());
                entidades.add(entidad);
            }
            tx.commit();
            return entidades;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
