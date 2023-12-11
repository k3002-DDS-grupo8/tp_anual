import Dominio.*;

import java.util.ArrayList;

import org.json.JSONObject;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        //JAVALIN API
        Javalin app = Javalin.create(config -> {

            config.plugins.enableCors(cors -> {
                cors.add(corsConfig -> {
                    corsConfig.anyHost();
                });
            });

        }).start(7070);

        app.get("/obtenerEntidades", ctx -> {
            MainApi mainApi = new MainApi();
            ArrayList<Entidad> entidades = mainApi.obtenerEntidades();
            ctx.json(entidades);
        });

        app.post("/insertarEntidad", ctx -> {
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
        });

        app.get("/obtenerIncidentesComunidad/{idComunidad}", ctx -> {
            long idComunidad = Integer.parseInt(ctx.pathParam("idComunidad"));
            MainApi mainApi = new MainApi();
            ArrayList<Incidente> incidentes = mainApi.obtenerIncidentesComunidad(idComunidad);
            ctx.json(incidentes);
        });

        app.post("/abrirIncidente/", ctx -> {
            String cuerpoSolicitud = ctx.body();
            JSONObject json = new JSONObject(cuerpoSolicitud);
            Incidente incidente = new Incidente(
                    json.getLong("id"),
                    json.getLong("comunidadId"),
                    json.getLong("servicioIncidenteId"),
                    json.getString("detalleIncidente"),
                    json.getString("estado"),
                    json.getLong("usuario1Id")
            );
            MainApi mainApi = new MainApi();
            mainApi.abrirIncidente(incidente);
        });

        app.post("/cerrarIncidente", ctx -> {
            String cuerpoSolicitud = ctx.body();
            JSONObject json = new JSONObject(cuerpoSolicitud);
            long id = json.getLong("id");
            long usuarioCierre = json.getLong("usuario2Id");
            MainApi mainApi = new MainApi();
            mainApi.cerrarIncidente(id, usuarioCierre);
        });

        app.get("/obtenerTiposUsuario", ctx -> {
            MainApi mainApi = new MainApi();
            ArrayList<TipoUsuario> tiposUsuario = mainApi.obtenerTiposUsuario();
            ctx.json(tiposUsuario);
        });

        app.post("/insertarTipoUsuario", ctx -> {
            String cuerpoSolicitud = ctx.body();
            JSONObject json = new JSONObject(cuerpoSolicitud);
            long id = json.getLong("id");
            String nombre = json.getString("nombre");
            MainApi mainApi = new MainApi();
            mainApi.insertarTipoUsuario(id, nombre);
        });

        app.get("/eliminarTipoUsuario/{id}", ctx -> {
            long id = Long.parseLong(ctx.pathParam("id"));
            MainApi mainApi = new MainApi();
            mainApi.eliminarTipoUsuario(id);
        });

        app.get("/obtenerRankingEntidades/{idRanking}", ctx -> {
            long idRanking = Long.parseLong(ctx.pathParam("idRanking"));
            MainApi mainApi = new MainApi();
            ArrayList<Informe> informeEntidades = mainApi.obtenerRankingEntidades(idRanking);
            ctx.json(informeEntidades);
        });
    }
}