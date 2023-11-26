package persistencia;

import Dominio.Entidad;
import Dominio.Usuario;
import Dominio.Utils.BDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RepoEntidad {
    public List<Entidad> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT * FROM entidad");
            List<Object[]> rows = query.getResultList();
            ArrayList<Entidad> entidades = new ArrayList<>();
            for (Object[] row : rows) {
                Entidad entidad = new Entidad(
                        Long.parseLong(row[0].toString()),
                        row[1].toString(),
                        row[2].toString(),
                        row[3].toString()
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

//long id, String nombre, String email, String descripcion