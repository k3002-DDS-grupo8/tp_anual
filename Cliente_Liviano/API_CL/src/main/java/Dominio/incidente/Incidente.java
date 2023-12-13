package Dominio.incidente;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Incidente {


    @JsonProperty("id")
    private long id;
    @JsonProperty("comunidadId")
    private long comunidadId;
    @JsonProperty("servicioId")
    private long servicioId;
    @JsonProperty("usuarioAperturaId")
    private long usuarioAperturaId;
    @JsonProperty("usuarioCierreId")
    private long usuarioCierreId;
    @JsonProperty("observaciones")
    private String observaciones;
    @JsonProperty("estado")
    private String estado;

    @JsonCreator
    public Incidente(@JsonProperty("id") long id, @JsonProperty("comunidadId") long comunidadId, @JsonProperty("servicioId") long servicioId, @JsonProperty("usuarioAperturaId") long usuarioAperturaId, @JsonProperty("usuarioCierreId") long usuarioCierreId, @JsonProperty("observaciones") String observaciones, @JsonProperty("estado") String estado) {
        this.id = id;
        this.comunidadId = comunidadId;
        this.servicioId = servicioId;
        this.usuarioAperturaId = usuarioAperturaId;
        this.usuarioCierreId = usuarioCierreId;
        this.observaciones = observaciones;
        this.estado = estado;
    }
    public Incidente() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(long comunidadId) {
        this.comunidadId = comunidadId;
    }

    public long getServicioId() {
        return servicioId;
    }

    public void setServicioId(long servicioId) {
        this.servicioId = servicioId;
    }

    public long getUsuarioAperturaId() {
        return usuarioAperturaId;
    }

    public void setUsuarioAperturaId(long usuarioAperturaId) {
        this.usuarioAperturaId = usuarioAperturaId;
    }

    public long getUsuarioCierreId() {
        return usuarioCierreId;
    }

    public void setUsuarioCierreId(long usuarioCierreId) {
        this.usuarioCierreId = usuarioCierreId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}