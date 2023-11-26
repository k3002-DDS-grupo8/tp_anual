package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoComunidad;

public class GetComunidadesHandler implements Handler {
    private final RepoComunidad repoComunidad;

    public GetComunidadesHandler() {
        this.repoComunidad = new RepoComunidad();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoComunidad.obtenerTodos());
    }

}

