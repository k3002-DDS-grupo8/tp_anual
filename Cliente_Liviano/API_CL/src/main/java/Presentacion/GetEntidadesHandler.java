package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoEntidad;

public class GetEntidadesHandler implements Handler {
    private final RepoEntidad repoEntidad;

    public GetEntidadesHandler() {
        this.repoEntidad = new RepoEntidad();
    }
    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoEntidad.obtenerTodos());
    }

}


