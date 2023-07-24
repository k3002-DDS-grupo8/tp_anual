package main.entidad;
import main.localizacion.Localizacion;
import main.servicio.Servicio;
import main.servicio.GrupoServicios;

public class Establecimiento {
    final String nombre;
    public final Localizacion ubicacionGeografica;
    final GrupoServicios[] grupoServicios;
    final Servicio[] servicios;

    public Establecimiento(String nombre, Localizacion ubicacionGeografica, GrupoServicios[] grupoServicios, Servicio[] servicios) {
        this.nombre = nombre;
        this.ubicacionGeografica = ubicacionGeografica;
        this.grupoServicios = grupoServicios;
        this.servicios = servicios;
    }
}