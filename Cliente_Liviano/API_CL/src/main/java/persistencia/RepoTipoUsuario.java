package persistencia;

import Dominio.comunidad.TipoUsuario;
import Dominio.Usuario;
import Dominio.Utils.BDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepoTipoUsuario {
    public List<TipoUsuario> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT t.id, t.nombre FROM TipoUsuario t");
            List<Object[]> rows = query.getResultList();
            ArrayList<TipoUsuario> tiposUsuarios = new ArrayList<>();
            for (Object[] row : rows) {
                TipoUsuario tipoUsuario = new TipoUsuario(
                        Long.parseLong(row[0].toString()),
                        row[1].toString()
                );
                tiposUsuarios.add(tipoUsuario);
            }
            tx.commit();
            return tiposUsuarios;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
