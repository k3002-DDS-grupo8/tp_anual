import Dominio.Utils.BDUtils;
import Presentacion.GetUsuariosHandler;
import Presentacion.GetUsuarioIdHandler;
import Presentacion.GetComunidadesHandler;
import Presentacion.GetComunidadIdHandler;
import Presentacion.GetIncidenteIdComunidadHandler;
import Presentacion.GetIncidenteIdComunidadAbiertoHandler;
import Presentacion.GetIncidenteIdComunidadCerradoHandler;
import Presentacion.GetEntidadesHandler;
import Presentacion.PostCierreIdIncidenteHandler;
import Presentacion.PostInsertarTipoUsuarioHandler;
import Presentacion.PostAperturaIncidenteHandler;
import Presentacion.PostEliminarTipoUsuarioHandler;
import Presentacion.GetObtenerRankingEntidadesHandler;


import io.javalin.Javalin;
import org.quartz.*;

import javax.persistence.EntityManager;

public class Application {
    public static void main(String[] args) throws SchedulerException {

                Javalin app = Javalin.create(config -> {

                config.plugins.enableCors(cors -> {
                    cors.add(corsConfig -> {
                        corsConfig.anyHost();
                    });
                });

                }).start(7070);

               app.get("/api", ctx -> {
                    System.out.printf("hola");

                   ctx.result("Hello");
               });
            
               app.get("/api/obtenerUsuarios", ctx ->{
                   GetUsuariosHandler handlerUsuario = new GetUsuariosHandler();
                   handlerUsuario.handle(ctx);
               });
            
                app.get("/api/obtenerUsuarios/{id}", new GetUsuarioIdHandler());
            
                app.get("/api/obtenerComunidades", new GetComunidadesHandler());

                app.get("/api/obtenerComunidades/{id}", ctx -> new GetComunidadIdHandler());

                app.post("/api/aperturaIncidente", ctx -> new PostAperturaIncidenteHandler());

                app.get("/api/obtenerIncidentesComunidad/{idComunidad}", new GetIncidenteIdComunidadHandler());

                app.get("/api/obtenerIncidentesComunidadAbierto/{idComunidad}", ctx -> new GetIncidenteIdComunidadAbiertoHandler());
                
                app.get("/api/obtenerIncidentesComunidadCerrado/{idComunidad}", ctx -> new GetIncidenteIdComunidadCerradoHandler());

                app.get("/api/obtenerEntidades", ctx -> new GetEntidadesHandler());
                      
                app.post("/api/cierreIncidente/{idIncidente}", new PostCierreIdIncidenteHandler());

                app.post("/api/insertarTipoUsuario", ctx -> new PostInsertarTipoUsuarioHandler());
                      
                app.get("/api/eliminarTipoUsuario", ctx -> new PostEliminarTipoUsuarioHandler());
                      
                app.get("/api/obtenerRankingEntidades", ctx -> new GetObtenerRankingEntidadesHandler());
    }

}
