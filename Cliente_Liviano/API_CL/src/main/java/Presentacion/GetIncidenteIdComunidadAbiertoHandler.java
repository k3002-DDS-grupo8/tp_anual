package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Dominio.incidente.Incidente;

public class GetIncidenteIdComunidadAbiertoHandler implements Handler  {

    private RepoIncidente repoIncidente;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idComunidad", Integer.class).get();
        final List<Incidente> resultadoBusqueda = repoIncidente.obtenerTodos().stream()
                .filter(incidente -> incidente.getComunidadId() == idBuscado && incidente.getEstado() == "ABIERTO")
                .collect(Collectors.toList());

        context.status(200).json(resultadoBusqueda);

    }

    public GetIncidenteIdComunidadAbiertoHandler() {
        this.repoIncidente = new RepoIncidente();
    }

}
