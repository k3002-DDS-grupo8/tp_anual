package Presentacion;

import Dominio.incidente.EstadoIncidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;
import java.util.Optional;
import Dominio.incidente.Incidente;

public class GetIncidenteIdComunidadAbiertoHandler implements Handler  {

    private RepoIncidente repoIncidente;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idComunidad", Integer.class).get();
        final Optional<Incidente> resultadoBusqueda = repoIncidente.obtenerTodos().stream()
                .filter(incidente -> incidente.getId() == idBuscado)
                .filter(incidente -> incidente.getEstado() == EstadoIncidente.ABIERTO) // CREO QUE ESTA MAL
                .findFirst();
        if(resultadoBusqueda.isPresent()) {
            context.status(200).json(resultadoBusqueda.get());
        } else {
            context.status(404);
        }
    }

    public GetIncidenteIdComunidadAbiertoHandler() {
        this.repoIncidente = new RepoIncidente();
    }

}
