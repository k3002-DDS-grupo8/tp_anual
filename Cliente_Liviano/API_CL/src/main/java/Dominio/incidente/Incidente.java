package Dominio.incidente;
import Dominio.comunidad.Usuario;
import Dominio.localizacion.Localizacion;
import Dominio.servicios.Servicio;

import Dominio.comunidad.Comunidad;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Incidente {

   
   @JsonProperty("id")
    private long id;
   @JsonProperty("comunidad")
    long comunidad;
   @JsonProperty("servicio")
    long servicio;
   @JsonProperty("usuarioOpen")
    long usuarioOpen;
   @JsonProperty("usuarioClose")
    long usuarioClose;
    @JsonProperty("observaciones")
    String observaciones;
    @JsonProperty("estado")
    public EstadoIncidente estado = EstadoIncidente.ABIERTO;
    @JsonProperty("horarioDeApertura")
    public LocalDateTime horarioDeApertura = LocalDateTime.now();
    @JsonProperty("horarioDeCierre")
    public LocalDateTime horarioDeCierre;
    @JsonProperty("tiempoFueraDeServicio")
    public float tiempoFueraDeServicio;


    public void cerrar() {
        this.estado = EstadoIncidente.CERRADO;
        tiempoFueraDeServicio = ChronoUnit.SECONDS.between(LocalDateTime.now(), horarioDeApertura);
        horarioDeCierre = LocalDateTime.now();
    }

    public void importancia() {}

    //public Localizacion getLocalizacionIncidente() {
    //    return this.servicio.establecimiento.ubicacionGeografica;
    //}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getComunidad() {
        return comunidad;
    }

    public void setComunidad(long comunidad) {
        this.comunidad = comunidad;
    }

    public long getServicio() {
        return servicio;
    }

    public void setServicio(long servicio) {
        this.servicio = servicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public EstadoIncidente getEstado() {
        return estado;
    }
    public void setEstado(EstadoIncidente estado) {
        this.estado = estado;
    }
    public LocalDateTime getHorarioDeApertura() {
        return horarioDeApertura;
    }

    public void setHorarioDeApertura(LocalDateTime horarioDeApertura) {
        this.horarioDeApertura = horarioDeApertura;
    }

    public LocalDateTime getHorarioDeCierre() {
        return horarioDeCierre;
    }

    public void setHorarioDeCierre(LocalDateTime horarioDeCierre) {
        this.horarioDeCierre = horarioDeCierre;
    }

    public long getIdUsuarioApertura() {
        return usuarioOpen;
    }

    public void setIdUsuarioApertura(long usuarioApertura) {
        this.usuarioOpen = usuarioApertura;
    }

    public long getIdUsuarioCierre() {
        return usuarioClose;
    }

    public void setIdUsuarioCierre(long usuarioCierre) {
        this.usuarioClose = usuarioCierre;
    }


    //  @FEDE para las consultas de sql aca hay algo raro, si nosotros solemos pedir idUsuarioApertura pero aca pide un usuario
    @JsonCreator
    public Incidente(long idComunidad, long idServicio, long usuarioApertura, String observaciones) {
        this.comunidad = comunidad;
        this.servicio = servicio;
        this.observaciones = observaciones;
        this.estado = EstadoIncidente.ABIERTO;
        this.horarioDeApertura = LocalDateTime.now();
        this.horarioDeCierre = null;
        this.usuarioOpen = usuarioApertura;
        this.usuarioClose = 0;
    }

    @JsonCreator
    public Incidente(long comunidad, long servicio, long usuarioApertura, String observaciones, EstadoIncidente EstadoIncidente, LocalDateTime horarioDeApertura, LocalDateTime horarioDeCierre, long usuarioCierre) {
        this.comunidad = comunidad;
        this.servicio = servicio;
        this.observaciones = observaciones;
        this.estado = EstadoIncidente;
        this.horarioDeApertura = horarioDeApertura;
        this.horarioDeCierre = horarioDeCierre;
        this.usuarioOpen = usuarioApertura;
        this.usuarioClose = usuarioCierre;
    }

    public void actualizarEstado(EstadoIncidente nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
