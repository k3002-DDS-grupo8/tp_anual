import Dominio.*;

import java.util.ArrayList;
import java.util.List;

import Presentacion.LoginHandler;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.javalin.Javalin;
import org.json.JSONObject;
import org.quartz.*;

public class Application {
    public static void main(String[] args) throws SchedulerException {
    
        //JAVALIN API
        var app = Javalin.create()
                .get("/api/login/", ctx -> new LoginHandler())
                .get("/api/obtenerUsuarios", ctx -> {
                    MainApi mainApi = new MainApi();
                    List<Usuario> usuarios = mainApi.obtenerUsuarios();
                    ctx.json(usuarios);
                })
                .get("/api/obtenerUsuarios/{id}", ctx -> {
                    long id = Integer.parseInt(ctx.pathParam("id"));
                    MainApi mainApi = new MainApi();
                    Usuario usuario = mainApi.obtenerUsuario(id);
                    ctx.json(usuario);
                })
                .get("/api/obtenerComunidades", ctx -> {
                    MainApi mainApi = new MainApi();
                    ArrayList<Comunidad> comunidades = mainApi.obtenerComunidades();
                    ctx.json(comunidades);
                })
                .get("/api/obtenerComunidades/{id}", ctx -> {
                    long id = Integer.parseInt(ctx.pathParam("id"));
                    MainApi mainApi = new MainApi();
                    Comunidad comunidad = mainApi.obtenerComunidad(id);
                    ctx.json(comunidad);
                })
                .post("/api/almacenarIncidente", ctx -> {
                    String body = ctx.body();
                    System.out.println(body);
                    // Acá va la lógica de base de datos.
                })
                .get("/api/obtenerIncidentesComunidad/{idComunidad}", ctx -> {
                    long idComunidad = Integer.parseInt(ctx.pathParam("idComunidad"));
                    MainApi mainApi = new MainApi();
                    ArrayList<Incidente> incidentes = mainApi.obtenerIncidentesComunidad(idComunidad);
                    ctx.json(incidentes);
                })
                .get("/api/obtenerIncidentesComunidadAbierto/{idComunidad}", ctx -> {
                    long idComunidad = Integer.parseInt(ctx.pathParam("idComunidad"));
                    MainApi mainApi = new MainApi();
                    ArrayList<Incidente> incidentes = mainApi.obtenerIncidentesComunidadAbierto(idComunidad);
                    ctx.json(incidentes);
                })
                .get("/api/obtenerIncidentesComunidadCerrado/{idComunidad}", ctx -> {
                    long idComunidad = Integer.parseInt(ctx.pathParam("idComunidad"));
                    MainApi mainApi = new MainApi();
                    ArrayList<Incidente> incidentes = mainApi.obtenerIncidentesComunidadCerrado(idComunidad);
                    ctx.json(incidentes);
                })
                .get("/api/obtenerIncidenteCercano/{idUsuario}", ctx -> {
                    long idUsuario = Integer.parseInt(ctx.pathParam("idUsuario"));
                    MainApi mainApi = new MainApi();
                    RetornoIncidenteCercano incidenteCercano = mainApi.obtenerIncidenteCercano(idUsuario);
                    ctx.json(incidenteCercano);
                })
                .get("/api/obtenerEntidades", ctx -> {
                    MainApi mainApi = new MainApi();
                    ArrayList<Entidad> entidades = mainApi.obtenerEntidades();
                    ctx.json(entidades);
                })
                .post("/api/cargaMasivaDeEntidades", ctx -> {
                    String body = ctx.body();
                    System.out.println(body);
                    // Acá va la lógica de base de datos.
                })
                .post("/api/aperturaIncidente/", ctx -> {
                })
                .post("/api/cierreIncidente/{idIncidente}", ctx -> {
                 })
                .post("/api/insertarTipoUsuario", ctx -> {
                })
                .get("/api/eliminarTipoUsuario", ctx -> {})
                .get("/api/obtenerRankingIncidentes", ctx -> {})
                .start(7070);
    }
}
