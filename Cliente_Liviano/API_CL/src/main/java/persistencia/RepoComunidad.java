package persistencia;

import Dominio.Utils.BDUtils;
import Dominio.comunidad.Comunidad;
import Dominio.comunidad.GradoConfianza;
import Dominio.comunidad.MiembroComunidad;
import Dominio.comunidad.Usuario;
import Dominio.incidente.Incidente;
import Dominio.localizacion.Localizacion;
import Dominio.servicios.Servicio;
import Dominio.servicios.Servicios;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RepoComunidad {

    public List<Comunidad> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT * FROM Comunidad c");
            List<Object[]> rows = query.getResultList();
            ArrayList<Comunidad> comunidades = new ArrayList<>();

            for (Object[] row : rows) {
                Comunidad comunidad = new Comunidad(
                        row[0].toString(),
                        (ArrayList<MiembroComunidad>) row[1],
                        (ArrayList<Servicios>) row[2],
                        (ArrayList<Incidente>) row[3],
                        (GradoConfianza) row[4],
                        (Boolean) row[5]
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
