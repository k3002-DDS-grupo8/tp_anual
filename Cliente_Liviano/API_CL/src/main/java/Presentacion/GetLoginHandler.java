package Presentacion;

import Dominio.comunidad.Usuario;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoUsuario;
import java.util.Optional;

public class GetLoginHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) throws Exception {
            String username = context.sessionAttribute("username");
            System.out.println(username);
            if(context.sessionAttribute("username") != null) {
                context.redirect("http://localhost:7070/api/obtenerComunidades");
            } else {
                context.render("templates/inicio_sesion.mustache");
            }

    }
}