package main.comunidad;
import main.servicio.GrupoServicios;

public class Comunidad {
    final String nombre;
    MiembroComunidad[] miembros;
    GrupoServicios[] serviciosDeInteres;

    public Comunidad(String nombre, MiembroComunidad[] miembros, GrupoServicios[] serviciosDeInteres) {
        this.nombre = nombre;
        this.miembros = miembros;
        this.serviciosDeInteres = serviciosDeInteres;
    }
}