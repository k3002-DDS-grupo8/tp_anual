package Dominio.comunidad;

import Dominio.incidente.Incidente;

import javax.persistence.*;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MiembroComunidad {
    @JsonProperty("idMiembro")
    private long idMiembro;
    @JsonProperty("usuario")
    final UsuarioPersona usuario;
    @JsonProperty("comunidad")
    final Comunidad comunidad;
    @JsonProperty("tipoUsuario")
    Optional<TipoUsuario> tipoUsuario;

    @JsonCreator
    public MiembroComunidad(long idMiembro, UsuarioPersona usuario, Comunidad comunidad, Optional<TipoUsuario> tipoUsuario) {
        this.idMiembro = idMiembro;
        this.usuario = usuario;
        this.comunidad = comunidad;
        this.tipoUsuario = tipoUsuario;
    }

    @JsonCreator
    public MiembroComunidad(UsuarioPersona usuario, Optional<TipoUsuario> tipoUsuario, Comunidad comunidad) {
        this.usuario = usuario;
        this.tipoUsuario = tipoUsuario;
        this.comunidad = comunidad;
    }

    public void cambiarTipoUsuario(Optional<TipoUsuario> nuevoTipoUsuario){

        this.tipoUsuario = nuevoTipoUsuario;
    }

    public void cerrarIncidente(Incidente incidente){
        incidente.cerrar();
    }
}