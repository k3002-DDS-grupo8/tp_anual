package Presentacion;

import Dominio.comunidad.Comunidad;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoComunidad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetComunidadesHandler implements Handler {
    private final RepoComunidad repoComunidad;

    public GetComunidadesHandler() {
        this.repoComunidad = new RepoComunidad();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        List<Comunidad> listaComunidades = this.repoComunidad.obtenerTodos();
        Map<String, Object> model = new HashMap<>();
        model.put("listaComunidades", listaComunidades);
        context.render("static/lista_comunidades.mustache", model);
    }
}

