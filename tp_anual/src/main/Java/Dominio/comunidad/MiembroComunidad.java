package Dominio.comunidad;

import Dominio.incidente.Incidente;

import javax.persistence.*;

@Entity
public class MiembroComunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMiembro;
    @OneToOne
    final UsuarioPersona usuario;
    @OneToOne
    final Comunidad comunidad;
    @OneToOne
    private TipoUsuario tipoUsuario;

    public MiembroComunidad(UsuarioPersona usuario, TipoUsuario tipoUsuario, Comunidad comunidad) {
        this.usuario = usuario;
        this.tipoUsuario = tipoUsuario;
        this.comunidad = comunidad;
    }

    public void cambiarTipoUsuario(TipoUsuario id_TipoUsuario){
        this.tipoUsuario = id_TipoUsuario;
    }

    public void cerrarIncidente(Incidente incidente){
        incidente.cerrar();
    }
}