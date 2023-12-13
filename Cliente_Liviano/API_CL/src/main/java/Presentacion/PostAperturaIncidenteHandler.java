package Presentacion;

import Dominio.incidente.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;

public class PostAperturaIncidenteHandler implements Handler  {
    private final RepoIncidente repoIncidente;

    public PostAperturaIncidenteHandler() {
        this.repoIncidente = new RepoIncidente();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {

        Incidente incidente = context.bodyAsClass(Incidente.class);
        repoIncidente.abrirIncidente(incidente);
        context.status(201);
    }

}
