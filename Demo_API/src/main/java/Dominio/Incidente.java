package Dominio;
import java.time.LocalDateTime;

public class Incidente {
    private long id;
    private long idComunidad;
    private long idServicio;
    private LocalDateTime horarioDeApertura;
    private LocalDateTime horarioDeCierre;
    private long idUsuarioApertura;
    private long idUsuarioCierre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(long idComunidad) {
        this.idComunidad = idComunidad;
    }

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
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
        return idUsuarioApertura;
    }

    public void setIdUsuarioApertura(long idUsuarioApertura) {
        this.idUsuarioApertura = idUsuarioApertura;
    }

    public long getIdUsuarioCierre() {
        return idUsuarioCierre;
    }

    public void setIdUsuarioCierre(long idUsuarioCierre) {
        this.idUsuarioCierre = idUsuarioCierre;
    }



    public Incidente() {
        this.idComunidad = 101;
        this.idServicio = 102;
        this.horarioDeApertura = LocalDateTime.now();
        this.horarioDeCierre = null;
        this.idUsuarioApertura = 103;
        this.idUsuarioCierre = 0;
    }
    public Incidente(long idComunidad, long idServicio, long idUsuarioApertura) {
        this.idComunidad = idComunidad;
        this.idServicio = idServicio;
        this.horarioDeApertura = LocalDateTime.now();
        this.horarioDeCierre = null;
        this.idUsuarioApertura = idUsuarioApertura;
        this.idUsuarioCierre = 0;
    }
}
