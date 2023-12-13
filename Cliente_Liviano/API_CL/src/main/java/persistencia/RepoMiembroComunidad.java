package persistencia;

import Dominio.Utils.BDUtils;
import Dominio.comunidad.MiembroComunidad;
import Dominio.comunidad.TipoUsuario;
import Dominio.comunidad.Comunidad;
import Dominio.comunidad.Usuario;
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
            Query query = session.createSQLQuery("SELECT usuario_id, comunidad_id FROM miembroComunidad");
            List<Object[]> rows = query.getResultList();
            ArrayList<MiembroComunidad> miembroComunidades = new ArrayList<>();

            for (Object[] row : rows) {
                MiembroComunidad miembroComunidad = new MiembroComunidad(
                        Long.parseLong(row[0].toString()),
                        Long.parseLong(row[1].toString())
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
