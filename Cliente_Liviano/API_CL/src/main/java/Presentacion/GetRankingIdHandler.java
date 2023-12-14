package Presentacion;

import Dominio.incidente.Incidente;
import Dominio.ranking.Informe;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;
import persistencia.RepoRanking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetRankingIdHandler implements Handler {

    private RepoRanking repoRanking;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idRanking", Integer.class).get();
        final Stream<Informe> resultadoBusqueda = repoRanking.obtenerRankingEntidades().stream()
                .filter(incidente -> incidente.getRanking_id() == idBuscado);
        List<Informe> listaInformes = resultadoBusqueda.collect(Collectors.toList());
        Map<String, Object> model = new HashMap<>();
        model.put("listaIncidentes", listaInformes);
        context.render("templates/incidentes_comunidad.mustache", model);
    }

    public GetRankingIdHandler() {
        this.repoRanking = new RepoRanking();
    }
}
