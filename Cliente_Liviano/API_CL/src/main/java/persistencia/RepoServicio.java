package persistencia;

import Dominio.Utils.BDUtils;
import Dominio.incidente.Incidente;
import Dominio.servicios.Servicio;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepoServicio {

    public Servicio obtenerTodos(){
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT idServicio, nombre, idEstablecimiento, idIncidente FROM servicio");
            Servicio servicio= (Servicio) query.getSingleResult();


            // falta completar los datos que el camino para la localizacion

            // OOOO lo harcodeamos


            tx.commit();
            return servicio;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
