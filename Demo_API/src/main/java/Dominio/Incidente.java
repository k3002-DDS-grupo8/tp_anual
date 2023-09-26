package Dominio;
import java.time.LocalDateTime;

public class Incidente {
    private long id;
    private long idComunidad;
    private long idServicio;
    private String estado;
    private LocalDateTime horarioDeApertura;
    private LocalDateTime horarioDeCierre;
    private long idUsuarioOpen;
    private long idUsuarioClose;

    public Incidente(long id, long idComunidad, long idServicio, String estado, LocalDateTime horarioDeApertura, LocalDateTime horarioDeCierre, long idUsuarioOpen, long idUsuarioClose) {
        this.id = id;
        this.idComunidad = idComunidad;
        this.idServicio = idServicio;
        this.estado = estado;
        this.horarioDeApertura = horarioDeApertura;
        this.horarioDeCierre = horarioDeCierre;
        this.idUsuarioOpen = idUsuarioOpen;
        this.idUsuarioClose = idUsuarioClose;
    }
}
