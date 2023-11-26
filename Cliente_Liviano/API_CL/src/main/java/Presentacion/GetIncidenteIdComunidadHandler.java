package Presentacion;

import Dominio.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoComunidad;
import persistencia.RepoIncidente;

import java.util.Optional;

public class GetIncidenteIdComunidadHandler implements Handler {

        private RepoIncidente repoIncidente;

        @Override
        public void handle(@NotNull Context context) throws Exception {
            Integer idBuscado = context.pathParamAsClass("idComunidad", Integer.class).get();
            final Optional<Incidente> resultadoBusqueda = repoIncidente.obtenerTodos().stream()
                    .filter(incidente -> incidente.getIdComunidad() == idBuscado)
                    .findFirst();
            if(resultadoBusqueda.isPresent()) {
                context.status(200).json(resultadoBusqueda.get());
            } else {
                context.status(404);
            }
        }

        public GetIncidenteIdComunidadHandler() {
            this.repoIncidente = new RepoIncidente();
        }

    }
