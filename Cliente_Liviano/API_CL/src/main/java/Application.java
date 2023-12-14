import Presentacion.*;


import io.javalin.Javalin;
import org.quartz.*;

public class Application {
    public static void main(String[] args) throws SchedulerException {

                Javalin app = Javalin.create(config -> {

                config.plugins.enableCors(cors -> {
                    cors.add(corsConfig -> {
                        corsConfig.anyHost();
                    });
                });

                }).start(7070);


               app.get("/login", new GetLoginHandler());
               app.post("/login/{usuarioNombre}/{contrasenia}", new PostLoginHandler());
            
               app.get("/api/obtenerUsuarios", ctx ->{
                   GetUsuariosHandler handlerUsuario = new GetUsuariosHandler();
                   handlerUsuario.handle(ctx);
               });
            
                app.get("/api/obtenerUsuarios/{id}", ctx -> {
                    GetUsuarioIdHandler handler = new GetUsuarioIdHandler();
                    handler.handle(ctx);
                });
            
                app.get("/api/obtenerComunidades", new GetComunidadesHandler());

                app.get("/api/obtenerComunidades/{id}", ctx -> {
                    GetComunidadIdHandler handler = new GetComunidadIdHandler();
                    handler.handle(ctx);
                });

                app.post("/api/aperturaIncidente",  ctx -> {
                    PostAperturaIncidenteHandler handler = new PostAperturaIncidenteHandler();
                    handler.handle(ctx);
                });

                app.get("/api/obtenerIncidentesComunidad/{idComunidad}", new GetIncidenteIdComunidadHandler());

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

                app.get("/api/obtenerTiposUsuario", new GetObtenerTiposUsuarioHandler());
                app.post("/api/insertarTipoUsuario/{nombre}", new PostInsertarTipoUsuarioHandler());

                app.post("/api/cierreIncidente/{idIncidente}", new PostCierreIdIncidenteHandler());


                      
                app.post("/api/eliminarTipoUsuario/{idTipoUsuario}", new PostEliminarTipoUsuarioHandler());
                      
                app.get("/api/obtenerRankingEntidades", new GetObtenerRankingEntidadesHandler());
    }

}
