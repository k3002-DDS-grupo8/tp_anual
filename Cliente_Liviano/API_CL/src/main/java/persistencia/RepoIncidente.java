package persistencia;

import Dominio.Incidente;
import Dominio.Utils.BDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.time.LocalDateTime;
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
}

