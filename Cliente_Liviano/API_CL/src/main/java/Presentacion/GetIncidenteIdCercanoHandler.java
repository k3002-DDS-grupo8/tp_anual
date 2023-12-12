package Presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.RepoIncidente;
import Dominio.incidente.Incidente;

import java.util.Optional;

public class GetIncidenteIdCercanoHandler implements Handler {

    private RepoIncidente repoIncidente;

    public GetIncidenteIdCercanoHandler() {
        this.repoIncidente = new RepoIncidente();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idUsuario", Integer.class).get();

        final Optional<Incidente> resultadoBusqueda = repoIncidente.obtenerCercanos(idBuscado).stream().findFirst();

        if(resultadoBusqueda.isPresent()) {
            context.status(200).json(resultadoBusqueda.get());
        } else {
            context.status(404);
        }
    }
}

// @FEDE este requerimiento implica que en la seccion de notificaciones de nuestra
// pagina aparezca una notificacion con descripcion del incidente, sobre que servicio
// es el incidente, y dos botones para cerrar o ignorar. Si el usuario toca ignorar,
// no hace nada. si el usuario toca cerrar, se cierra el incidente.
// El trigger de la notificacion deberia ser la deteccion de cercania, pero por ahora
// no pudimos resolver eso y no creo que lo hagamos. Otros grupos hicieron un boton
// en la pagina que sea tipo "simulacion de notificacion" que al tocarlo dispara una
// notificacion. Sino se me ocurre que podria haber siempre una notificacion en la
// seccion de notificaciones y que cerrar un incidente implique que esa notificacion
// desaparezca y aparezca otra.



// en un repo miembro comunidad SELECT * FROM miembrocomunidad

// Primero comunidades del usuario en un array
// para cada comunidad, obtener incidentes con sus ubicaciones
// chequear que ubicacion usuario == ubicacion incidente

// chequear que iDMiembro = idUsuario && usuario.ubicacion == incidente.servicio.establecimiento.ubicacion &&  (select * from miembroComunidad where idMiembro == idUsuario) miembrocomunidad.comunidad = comunidad.id

// select Comunidad.idIncidente from MiembroComunidad
// join Comunidad on Comunidad.id = idComunidad
// join Incidente on Incidente.id = Comunidad.idIncidente
// where idUsuario = idBuscado and incidente.estado = 0