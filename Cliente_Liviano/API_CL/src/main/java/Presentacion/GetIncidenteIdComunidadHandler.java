package Presentacion;

import Dominio.incidente.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetIncidenteIdComunidadHandler implements Handler {

        private RepoIncidente repoIncidente;

        @Override
        public void handle(@NotNull Context context) throws Exception {
            Integer idBuscado = context.pathParamAsClass("idComunidad", Integer.class).get();
            final Stream<Incidente> resultadoBusqueda = repoIncidente.obtenerTodos().stream()
                    .filter(incidente -> incidente.getComunidadId() == idBuscado);
            List<Incidente> listaIncidentes = resultadoBusqueda.collect(Collectors.toList());
            Map<String, Object> model = new HashMap<>();
            model.put("listaIncidentes", listaIncidentes);
            context.render("templates/incidentes_comunidad.mustache", model);
        }

        public GetIncidenteIdComunidadHandler() {
            this.repoIncidente = new RepoIncidente();
        }
}
