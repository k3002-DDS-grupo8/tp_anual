package persistencia;

import Dominio.Comunidad;
import Dominio.Usuario;
import Dominio.Utils.BDUtils;
import Dominio.comunidad.GradoConfianza;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RepoComunidad {

    public List<Comunidad> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT c.nombre FROM Comunidad c");
            List<Object[]> rows = query.getResultList();
            ArrayList<Comunidad> comunidades = new ArrayList<>();

            for (Object[] row : rows) {
                Comunidad comunidad = new Comunidad(
                        Long.parseLong(row[0].toString()),
                        (List<Long>) row[1],
                        (GradoConfianza) row[2],
                        (Boolean) row[3]
                );
                comunidades.add(comunidad);
            }
            tx.commit();
            return comunidades;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}

  //  long id, ArrayList<Long> usuariosIDs, GradoConfianza gradoConfianza, boolean activo
