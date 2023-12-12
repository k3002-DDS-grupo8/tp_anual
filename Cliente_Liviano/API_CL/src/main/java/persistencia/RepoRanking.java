package persistencia;


import Dominio.Entidad;
import Dominio.Utils.BDUtils;
import Dominio.Utils.LocalDateTimeParser;
import Dominio.ranking.Informe;
import Dominio.ranking.InformePK;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RepoRanking {

    public ArrayList<Informe> obtenerRankingEntidades(long idRanking) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT ranking.detalle, informe.fecha, informe.posicion, informe.entidad_id, entidadprestadora.nombre FROM ranking JOIN informe ON ranking.id = informe.ranking JOIN entidadprestadora ON informe.entidad_id = entidadprestadora.id WHERE ranking.id = :idRanking"); //Podría poner "AND informe.fecha = '2023-01-01 00:00:00'" (es un ejemplo) pero no lo necesito pq solo tengo datos de prueba de 1 fecha jaja salu2
            query.setParameter("idRanking", idRanking);
            List<Object[]> rows = query.getResultList();
            ArrayList<Informe> informeEntidades = new ArrayList<>();
            for (Object[] row : rows) {
                Informe informeRenglon = new Informe();
                informeRenglon.setRanking_detalle(row[0].toString());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                LocalDateTime fechaLocalDateTime = LocalDateTime.parse(row[1].toString(), formatter);
                informeRenglon.setFecha(fechaLocalDateTime);
                informeRenglon.setPosicion(Integer.parseInt(row[2].toString()));
                informeRenglon.setEntidad_id(Long.parseLong(row[3].toString()));
                informeRenglon.setEntidad_nombre(row[4].toString());

                informeEntidades.add(informeRenglon);
            }
            tx.commit();
            return informeEntidades;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}

