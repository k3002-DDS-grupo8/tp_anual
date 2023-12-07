package Presentacion;

import Dominio.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;

public class PostIncidenteHandler implements Handler{

    private final RepoIncidente repoIncidente;

    public PostIncidenteHandler() {
        this.repoIncidente = new RepoIncidente();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String bodyString = context.body();
        Incidente incidente = context.bodyAsClass(Incidente.class);
        System.out.println("Creando incidente: " + bodyString);
        System.out.println(incidente);
        //validarNuevaMascota(incidente);
        context.status(201);
    }

    /*private void validarNuevaMascota(Incidente mascota) {
        if (mascota.getNombre() == null) {
            throw new IllegalArgumentException("El nombre es obligatorio, elegí otro");
        }
    }*/

}
