package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetLoginHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) throws Exception {
            String username = context.sessionAttribute("username");
            if(context.sessionAttribute("username") != null) {
                context.redirect("http://localhost:7070/api/obtenerComunidades");
            } else {
                context.render("static/inicio_sesion.mustache");
            }

    }
}