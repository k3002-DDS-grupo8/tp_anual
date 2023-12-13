package persistencia;
import Dominio.Utils.BDUtils;
import Dominio.comunidad.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class RepoUsuario {

    public ArrayList<Usuario> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, email, nombre, contrasenia FROM usuario");
            List<Object[]> rows = query.getResultList();
            ArrayList<Usuario> usuarios = new ArrayList<>();
            for (Object[] row : rows) {
                Usuario usuario = new Usuario(
                        Long.parseLong(row[0].toString()),
                        row[1].toString(),
                        row[2].toString(),
                        row[3].toString()
                );
                usuarios.add(usuario);
            }
            tx.commit();
            return usuarios;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}