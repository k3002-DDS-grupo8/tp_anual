package persistencia;
import Dominio.Usuario;
import Dominio.Utils.BDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public class RepoUsuario {

    public List<Usuario> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT * FROM usuario");
            List<Object[]> rows = query.getResultList();
            ArrayList<Usuario> usuarios = new ArrayList<>();
            for (Object[] row : rows) {
                Usuario usuario = new Usuario(
                        Long.parseLong(row[0].toString()),
                        Float.parseFloat(row[1].toString()),
                        Boolean.parseBoolean(row[2].toString()),
                        row[3].toString(),
                        row[4].toString(),
                        row[4].toString()
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
//long id, float puntosConfianza, /*GradoConfianza gradoConfianza,*/ boolean activo, String nombre, String email, String contrasenia