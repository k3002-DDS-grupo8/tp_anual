package Dominio.comunidad;

import Dominio.incidente.Incidente;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class MiembroComunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMiembro;
    @OneToOne
    final UsuarioPersona usuario;
    @OneToOne
    final Comunidad comunidad;

    @Enumerated
    Optional<TipoUsuario> tipoUsuario;

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