package Dominio;
import java.time.LocalDateTime;

public class Incidente {
    private long id;
    private long idComunidad;
    private long idServicio;
    String observaciones;
    private EstadoIncidente estado;
    private LocalDateTime horarioDeApertura;
    private LocalDateTime horarioDeCierre;
    private long idUsuarioApertura;
    private long idUsuarioCierre;

    public Incidente() {
        this.id = 1;
        this.idComunidad = 1;
        this.idServicio = 1;
        this.observaciones = "";
        this.estado = EstadoIncidente.ABIERTO;
        this.horarioDeApertura = LocalDateTime.now();
        this.horarioDeCierre = null;
        this.idUsuarioApertura = 1;
        this.idUsuarioCierre = 0;
    }

    public Incidente(long id, long idComunidad, long idServicio, String observaciones, String estado, long idUsuarioCierre) {
        this.id = id;
        this.idComunidad = idComunidad;
        this.idServicio = idServicio;
        this.observaciones = observaciones;
        this.estado = EstadoIncidente.valueOf(estado);
        this.horarioDeApertura = LocalDateTime.now();
        this.horarioDeCierre = null;
        this.idUsuarioApertura = idUsuarioCierre;
        this.idUsuarioCierre = 0;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdComunidad(long idComunidad) {
        this.idComunidad = idComunidad;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setEstado(EstadoIncidente estado) {
        this.estado = estado;
    }

    public void setHorarioDeApertura(LocalDateTime horarioDeApertura) {
        this.horarioDeApertura = horarioDeApertura;
    }

    public void setHorarioDeCierre(LocalDateTime horarioDeCierre) {
        this.horarioDeCierre = horarioDeCierre;
    }

    public void setIdUsuarioApertura(long idUsuarioApertura) {
        this.idUsuarioApertura = idUsuarioApertura;
    }

    public void setIdUsuarioCierre(long idUsuarioCierre) {
        this.idUsuarioCierre = idUsuarioCierre;
    }

    public long getId() {
        return id;
    }

    public long getIdComunidad() {
        return idComunidad;
    }

    public long getIdServicio() {
        return idServicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public EstadoIncidente getEstado() {
        return estado;
    }

    public LocalDateTime getHorarioDeApertura() {
        return horarioDeApertura;
    }

    public LocalDateTime getHorarioDeCierre() {
        return horarioDeCierre;
    }

    public long getIdUsuarioApertura() {
        return idUsuarioApertura;
    }

    public long getIdUsuarioCierre() {
        return idUsuarioCierre;
    }
}
