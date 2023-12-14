package Presentacion;

import Dominio.ranking.Informe;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoRanking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetObtenerRankingEntidadesHandler implements Handler {

    private final RepoRanking repoRanking;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idRanking", Integer.class).get();
        final List<Informe> resultadoBusqueda = repoRanking.obtenerRankingEntidades().stream()
                .filter(informe -> informe.getRanking_id() == idBuscado)
                .collect(Collectors.toList());

        if(!resultadoBusqueda.isEmpty()) {
            context.status(200).json(resultadoBusqueda);
        } else {
            context.status(404);
        }
    }

    public GetObtenerRankingEntidadesHandler() {
        this.repoRanking = new RepoRanking();

    }

}
