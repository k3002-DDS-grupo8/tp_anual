import Utils.BDUtils;
import Dominio.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.*;
import javax.persistence.Query;

public class MainApi {
    public ArrayList<Entidad> obtenerEntidades() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, nombre, email, descripcion FROM entidadprestadora");
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
            Query  query = session.createSQLQuery("INSERT INTO entidadprestadora (id, nombre, descripcion, email) VALUES (:id,:nombre,:descripcion,:email)");
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
            Query query = session.createSQLQuery("SELECT comunidad_id, servicio_idServicio, estado, id FROM incidente WHERE comunidad = :idComunidad");
            query.setParameter("idComunidad", idComunidad);
            List<Object[]> rows = query.getResultList();
            ArrayList<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente();
                incidente.setIdComunidad(Long.parseLong(row[0].toString()));
                incidente.setIdServicio(Long.parseLong(row[1].toString()));
                if(Integer.parseInt(row[2].toString()) == 0) {
                    incidente.setEstado("ABIERTO");
                } else {
                    incidente.setEstado("CERRADO");
                }
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
            Query  query = session.createSQLQuery("INSERT INTO incidente (id, comunidad_id, servicio_idServicio, observaciones, estado, usuarioApertura_id, tiempoFueraDeServicio) VALUES (:id,:comunidad,:servicio,:observaciones,:estado,:usuarioApertura, :tiempoFueraDeServicio)");
            query.setParameter("id", incidente.getId());
            query.setParameter("comunidad", incidente.getIdComunidad());
            query.setParameter("servicio", incidente.getIdServicio());
            query.setParameter("observaciones", incidente.getObservaciones());
            query.setParameter("estado", 0);
            query.setParameter("usuarioApertura", incidente.getIdUsuarioApertura());
            query.setParameter("tiempoFueraDeServicio", 0);
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
            Query query = session.createSQLQuery("UPDATE incidente SET estado = :nuevoEstado, usuarioCierre_id = :usuarioCierre WHERE id = :id");
            query.setParameter("id", id);
            query.setParameter("nuevoEstado", 1);
            query.setParameter("usuarioCierre", usuarioCierre);
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
            Query query = session.createSQLQuery("SELECT id, nombre FROM tipousuario");
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
            Query  query = session.createSQLQuery("INSERT INTO tipousuario (id, nombre) VALUES (:id,:nombre)");
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
            Query query = session.createSQLQuery("DELETE FROM tipousuario WHERE id = :id");
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

    public ArrayList<Informe> obtenerRankingEntidades(long idRanking) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT ranking.detalle, informe.fecha, informe.posicion, informe.entidad_id, entidadprestadora.nombre FROM ranking JOIN informe ON ranking.id = informe.ranking JOIN entidadprestadora ON informe.entidad_id = entidadprestadora.id WHERE ranking.id = :idRanking"); //Podría poner "AND informe.fecha = '2023-01-01 00:00:00'" (es un ejemplo) pero no lo necesito pq solo tengo datos de prueba de 1 fecha jaja salu2
            query.setParameter("idRanking", idRanking);
            List<Object[]> rows = query.getResultList();
            ArrayList<Informe> informeEntidades = new ArrayList<>();
            for (Object[] row : rows) {
                Informe informeRenglon = new Informe();
                informeRenglon.setRanking_detalle(row[0].toString());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                LocalDateTime fechaLocalDateTime = LocalDateTime.parse(row[1].toString(), formatter);
                informeRenglon.setFecha(fechaLocalDateTime);
                informeRenglon.setPosicion(Integer.parseInt(row[2].toString()));
                informeRenglon.setEntidad_id(Long.parseLong(row[3].toString()));
                informeRenglon.setEntidad_nombre(row[4].toString());

                informeEntidades.add(informeRenglon);
            }
            tx.commit();
            return informeEntidades;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
