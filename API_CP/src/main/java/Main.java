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

                .get("/obtenerEntidades", ctx -> {
                    MainApi mainApi = new MainApi();
                    ArrayList<Entidad> entidades = mainApi.obtenerEntidades();
                    ctx.json(entidades);
                })
                .post("/cargaMasivaDeEntidades", ctx -> {
                    String body = ctx.body();
                    System.out.println(body);
                    // Acá va la lógica de base de datos.
                })

                .post("/aperturaIncidente/", ctx -> {
                    String body = ctx.body();
                    MainApi.abrirIncidente(body.idComunidad, body.idServicio, body.idUsuarioApertura);
                })
                
                 .post("/cierreIncidente/{idIncidente}", ctx -> {
                     String body = ctx.body();
                     MainApi.cerrarIncidente(ctx.pathParam("idIncidente"), body.idUsuarioCierre);
                 })
                   .get("/añadirTipoUsuario", ctx -> {
                       MainApi mainApi = new MainApi();
                       Usuario usuario = mainApi.añadirTipoUsuario;
                       ctx.json(usuario);
                   })
                            
                    .get("/eliminarTipoUsuario", ctx -> {
                        MainApi mainApi = new MainApi();
                        Usuario usuario = mainApi.eliminarTipoUsuario;
                        ctx.json(usuario);
                    })
                                
                      .get("/obtenerRankingIncidentes", ctx -> {
                          MainApi mainApi = new MainApi();
                          Usuario usuario = mainApi.obtenerRankingIncidentes; //no sabemos el tipo de dato
                          ctx.json(usuario);
                      })
                .start(7070);
    }
}
