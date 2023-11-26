package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoUsuario;

public class GetUsuariosHandler implements Handler  {
    private final RepoUsuario repoUsuario;

    public GetUsuariosHandler() {
        this.repoUsuario = new RepoUsuario();
    }
    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoUsuario.obtenerTodos());
    }
}
