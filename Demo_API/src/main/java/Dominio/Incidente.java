package Dominio;
import java.time.LocalDateTime;

public class Incidente {
    private long id;
    private long idComunidad;
    private long idServicio;
    private String estado;
    public LocalDateTime horarioDeApertura;
    public LocalDateTime horarioDeCierre;

    public Incidente(long id, long idComunidad, long idServicio, String estado, LocalDateTime horarioDeApertura, LocalDateTime horarioDeCierre) {
        this.id = id;
        this.idComunidad = idComunidad;
        this.idServicio = idServicio;
        this.estado = estado;
        this.horarioDeApertura = horarioDeApertura;
        this.horarioDeCierre = horarioDeCierre;
    }
}
