package Dominio.persistencia;
import Dominio.Incidente;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class RepoIncidente {

    public List<Incidente> obtenerIncidentes() {
        Session session = Utils.BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT comunidad, servicio, horarioDeApertura, horarioDeCierre, id FROM incidente");
            List<Object[]> rows = query.getResultList();
            List<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente();
                incidente.setIdComunidad(Long.parseLong(row[0].toString()));
                incidente.setIdServicio(Long.parseLong(row[1].toString()));
                incidente.setHorarioDeApertura(LocalDateTime.parse(row[2].toString()));
                incidente.setHorarioDeCierre(LocalDateTime.parse(row[3].toString()));
                incidente.setId(Long.parseLong(row[4].toString()));
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
