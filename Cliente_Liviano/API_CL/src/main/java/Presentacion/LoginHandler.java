package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class LoginHandler implements Handler {

    private final Repos repoDueños;

    public LoginHandler() {
        this.repoDueños = new RepositorioDueños();
    }
    @Override
    public void handle(@NotNull Context context) throws Exception {

    }
}
