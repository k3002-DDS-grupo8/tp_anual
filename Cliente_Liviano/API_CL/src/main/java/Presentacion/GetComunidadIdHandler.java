package Presentacion;

import Dominio.Usuario;
import Dominio.comunidad.Comunidad;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetComunidadIdHandler implements Handler {

    private final Comunidad repoComunidad;

    public GetComunidadIdHandler(id) {
        this.repoComunidad = new Comunidad(id);
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {

    }



}
