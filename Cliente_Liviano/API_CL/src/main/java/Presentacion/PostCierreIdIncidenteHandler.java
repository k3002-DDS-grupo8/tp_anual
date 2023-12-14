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
        Integer idIncidente = context.pathParamAsClass("idIncidente", Integer.class).get();
        long idUsuarioCierre = 1;
        System.out.println("Intento de cierre de incidente! ID: " + idIncidente);
     repoIncidente.cerrarIncidente(idIncidente, idUsuarioCierre);
     context.status(200);
    }
}
