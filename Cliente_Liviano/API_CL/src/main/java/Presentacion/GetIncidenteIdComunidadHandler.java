package Presentacion;

import Dominio.incidente.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GetIncidenteIdComunidadHandler implements Handler {

        private RepoIncidente repoIncidente;

        @Override
        public void handle(@NotNull Context context) throws Exception {
            Integer idBuscado = context.pathParamAsClass("idComunidad", Integer.class).get();
            final List<Incidente> resultadoBusqueda = repoIncidente.obtenerTodos().stream()
                    .filter(incidente -> incidente.getComunidadId() == idBuscado).collect(Collectors.toList());

                context.status(200).json(resultadoBusqueda);

            }

        public GetIncidenteIdComunidadHandler() {
            this.repoIncidente = new RepoIncidente();
        }
}
