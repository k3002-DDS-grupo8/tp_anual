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

    @Enumerated
    Rol rol;

    public MiembroComunidad(UsuarioPersona usuario, Rol rol, Comunidad comunidad) {
        this.usuario = usuario;
        this.rol = rol;
        this.comunidad = comunidad;
    }

    public void cambiarRol(Rol nuevoRol){
        this.rol = nuevoRol;
    }

    public void cerrarIncidente(Incidente incidente){
        incidente.cerrar();
    }
}