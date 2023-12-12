package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoTipoUsuario;

public class PostEliminarTipoUsuarioHandler implements Handler  {

  private final RepoTipoUsuario repoTipoUsuario;

  public PostEliminarTipoUsuarioHandler() {
    this.repoTipoUsuario = new RepoTipoUsuario();
  }
  @Override
    public void handle(@NotNull Context context) throws Exception {
    Integer idBuscado = context.pathParamAsClass("idTipoUsuario", Integer.class).get();
    repoTipoUsuario.eliminarTipoUsuario(idBuscado);
    context.status(201);
    }
}
