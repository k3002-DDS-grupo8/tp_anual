package Dominio.incidente;
import Dominio.localizacion.Localizacion;
import Dominio.servicio.Servicio;

import Dominio.comunidad.Comunidad;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Incidente {
    Comunidad comunidad;
    Servicio servicio;
    String observaciones;
    public EstadoIncidente estado = EstadoIncidente.ABIERTO;
    public LocalDateTime horarioDeApertura = LocalDateTime.now();
    public float tiempoFueraDeServicio;

    public Incidente(Comunidad comunidad, String observaciones) {
        this.comunidad = comunidad;
        this.observaciones = observaciones;
    }

    public void cerrar() {
        this.estado = EstadoIncidente.CERRADO;
        tiempoFueraDeServicio = ChronoUnit.SECONDS.between(LocalDateTime.now(), horarioDeApertura);
    }

    public void actualizarEstado(EstadoIncidente nuevoEstado) {
        this.estado = nuevoEstado;
    }
    public void importancia() {}

    public Localizacion getLocalizacionIncidente() {
        return this.servicio.establecimiento.ubicacionGeografica;
    }

}
