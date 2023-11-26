package Dominio.incidente;
import Dominio.comunidad.Usuario;
import Dominio.localizacion.Localizacion;
import Dominio.servicios.Servicio;

import Dominio.comunidad.Comunidad;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    Comunidad comunidad;
    @OneToOne
    Servicio servicio;
    @OneToOne
    Usuario usuarioOpen;
    @OneToOne
    Usuario usuarioClose;
    String observaciones;
    public EstadoIncidente estado = EstadoIncidente.ABIERTO;
    public LocalDateTime horarioDeApertura = LocalDateTime.now();
    public LocalDateTime horarioDeCierre;
    public float tiempoFueraDeServicio;


    public void cerrar() {
        this.estado = EstadoIncidente.CERRADO;
        tiempoFueraDeServicio = ChronoUnit.SECONDS.between(LocalDateTime.now(), horarioDeApertura);
        horarioDeCierre = LocalDateTime.now();
    }

    public void importancia() {}

    public Localizacion getLocalizacionIncidente() {
        return this.servicio.establecimiento.ubicacionGeografica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdComunidad() {
        return comunidad.getId();
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
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
        return usuarioOpen.getId();
    }

    public void setIdUsuarioApertura(Usuario usuarioApertura) {
        this.usuarioOpen = usuarioApertura;
    }

    public long getIdUsuarioCierre() {
        return usuarioClose.getId();
    }

    public void setIdUsuarioCierre(Usuario usuarioCierre) {
        this.usuarioClose = usuarioCierre;
    }

    public Incidente(long idComunidad, long idServicio, Usuario usuarioApertura, String observaciones) {
        this.comunidad = comunidad;
        this.servicio = servicio;
        this.observaciones = observaciones;
        this.estado = EstadoIncidente.ABIERTO;
        this.horarioDeApertura = LocalDateTime.now();
        this.horarioDeCierre = null;
        this.usuarioOpen = usuarioApertura;
        this.usuarioClose = null;
    }

    public void actualizarEstado(EstadoIncidente nuevoEstado) {
    }
}
