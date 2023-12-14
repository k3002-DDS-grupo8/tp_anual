package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoTipoUsuario;
import persistencia.RepoUsuario;

public class PostInsertarTipoUsuarioHandler implements Handler {

  private final RepoTipoUsuario repoTipoUsuario;

  public PostInsertarTipoUsuarioHandler() {
    this.repoTipoUsuario = new RepoTipoUsuario();
  }
  @Override
    public void handle(@NotNull Context context) throws Exception {
    String nombreTipoUsuario = context.pathParamAsClass("nombre", String.class).get();
    // repoTipoUsuario.insertarTipoUsuario(nombreTipoUsuario);
    context.status(201);
    }
}
