package Presentacion;

import Dominio.ranking.Informe;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoRanking;

import java.util.Optional;

public class GetObtenerRankingEntidadesHandler implements Handler {

    private final RepoRanking repoRanking;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idRanking", Integer.class).get();
        final Optional<Informe> resultadoBusqueda = repoRanking.obtenerTodos().stream()
                .filter(informe -> informe.getRanking_id() == idBuscado);
        if(resultadoBusqueda.isPresent()) {
            context.status(200).json(resultadoBusqueda.get());
        } else {
            context.status(404);
        }
    }

    public GetObtenerRankingEntidadesHandler() {
        this.repoRanking = new RepoRanking();

    }

}
