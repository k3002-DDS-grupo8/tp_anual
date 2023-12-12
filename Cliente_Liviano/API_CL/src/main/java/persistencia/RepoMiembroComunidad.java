package persistencia;

import Dominio.Utils.BDUtils;
import Dominio.comunidad.MiembroComunidad;
import Dominio.comunidad.TipoUsuario;
import Dominio.comunidad.UsuarioPersona;
import Dominio.comunidad.Comunidad;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepoMiembroComunidad {

    public ArrayList<MiembroComunidad> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT * FROM miembroComunidad");
            List<Object[]> rows = query.getResultList();
            ArrayList<MiembroComunidad> miembroComunidades = new ArrayList<>();

            for (Object[] row : rows) {
                MiembroComunidad miembroComunidad = new MiembroComunidad(
                        Long.parseLong(row[0].toString()),
                        (UsuarioPersona) row[1],
                        (Comunidad) row[2],
                        (Optional<TipoUsuario>) row[3]
                );
                miembroComunidades.add(miembroComunidad);
            }
            tx.commit();
            return miembroComunidades;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
