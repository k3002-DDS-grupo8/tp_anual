package main.entidad;
import main.servicio.Servicio;
import main.servicio.GrupoServicios;

public class Establecimiento {
    final String nombre;
    final String ubicacionGeografica;
    final GrupoServicios[] grupoServicios;
    final Servicio[] servicios;

    public Establecimiento(String nombre, String ubicacionGeografica, GrupoServicios[] grupoServicios, Servicio[] servicios) {
        this.nombre = nombre;
        this.ubicacionGeografica = ubicacionGeografica;
        this.grupoServicios = grupoServicios;
        this.servicios = servicios;
    }
}