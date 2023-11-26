package Presentacion;

import Dominio.Comunidad;
import Dominio.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoComunidad;
import persistencia.RepoIncidente;

import java.util.Optional;

public class GetIncidenteIdCercanoHandler implements Handler {

    private RepoIncidente repoIncidente;

    public GetIncidenteIdCercanoHandler() {
        this.repoIncidente = new RepoIncidente();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("id", Integer.class).get();
        final Optional<Incidente> resultadoBusqueda = repoIncidente.obtenerTodos().stream()
                .filter(incidente -> incidente.getId() == idBuscado)
                .findFirst();
        if(resultadoBusqueda.isPresent()) {
            context.status(200).json(resultadoBusqueda.get());
        } else {
            context.status(404);
        }
    }
}
