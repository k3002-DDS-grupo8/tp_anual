package Presentacion;

import Dominio.incidente.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
=======
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
>>>>>>> d5fc6119c2a8a838d436b2929a084acde14e6ad2

public class GetIncidenteIdComunidadHandler implements Handler {

        private RepoIncidente repoIncidente;

        @Override
        public void handle(@NotNull Context context) throws Exception {
            Integer idBuscado = context.pathParamAsClass("idComunidad", Integer.class).get();
<<<<<<< HEAD
            final Stream<Incidente> resultadoBusqueda = repoIncidente.obtenerTodos().stream()
                    .filter(incidente -> incidente.getComunidadId() == idBuscado);
            List<Incidente> listaIncidentes = resultadoBusqueda.collect(Collectors.toList());
            Map<String, Object> model = new HashMap<>();
            model.put("listaIncidentes", listaIncidentes);
            context.render("templates/incidentes_comunidad.mustache", model);
        }
=======
            final List<Incidente> resultadoBusqueda = repoIncidente.obtenerTodos().stream()
                    .filter(incidente -> incidente.getComunidadId() == idBuscado).collect(Collectors.toList());

                context.status(200).json(resultadoBusqueda);

            }
>>>>>>> d5fc6119c2a8a838d436b2929a084acde14e6ad2

        public GetIncidenteIdComunidadHandler() {
            this.repoIncidente = new RepoIncidente();
        }
}
