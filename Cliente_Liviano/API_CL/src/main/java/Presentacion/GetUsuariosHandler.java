package Presentacion;

import Dominio.comunidad.Usuario;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoUsuario;

import java.util.ArrayList;
import java.util.Arrays;

public class GetUsuariosHandler implements Handler  {
    private final RepoUsuario repoUsuario;

    public GetUsuariosHandler() {
        this.repoUsuario = new RepoUsuario();
    }
    @Override
    public void handle(@NotNull Context context) throws Exception {
        for (Usuario usuario : repoUsuario.obtenerTodos()) {
            System.out.print(usuario.toString());
        }
        
        context.json(repoUsuario.obtenerTodos());

    }
}
