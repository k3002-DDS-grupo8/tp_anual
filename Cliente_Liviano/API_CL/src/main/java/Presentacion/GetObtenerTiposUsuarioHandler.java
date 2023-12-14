package Presentacion;

import Dominio.comunidad.Comunidad;
import Dominio.comunidad.TipoUsuario;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoTipoUsuario;
import persistencia.RepoUsuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetObtenerTiposUsuarioHandler implements Handler {

    private final RepoTipoUsuario repoTipoUsuario;

    public GetObtenerTiposUsuarioHandler() {
        this.repoTipoUsuario = new RepoTipoUsuario();
    }
    @Override
    public void handle(@NotNull Context context) throws Exception {
        List<TipoUsuario> listaTipos = this.repoTipoUsuario.obtenerTodos();
        Map<String, Object> model = new HashMap<>();
        model.put("tiposUsuario", listaTipos);
        context.render("templates/admin_tipos_usuario.mustache", model);
        context.status(201);
    }
}
