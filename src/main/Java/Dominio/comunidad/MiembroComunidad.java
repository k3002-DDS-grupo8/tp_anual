package Dominio.comunidad;

import javax.persistence.*;

@Entity
public class MiembroComunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMiembro;
    @OneToOne
    final Usuario usuario;
    @OneToOne
    final Comunidad comunidad;

    @Enumerated
    Rol rol;

    public MiembroComunidad(Usuario usuario, Rol rol, Comunidad comunidad) {
        this.usuario = usuario;
        this.rol = rol;
        this.comunidad = comunidad;
    }

    public void CambiarRol(Rol nuevoRol){
        this.rol = nuevoRol;
    }
}