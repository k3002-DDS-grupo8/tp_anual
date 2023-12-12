package Presentacion;

import Dominio.ranking.Informe;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoRanking;

import java.util.Optional;

public class GetObtenerRankingEntidadesHandler implements Handler {
    private final RepoRanking repoRanking;

    public GetObtenerRankingEntidadesHandler() {
        this.repoRanking = new RepoRanking();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idRanking", Integer.class).get();
        context.json(repoRanking.obtenerRankingEntidades(idBuscado));
    }
}
