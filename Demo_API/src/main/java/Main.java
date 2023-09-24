import Dominio.Persona;
import Utils.BDUtils;
import java.util.List;
import org.hibernate.*;
import javax.persistence.Query;
import io.javalin.Javalin;
import org.quartz.*;

public class Main {
    public static void main(String[] args) {
        //QUARTZ SCHEDULER
        /*SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 3 ? * SUN *")) // Todos los Domingos a las 03:00 am
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")) // Cada 1 minuto
                .build();

        JobDetail job = JobBuilder.newJob(MainJob.class)
                .withIdentity("job1", "group1")
                .build();

        scheduler.scheduleJob(job, trigger);*/

        //JAVALIN API + HIBERNATE DB
        Session session = BDUtils.getSessionFactory().getCurrentSession();

        var app = Javalin.create()
                .get("/insertarPersona", ctx -> {
                    Transaction txPersona = session.beginTransaction();
                    Query query3 = session.createSQLQuery("INSERT INTO persona VALUES (:valor1,:valor2)");
                    query3.setParameter("valor1", 1);
                    query3.setParameter("valor2", "Prueba");
                    query3.executeUpdate();
                    txPersona.commit();
                    ctx.result("Carga Completada");
                })
                .get("/obtenerPersonas", ctx -> {
                    Transaction txPersona = session.beginTransaction();
                    Query query = session.createQuery("FROM Persona", Persona.class);
                    List<Persona> personas = query.getResultList();
                    txPersona.commit();
                    ctx.json(personas);
                })
                .start(7070);
    }
}
