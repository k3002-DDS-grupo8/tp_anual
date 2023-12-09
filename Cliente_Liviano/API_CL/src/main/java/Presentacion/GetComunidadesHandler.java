package Presentacion;

import Dominio.Utils.BDUtils;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.hibernate.*;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoComunidad;

import java.util.ArrayList;
import java.util.List;

public class GetComunidadesHandler implements Handler {
    private final RepoComunidad repoComunidad;

    public GetComunidadesHandler() {
        this.repoComunidad = new RepoComunidad();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoComunidad.obtenerTodos());
    }
}

