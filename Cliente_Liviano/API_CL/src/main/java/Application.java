import Dominio.Utils.BDUtils;
import Presentacion.*;


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


               app.get("/api/login", ctx -> {
                   LoginHandler login = new LoginHandler();
                   login.handle(ctx);
               });
            
               app.get("/api/obtenerUsuarios", ctx ->{
                   GetUsuariosHandler handlerUsuario = new GetUsuariosHandler();
                   handlerUsuario.handle(ctx);
               });
            
                app.get("/api/obtenerUsuarios/{id}", ctx -> {
                    GetUsuarioIdHandler handler = new GetUsuarioIdHandler();
                    handler.handle(ctx);
                });
            
                app.get("/api/obtenerComunidades", ctx -> {
                    GetComunidadesHandler handler = new GetComunidadesHandler();
                    handler.handle(ctx);
                });

                app.get("/api/obtenerComunidades/{id}", ctx -> {
                    GetComunidadIdHandler handler = new GetComunidadIdHandler();
                    handler.handle(ctx);
                });

                app.post("/api/aperturaIncidente",  ctx -> {
                    PostAperturaIncidenteHandler handler = new PostAperturaIncidenteHandler();
                    handler.handle(ctx);
                });

                app.get("/api/obtenerIncidentesComunidad/{idComunidad}",  ctx -> {
                    GetIncidenteIdComunidadHandler handler = new GetIncidenteIdComunidadHandler();
                    handler.handle(ctx);
                });

                app.get("/api/obtenerIncidentesComunidadAbierto/{idComunidad}", ctx -> {
                    GetIncidenteIdComunidadAbiertoHandler handler = new GetIncidenteIdComunidadAbiertoHandler();
                    handler.handle(ctx);
                });

                app.get("/api/obtenerIncidentesComunidadCerrado/{idComunidad}", ctx -> {
                    GetIncidenteIdComunidadCerradoHandler handler = new GetIncidenteIdComunidadCerradoHandler();
                    handler.handle(ctx);
                });

                app.get("/api/obtenerIncidentesCercanos/{idUsuario}", ctx -> {
                    GetIncidenteIdCercanoHandler handler = new GetIncidenteIdCercanoHandler();
                    handler.handle(ctx);
                });

                app.get("/api/obtenerEntidades",  ctx -> {
                    GetEntidadesHandler handler = new GetEntidadesHandler();
                    handler.handle(ctx);
                });
                      
                app.post("/api/cierreIncidente/",  ctx -> {
                    PostCierreIdIncidenteHandler handler = new PostCierreIdIncidenteHandler();
                    handler.handle(ctx);
                });

                app.post("/api/insertarTipoUsuario",  ctx -> {
                    PostInsertarTipoUsuarioHandler handler = new PostInsertarTipoUsuarioHandler();
                    handler.handle(ctx);
                });
                      
                app.post("/api/eliminarTipoUsuario",  ctx -> {
                    PostEliminarTipoUsuarioHandler handler = new PostEliminarTipoUsuarioHandler();
                    handler.handle(ctx);
                });
                      
                app.get("/api/obtenerRankingEntidades/{idRanking}",  ctx -> {
                    GetObtenerRankingEntidadesHandler handler = new GetObtenerRankingEntidadesHandler();
                    handler.handle(ctx);
                });
    }

}
