package Presentacion;

import Dominio.comunidad.Usuario;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoUsuario;

import java.util.Optional;

public class GetUsuarioIdHandler implements Handler  {

    private RepoUsuario repoUsuario;

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String emailBuscado = context.pathParamAsClass("email", String.class).get();
        final Optional<Usuario> resultadoBusqueda = repoUsuario.obtenerTodos().stream()
                .filter(usuario ->  (usuario.getEmail().compareTo(emailBuscado) == 0))
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


