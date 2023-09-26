import Dominio.Persona;
import java.util.List;
import io.javalin.Javalin;
import org.quartz.*;

public class Main {
    public static void main(String[] args) throws SchedulerException {
        //QUARTZ SCHEDULER
        SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
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
        scheduler.scheduleJob(job, trigger);

        //JAVALIN API
        var app = Javalin.create()
                .get("/insertarPersona", ctx -> {
                    MainApi mainApi = new MainApi();
                    mainApi.insertPersona();
                    ctx.result("Carga Completada");
                })
                .get("/obtenerPersonas", ctx -> {
                    MainApi mainApi = new MainApi();
                    List<Persona> personas = mainApi.obtenerPersonas();
                    ctx.json(personas);
                })
                .start(7070);
    }
}
