package persistencia;

import Dominio.Incidente;
import Dominio.Utils.BDUtils;
import Dominio.ranking.RepositorioRankings;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RepoRanking {
        public List<RepositorioRankings> obtenerTodos(){
            Session session = BDUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            try {
                Query query = session.createSQLQuery("SELECT * FROM incidente");
                List<Object[]> rows = query.getResultList();
                ArrayList<RepositorioRankings> repoRanking = new ArrayList<>();
                for (Object[] row : rows) {
                    Incidente ranking = new RepositorioRankings(
                            Long.parseLong(row[0].toString()),
                            Long.parseLong(row[1].toString())
                    );
                    repoRanking.add(ranking);
                }
                tx.commit();
                return repoRanking;
            } catch (Exception e) {
                tx.rollback();
                throw e;
            } finally {
                session.close();
            }
        }
}
