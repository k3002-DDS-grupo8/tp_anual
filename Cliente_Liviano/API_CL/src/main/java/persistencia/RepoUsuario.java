package persistencia;
import Dominio.Utils.BDUtils;
import Dominio.comunidad.Comunidad;
import Dominio.comunidad.Usuario;
import Dominio.localizacion.Localizacion;
import Dominio.servicios.Servicios;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


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
                        row[0].toString(),
                        row[1].toString(),
                        row[2].toString(),
                        row[3].toString(),
                        (ArrayList<Servicios>) row[4],
                        (Localizacion) row[5],
                        (ArrayList<Comunidad>) row[6]

        // @AYUDA NO SE SI LOS ULTIMOS 3 ESTAN BIEN
        /*    String nombre,
        String email,
        String contrasenia,
        String telefono,
        ArrayList<Servicios> serviciosDeInteres,
        Localizacion localizacionActual,
        ArrayList<Comunidad> comunidades) {*/
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