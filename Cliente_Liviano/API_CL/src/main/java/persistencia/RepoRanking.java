package persistencia;

import Dominio.Entidad;
import Dominio.Incidente;
import Dominio.Utils.BDUtils;
import Dominio.Utils.LocalDateTimeParser;
import Dominio.ranking.Informe;
import Dominio.ranking.InformePK;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepoRanking {

        public List<Informe> obtenerTodos(){
            Session session = BDUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            try {
                Query query = session.createSQLQuery("SELECT * FROM incidente");

                // datos que ncesito de la query * = PK.ranking, PK.fecha, PK.posicion, Entindad.id, Entidad.nombre, Entidad.email, Entidad.descripcion

                List<Object[]> rows = query.getResultList();
                ArrayList<Informe> informes = new ArrayList<>();
                for (Object[] row : rows) {
                    Informe informe = new Informe(
                            new InformePK(Long.parseLong(row[0].toString()), LocalDateTimeParser.parse(row[1].toString()), Integer.parseInt(row[2].toString())),
                            new Entidad(Long.parseLong(row[3].toString()),row[4].toString(),row[5].toString(),row[6].toString())
                    );
                    informes.add(informe);
                }
                tx.commit();
                return informes;
            } catch (Exception e) {
                tx.rollback();
                throw e;
            } finally {
                session.close();
            }
        }
}
