package main.comunidad;

public class MiembroComunidad {
    final Usuario usuario;
    Rol rol;

    public MiembroComunidad(Usuario usuario, Rol rol) {
        this.usuario = usuario;
        this.rol = rol;
    }
}