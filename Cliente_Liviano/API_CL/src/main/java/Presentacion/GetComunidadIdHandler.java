package Presentacion;

import Dominio.Comunidad;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoComunidad;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Optional;

import java.util.Optional;

public class GetComunidadIdHandler implements Handler {

    private RepoComunidad repoComunidad;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("id", Integer.class).get();
        final Optional<Comunidad> resultadoBusqueda = repoComunidad.obtenerTodos().stream()
                .filter(comunidad -> comunidad.getId() == idBuscado)
                .findFirst();
        if(resultadoBusqueda.isPresent()) {
            context.status(200).json(resultadoBusqueda.get());
        } else {
            context.status(404);
        }
    }

    public GetComunidadIdHandler() {
        this.repoComunidad = new RepoComunidad();
    }

}

/*
public class GetUsuarioIdHandler implements Handler  {

    private RepoUsuario repoUsuario;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("id", Integer.class).get();
        final Optional<Usuario> resultadoBusqueda = repoUsuario.obtenerTodos().stream()
                .filter(usuario -> usuario.getId() == idBuscado)
                .findFirst();
        if(resultadoBusqueda.isPresent()) {
            context.status(200).json(resultadoBusqueda.get());
        } else {
            context.status(404);
        }
    }

    public GetUsuarioIdHandler() {
        this.repoUsuario = new RepoUsuario();
    }
}
* */