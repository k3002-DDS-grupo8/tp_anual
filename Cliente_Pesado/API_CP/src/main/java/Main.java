import Dominio.Entidad;
import Dominio.Incidente;

import java.util.ArrayList;

import Dominio.TipoUsuario;
import org.json.JSONObject;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        //JAVALIN API
        var app = Javalin.create()
                .get("/obtenerIncidentesComunidad/{idComunidad}", ctx -> {
                    long idComunidad = Integer.parseInt(ctx.pathParam("idComunidad"));
                    MainApi mainApi = new MainApi();
                    ArrayList<Incidente> incidentes = mainApi.obtenerIncidentesComunidad(idComunidad);
                    ctx.json(incidentes);
                }) // TODO: No lo usamos todavía.

                .get("/obtenerEntidades", ctx -> {
                    MainApi mainApi = new MainApi();
                    ArrayList<Entidad> entidades = mainApi.obtenerEntidades();
                    ctx.json(entidades);
                }) // TODO: No lo usamos todavía.

                .post("/insertarEntidad", ctx -> {
                    String cuerpoSolicitud = ctx.body();
                    JSONObject json = new JSONObject(cuerpoSolicitud);
                    Entidad entidad = new Entidad(
                            json.getLong("id"),
                            json.getString("nombre"),
                            json.getString("email"),
                            json.getString("descripcion")
                    );
                    MainApi mainApi = new MainApi();
                    mainApi.insertarEntidad(entidad);
                })

                .post("/eliminarEntidad", ctx -> {
                    // Acá va la lógica (NO ES REQUERIMIENTO).
                })

                .post("/aperturaIncidente/", ctx -> {
                    // Acá va la lógica. (FEDE)
                })

                .post("/cierreIncidente/{idIncidente}", ctx -> {
                    // Acá va la lógica. (FEDE)
                })

                .get("/obtenerTiposUsuario", ctx -> {
                    MainApi mainApi = new MainApi();
                    ArrayList<TipoUsuario> tiposUsuario = mainApi.obtenerTiposUsuario();
                    ctx.json(tiposUsuario);
                }) // TODO: No lo usamos todavía.

                .post("/insertarTipoUsuario", ctx -> {
                    String cuerpoSolicitud = ctx.body();
                    JSONObject json = new JSONObject(cuerpoSolicitud);
                    long id = json.getLong("id");
                    String nombre = json.getString("nombre");
                    MainApi mainApi = new MainApi();
                    mainApi.insertarTipoUsuario(id, nombre);
                })

                .post("/eliminarTipoUsuario", ctx -> {
                    String cuerpoSolicitud = ctx.body();
                    JSONObject json = new JSONObject(cuerpoSolicitud);
                    long id = json.getLong("id");
                    MainApi mainApi = new MainApi();
                    mainApi.eliminarTipoUsuario(id);
                })

                .get("/obtenerRankingEntidades/{idRanking}", ctx -> {
                    long idRanking = Integer.parseInt(ctx.pathParam("idRanking"));
                    MainApi mainApi = new MainApi();
                    ArrayList<Entidad> entidadesEnRanking = mainApi.obtenerRankingEntidades(idRanking);
                    ctx.json(entidadesEnRanking);
                }) // TODO: No lo usamos todavía. (Hay que cambiar la lógica de la página)

                .start(7070);
    }
}
