package Presentacion;

import Dominio.comunidad.Usuario;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoUsuario;
import java.util.Optional;

public class PostLoginHandler implements Handler {
    private final RepoUsuario repoUsuario;

    public PostLoginHandler() {
        this.repoUsuario = new RepoUsuario();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String usuarioNombre = context.pathParamAsClass("usuarioNombre", String.class).get();
        String contrasenia = context.pathParamAsClass("contrasenia", String.class).get();
        System.out.println(usuarioNombre);
        final Optional<Usuario> resultadoBusqueda = repoUsuario.obtenerTodos().stream()
                .filter(usuario -> (usuario.getNombre().compareTo(usuarioNombre) == 0
                        && usuario.getContrasenia().compareTo(contrasenia) == 0))
                .findFirst();
        if(resultadoBusqueda.isPresent()) {
            context.sessionAttribute("username", usuarioNombre);
        } else {
            context.status(404);
            // este 404 puede ser pq no esta el usuario o no coincide OJO
        }
    }
}