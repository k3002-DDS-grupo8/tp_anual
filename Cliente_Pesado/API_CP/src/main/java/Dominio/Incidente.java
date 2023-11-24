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

    public Incidente(/*long idComunidad, long idServicio, long idUsuarioApertura*/) {
        this.idComunidad = 1;//idComunidad;
        this.idServicio = 1;//idServicio;
        this.observaciones = "";
        this.estado = EstadoIncidente.ABIERTO;
        this.horarioDeApertura = LocalDateTime.now();
        this.horarioDeCierre = null;
        this.idUsuarioApertura = 1;//idUsuarioApertura;
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
}
