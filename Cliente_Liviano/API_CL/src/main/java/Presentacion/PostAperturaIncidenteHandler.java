package Presentacion;

import Dominio.Incidente;
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

        //esto esta mal? pq si yo quiero crear un incidente, a menos q el cliente me pase todos los datos necesarios,
        // yo no voy a poder crear una clase incidente
        Incidente incidente = context.bodyAsClass(Incidente.class);

        if (repoIncidente.abrirIncidente(incidente.getIdComunidad(), incidente.getIdServicio(), incidente.getIdUsuarioApertura())){
            context.status(201);
        }
    }

}
