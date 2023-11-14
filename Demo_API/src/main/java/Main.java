import Dominio.Comunidad;
import Dominio.Entidad;
import Dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
                .get("/obtenerUsuarios", ctx -> {
                    MainApi mainApi = new MainApi();
                    List<Usuario> usuarios = mainApi.obtenerUsuarios();
                    ctx.json(usuarios);
                })
                .get("/obtenerUsuarios/{id}", ctx -> {
                    long id = Integer.parseInt(ctx.pathParam("id"));
                    MainApi mainApi = new MainApi();
                    Usuario usuario = mainApi.obtenerUsuario(id);
                    ctx.json(usuario);
                })
                .get("/obtenerComunidades", ctx -> {
                    MainApi mainApi = new MainApi();
                    ArrayList<Comunidad> comunidades = mainApi.obtenerComunidades();
                    ctx.json(comunidades);
                })
                .get("/obtenerComunidades/{id}", ctx -> {
                    long id = Integer.parseInt(ctx.pathParam("id"));
                    MainApi mainApi = new MainApi();
                    Comunidad comunidad = mainApi.obtenerComunidad(id);
                    ctx.json(comunidad);
                })
                .post("/almacenarIncidente", ctx -> {
                    String body = ctx.body();
                    System.out.println(body);
                    // Acá va la lógica de base de datos.
                })
                .start(7070);
    }
}
