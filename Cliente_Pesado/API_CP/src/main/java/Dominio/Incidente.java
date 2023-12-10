package Dominio;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Incidente {
    @JsonProperty("id")
    private long id;
    @JsonProperty("idComunidad")
    private long idComunidad;
    @JsonProperty("idServicio")
    private long idServicio;
    @JsonProperty("observaciones")
    String observaciones;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("horarioDeApertura")
    private LocalDateTime horarioDeApertura;
    @JsonProperty("horarioDeCierre")
    private LocalDateTime horarioDeCierre;
    @JsonProperty("idUsuarioApertura")
    private long idUsuarioApertura;
    @JsonProperty("idUsuarioCierre")
    private long idUsuarioCierre;

    public Incidente() {
        this.id = 1;
        this.idComunidad = 1;
        this.idServicio = 1;
        this.observaciones = "";
        this.estado = "ABIERTO";
        this.horarioDeApertura = null;
        this.horarioDeCierre = null;
        this.idUsuarioApertura = 1;
        this.idUsuarioCierre = 0;
    }

    @JsonCreator
    public Incidente(@JsonProperty("id") long id, @JsonProperty("idComunidad") long idComunidad, @JsonProperty("idServicio") long idServicio, @JsonProperty("observaciones") String observaciones, @JsonProperty("estado") String estado, @JsonProperty("idUsuarioCierre") long idUsuarioCierre) {
        this.id = id;
        this.idComunidad = idComunidad;
        this.idServicio = idServicio;
        this.observaciones = observaciones;
        this.estado = estado;
        this.horarioDeApertura = null;
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

    public void setEstado(String estado) {
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

    public String getEstado() {
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
