package main.servicio;

public class GrupoServicios {
    final String nombre;
    final Servicio[] servicio;

    public GrupoServicios(String nombre, Servicio[] servicio) {
        this.nombre = nombre;
        this.servicio = servicio;
    }
}