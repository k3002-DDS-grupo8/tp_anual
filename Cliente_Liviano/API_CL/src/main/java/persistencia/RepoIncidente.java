package persistencia;

import Dominio.Utils.BDUtils;
import Dominio.incidente.EstadoIncidente;
import Dominio.incidente.Incidente;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class RepoIncidente {

    public List<Incidente> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT idComunidad, idServicio, idUsuarioApertura, observaciones FROM incidente");
            List<Object[]> rows = query.getResultList();
            ArrayList<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente(
                        Long.parseLong(row[0].toString()),
                        Long.parseLong(row[1].toString()),
                        Long.parseLong(row[2].toString()),
                        row[3].toString()

                );
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
    public static boolean abrirIncidente(long idComunidad, long idServicio, long idUsuarioApertura, String observaciones) {
        try {
            Session session = BDUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            org.hibernate.query.Query sqlQuery = session.createSQLQuery(String.format("INSERT INTO incidente VALUES SET idComunidad = '%s', idServicio = %s, idUsuarioApertura = %s, observaciones = %s)",
                    idComunidad,
                    idServicio,
                    idUsuarioApertura,
                    observaciones
            ));
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean cerrarIncidente(long idIncidente, long idUsuarioCierre) {
        try {
            Session session = BDUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            org.hibernate.query.Query sqlQuery = session.createSQLQuery(String.format("UPDATE incidente SET horarioDeCierre = '%s', idUsuarioCierre = '%s' WHERE id = '%s'",
                    LocalDateTime.now(),
                    idUsuarioCierre,
                    idIncidente
            ));
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Incidente> obtenerCercanos(long idBuscado){
        DateTimeFormatter formatoDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("select incidente.comunidad_id, incidente.servicio_idServicio, incidente.usuarioApertura_id incidente.observaciones, incidente.estado, incidente.horarioDeApertura, incidente.horarioDeCierre, incidente.usuarioCierre_id from MiembroComunidad join Comunidad on Comunidad.id = idComunidad join incidente on incidente.id = Comunidad.idIncidente where idUsuario = :idBuscado and incidente.estado = 0");
            query.setParameter("idBuscado", idBuscado);
            List<Object[]> rows = query.getResultList();
            ArrayList<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente(
                        Long.parseLong(row[0].toString()),
                        Long.parseLong(row[1].toString()),
                        Long.parseLong(row[2].toString()),
                        row[3].toString(),
                        (EstadoIncidente) row[4],
                        LocalDateTime.parse(row[5].toString(), formatoDateTime),
                        LocalDateTime.parse(row[6].toString(), formatoDateTime),
                        Long.parseLong(row[7].toString())
                );
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


// select idComunidad, idServicio, idUsuarioApertura, observaciones from MiembroComunidad
// join Comunidad on Comunidad.id = idComunidad
// join Incidente on Incidente.id = Comunidad.idIncidente
// where idUsuario = idBuscado and incidente.estado = 0
}

