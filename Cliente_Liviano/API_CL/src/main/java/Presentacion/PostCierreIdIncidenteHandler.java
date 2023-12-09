package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;
import persistencia.RepoUsuario;

public class PostCierreIdIncidenteHandler implements Handler {

    private final RepoIncidente repoIncidente;

    public PostCierreIdIncidenteHandler() {
        this.repoIncidente = new RepoIncidente();
    }
 @Override
    public void handle(@NotNull Context context) throws Exception {


        // dsp se cambia
        long idIncidente = 0;
        long idUsuarioCierre = 0;

        //falta incializarlos =>  context.body() o algo

     if(repoIncidente.cerrarIncidente(idIncidente, idUsuarioCierre))
     {
         context.status(201);
     }
    }
}
