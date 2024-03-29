package persistencia;

import Dominio.Utils.BDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import Dominio.entidad.EntidadPrestadora;

public class RepoEntidad {
    public List<EntidadPrestadora> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, nombre, email, descripcion FROM entidadprestadora");
            List<Object[]> rows = query.getResultList();
            ArrayList<EntidadPrestadora> entidades = new ArrayList<>();
            for (Object[] row : rows) {
                EntidadPrestadora entidad = new EntidadPrestadora(
                        Long.parseLong(row[0].toString()),
                        row[1].toString(),
                        row[2].toString(),
                        row[3].toString(),
                        0
                );
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

