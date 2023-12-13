package persistencia;

import Dominio.Utils.BDUtils;
import Dominio.incidente.Incidente;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class RepoIncidente {

    public List<Incidente> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, observaciones, comunidad_id, servicio_idServicio, estado, usuarioApertura_id, usuarioCierre_id FROM incidente");
            List<Object[]> rows = query.getResultList();
            ArrayList<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente();
                incidente.setId( Long.parseLong(row[0].toString()));
                incidente.setObservaciones(row[1].toString());
                incidente.setComunidadId(Long.parseLong(row[2].toString()));
                incidente.setServicioId(Long.parseLong(row[3].toString()));
                if(Integer.parseInt(row[4].toString()) == 0) {
                    incidente.setEstado("ABIERTO");
                    incidente.setUsuarioAperturaId(Long.parseLong(row[5].toString()));
                } else {
                    incidente.setEstado("CERRADO");
                    incidente.setUsuarioAperturaId(Long.parseLong(row[5].toString()));
                    incidente.setUsuarioCierreId(Long.parseLong(row[6].toString()));
                }
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
    public static void abrirIncidente(Incidente incidente) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query  query = session.createSQLQuery("INSERT INTO incidente (id, comunidad_id, servicio_idServicio, observaciones, estado, usuarioApertura_id, tiempoFueraDeServicio) VALUES (:id,:comunidad,:servicio,:observaciones,:estado,:usuarioApertura, :tiempoFueraDeServicio)");
            query.setParameter("id", incidente.getId());
            query.setParameter("comunidad", incidente.getComunidadId());
            query.setParameter("servicio", incidente.getServicioId());
            query.setParameter("observaciones", incidente.getObservaciones());
            query.setParameter("estado", 0);
            query.setParameter("usuarioApertura", incidente.getUsuarioAperturaId());
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

    public static void cerrarIncidente(long idIncidente, long idUsuarioCierre) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("UPDATE incidente SET estado = :nuevoEstado, usuarioCierre_id = :usuarioCierre WHERE id = :id");
            query.setParameter("id", idIncidente);
            query.setParameter("nuevoEstado", 1);
            query.setParameter("usuarioCierre", idUsuarioCierre);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    public List<Incidente> obtenerCercanos(long idBuscado){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT incidente.id, incidente.comunidad_id, incidente.servicio_idServicio, incidente.usuarioApertura_id, incidente.observaciones FROM miembrocomunidad JOIN incidente ON miembrocomunidad.comunidad_id = incidente.comunidad_id WHERE miembrocomunidad.usuario_id = :idBuscado and incidente.estado = 'ABIERTO'");
            query.setParameter("idBuscado", idBuscado);
            List<Object[]> rows = query.getResultList();
            ArrayList<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente();
                        incidente.setId(Long.parseLong(row[0].toString()));
                        incidente.setComunidadId(Long.parseLong(row[1].toString()));
                        incidente.setServicioId(Long.parseLong(row[2].toString()));
                        incidente.setUsuarioAperturaId(Long.parseLong(row[3].toString()));
                        incidente.setObservaciones(row[4].toString());
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

}

