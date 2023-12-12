package persistencia;

import Dominio.Utils.BDUtils;
import Dominio.comunidad.EEO;
import Dominio.entidad.Establecimiento;
import Dominio.localizacion.Localizacion;
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
            Query query = session.createSQLQuery("SELECT * FROM entidad");
            List<Object[]> rows = query.getResultList();
            ArrayList<EntidadPrestadora> entidades = new ArrayList<>();
            for (Object[] row : rows) {
                EntidadPrestadora entidad = new EntidadPrestadora(
                        row[0].toString(),
                        (List<Establecimiento>) row[1],
                        (ArrayList<Localizacion>) row[2],
                        (EEO) row[3]
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

