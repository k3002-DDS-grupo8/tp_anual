package persistencia;

import Dominio.Utils.BDUtils;
import Dominio.comunidad.Comunidad;
import Dominio.comunidad.MiembroComunidad;
import Dominio.incidente.Incidente;
import Dominio.servicios.Servicios;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RepoComunidad {

    public ArrayList<Comunidad> obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, nombre, activo FROM Comunidad");
            List<Object[]> rows = query.getResultList();
            ArrayList<Comunidad> comunidades = new ArrayList<>();

            for (Object[] row : rows) {
                Comunidad comunidad = new Comunidad(
                        Long.parseLong(row[0].toString()),
                        row[1].toString(),
                        Boolean.parseBoolean(row[2].toString())
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


