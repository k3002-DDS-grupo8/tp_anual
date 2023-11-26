package persistencia;

import Dominio.Incidente;
import Dominio.Utils.BDUtils;
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
            Query query = session.createSQLQuery("SELECT * FROM incidente");
            List<Object[]> rows = query.getResultList();
            ArrayList<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente(
                        Long.parseLong(row[0].toString()),
                        Long.parseLong(row[1].toString()),
                        Long.parseLong(row[2].toString())
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
}

//long idComunidad, long idServicio, long idUsuarioApertura