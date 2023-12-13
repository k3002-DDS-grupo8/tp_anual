package Presentacion;

import Dominio.incidente.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;

public class PostCierreIdIncidenteHandler implements Handler {

    private final RepoIncidente repoIncidente;

    public PostCierreIdIncidenteHandler() {
        this.repoIncidente = new RepoIncidente();
    }
 @Override
    public void handle(@NotNull Context context) throws Exception {
        Incidente incidente = context.bodyAsClass(Incidente.class);

        long idIncidente = incidente.getId();
        long idUsuarioCierre = incidente.getUsuarioCierreId();

     repoIncidente.cerrarIncidente(idIncidente, idUsuarioCierre);
     context.status(201);
    }
}
