import Utils.BDUtils;
import Dominio.Persona;
import java.util.List;
import java.util.Random;
import org.hibernate.*;
import javax.persistence.Query;
public class MainApi {
    public void insertPersona() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction txPersona = session.beginTransaction();
        try {
            Query query3 = session.createSQLQuery("INSERT INTO persona VALUES (:valor1,:valor2)");
            Random random = new Random();
            query3.setParameter("valor1", random.nextInt());
            query3.setParameter("valor2", "Prueba");
            query3.executeUpdate();
            txPersona.commit();
        } catch (Exception e) {
            txPersona.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Persona> obtenerPersonas() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction txPersona = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, Nombre FROM persona");
            List<Persona> personas = query.getResultList();
            txPersona.commit();
            return personas;
        } catch (Exception e) {
            txPersona.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}