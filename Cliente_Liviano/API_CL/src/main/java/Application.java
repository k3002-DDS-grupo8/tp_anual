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

public class Application {
    public static void main(String[] args) throws SchedulerException {
    
        //JAVALIN API
        var app = Javalin.create()
                //.get("/api/login/", ctx -> new LoginHandler())
            
                .get("/api/obtenerUsuarios", ctx -> new GetUsuariosHandler())
            
                .get("/api/obtenerUsuarios/{id}", new GetUsuarioIdHandler())
            
                .get("/api/obtenerComunidades", ctx -> new GetComunidadesHandler())

                .get("/api/obtenerComunidades/{id}", ctx -> {
                    long id = Integer.parseInt(ctx.pathParam("id"));
                    GetComunidadIdHandler comunidadId = new GetComunidadIdHandler();
                    })
                // este no se si es PostAlmacenarIncidenteHandler o PostIncidenteHandler
                .post("/api/aperturaIncidente", ctx -> new PostAperturaIncidenteHandler())

                // estaba GetIncidentesComunidadHandler pero no estaba el get original sin el id
                .get("/api/obtenerIncidentesComunidad/{idComunidad}", ctx -> new GetIncidenteIdComunidadHandler())

                .get("/api/obtenerIncidentesComunidadAbierto/{idComunidad}", ctx -> new GetIncidenteIdComunidadAbiertoHandler())
                
                .get("/api/obtenerIncidentesComunidadCerrado/{idComunidad}", ctx -> new GetIncidenteIdComunidadCerradoHandler())

                .get("/api/obtenerEntidades", ctx -> new GetEntidadesHandler())
            
                //.post("/api/cargaMasivaDeEntidades", ctx -> new PostCargaMasivaEntidadesHandler())

                //.post("/api/aperturaIncidente/", ctx -> new PostAperturaIncidenteHandler())
                      
                .post("/api/cierreIncidente/", ctx -> new PostCierreIdIncidenteHandler())

                .post("/api/insertarTipoUsuario", ctx -> new PostInsertarTipoUsuarioHandler())
                      
                .get("/api/eliminarTipoUsuario", ctx -> new PostEliminarTipoUsuarioHandler())
                      
                .get("/api/obtenerRankingEntidades", ctx -> new GetObtenerRankingEntidadesHandler())
                      
                .start(7070);
    }
}
