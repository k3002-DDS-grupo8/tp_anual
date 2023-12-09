package Presentacion;

import Dominio.Incidente;
import Dominio.ranking.Informe;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoRanking;

import java.util.Optional;

public class GetObtenerRankingIncidentesHandler implements Handler {
    private final RepoRanking repoRanking;

    public GetObtenerRankingIncidentesHandler() {
        this.repoRanking = new RepoRanking();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idRanking", Integer.class).get();
        final Optional<Informe> resultadoBusqueda = repoRanking.obtenerTodos().stream()
                .filter(informe -> informe.getRankingId() == idBuscado)
                .findFirst();
        if(resultadoBusqueda.isPresent()) {
            context.status(200).json(resultadoBusqueda.get());
        } else {
            context.status(404);
        }
    }
}

