package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoRanking;

public class GetObtenerRankingIncidentesHandler implements Handler {
    private final RepoRanking repoRanking;

    public GetObtenerRankingIncidentesHandler() {
        this.repoRanking = new RepoRanking();
    }
    @Override
    public void handle(@NotNull Context context) throws Exception {
        // context.json(repoRanking.obtenerTodos());
    }
}

