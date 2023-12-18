package Presentacion;

import Dominio.ranking.Informe;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoRanking;

import java.util.*;

public class GetObtenerRankingEntidadesHandler implements Handler {

    private final RepoRanking repoRanking;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        List<Informe> listaInformes = this.repoRanking.obtenerRankingEntidades();
        Map<String, Object> model = new HashMap<>();
        System.out.println(listaInformes);
        model.put("listaInformes", listaInformes);
        context.render("static/ranking_incidentes.mustache", model);
    }

    public GetObtenerRankingEntidadesHandler() {
        this.repoRanking = new RepoRanking();

    }

}
