import Dominio.*;

import java.util.ArrayList;
import java.util.List;

import Presentacion.LoginHandler;
import Presentacion.GetUsuariosHandler;
import Presentacion.GetUsuarioIdHandler;
import Presentacion.GetComunidadesHandler;
import Presentacion.GetComunidadIdHandler;
import Presentacion.PostIncidenteHandler;
import Presentacion.GetIncidentesComunidadHandler;
import Presentacion.GetIncidenteIdComunidadHandler;
import Presentacion.GetIncidenteIdComunidadAbiertoHandler;
import Presentacion.GetIncidenteIdComunidadCerradoHandler;
import Presentacion.GetIncidenteIdCercanoHandler;
import Presentacion.GetEntidadesHandler;
import Presentacion.PostCargaMasivaEntidadesHandler;
import Presentacion.PostAperturaIncidenteHandler;
import Presentacion.PostCierreIdIncidenteHandler;
import Presentacion.PostInsertarTipoUsuarioHandler;
import Presentacion.PostAlmacenarIncidenteHandler;
import Presentacion.PostEliminarTipoUsuarioHandler;
import Presentacion.GetObtenerRankingIncidentesHandler;



import com.fasterxml.jackson.databind.util.JSONPObject;
import io.javalin.Javalin;
import org.json.JSONObject;
import org.quartz.*;

public class Application {
    public static void main(String[] args) throws SchedulerException {
    
        //JAVALIN API
        var app = Javalin.create()
                .get("/api/login/", ctx -> new LoginHandler())
            
                .get("/api/obtenerUsuarios", ctx -> new GetUsuariosHandler())
            
                .get("/api/obtenerUsuarios/{id}", ctx -> {
                   long id = Integer.parseInt((ctx.pathParam("id"));
                   GetUsuarioIdHandler usuarioID = new GetUsuarioIdHandler(id);
                })
            
                .get("/api/obtenerComunidades", ctx -> new GetComunidadesHandler())

                .get("/api/obtenerComunidades/{id}", ctx -> {
                    long id = Integer.parseInt((ctx.pathParam("id"));
                    GetComunidadIdHandler comunidadId = new GetComunidadIdHandler(id);
                    })
               
                // este no se si es PostAlmacenarIncidenteHandler o PostIncidenteHandler
                .post("/api/almacenarIncidente", ctx -> new PostAlmacenarIncidenteHandler())

                // estaba GetIncidentesComunidadHandler pero no estaba el get original sin el id
                .get("/api/obtenerIncidentesComunidad/{idComunidad}", ctx -> new GetIncidenteIdComunidadHandler())
                
                .get("/api/obtenerIncidentesComunidadAbierto/{idComunidad}", ctx -> new GetIncidenteIdComunidadAbiertoHandler())
                
                .get("/api/obtenerIncidentesComunidadCerrado/{idComunidad}", ctx -> new GetIncidenteIdComunidadCerradoHandler())
                
                .get("/api/obtenerIncidenteCercano/{idUsuario}", ctx -> new GetIncidenteIdCercanoHandler())
                
                .get("/api/obtenerEntidades", ctx -> new GetEntidadesHandler())
            
                .post("/api/cargaMasivaDeEntidades", ctx -> new PostCargaMasivaEntidadesHandler())

                .post("/api/aperturaIncidente/", ctx -> new PostAperturaIncidenteHandler())
                      
                .post("/api/cierreIncidente/{idIncidente}", ctx -> new PostCierreIdIncidenteHandler())
                      
                .post("/api/insertarTipoUsuario", ctx -> new PostInsertarTipoUsuarioHandler())
                      
                .get("/api/eliminarTipoUsuario", ctx -> new PostEliminarTipoUsuarioHandler())
                      
                .get("/api/obtenerRankingIncidentes", ctx -> new GetObtenerRankingIncidentesHandler())
                      
                .start(7070);
    }
}
