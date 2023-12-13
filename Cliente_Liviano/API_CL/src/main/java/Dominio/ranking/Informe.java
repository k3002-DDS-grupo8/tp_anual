package Dominio.ranking;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Informe {

    @JsonProperty("detalle")
    private String detalle;
    @JsonProperty("fecha")
    private LocalDateTime fecha;
    @JsonProperty("posicion")
    private Integer posicion;
    @JsonProperty("entidad_id")
    private long entidad_id;

    @JsonProperty("entidad_nombre")
    private String entidad_nombre;

    @JsonProperty("ranking_id")
    private long ranking_id;

    public Informe(@JsonProperty("detalle") String detalle,@JsonProperty("fecha") LocalDateTime fecha, @JsonProperty("posicion") Integer posicion, @JsonProperty("entidad_id") long entidad_id, @JsonProperty("entidad_nombre") String entidad_nombre ,@JsonProperty("ranking_id") long ranking_id) {
        this.detalle = detalle;
        this.fecha = fecha;
        this.posicion = posicion;
        this.entidad_id = entidad_id;
        this.entidad_nombre = entidad_nombre;
        this.ranking_id = ranking_id;
    }
    public Informe(){}

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public long getEntidad_id() {
        return entidad_id;
    }

    public void setEntidad_id(long entidad_id) {
        this.entidad_id = entidad_id;
    }

    public String getEntidad_nombre() {
        return entidad_nombre;
    }

    public void setEntidad_nombre(String entidad_nombre) {
        this.entidad_nombre = entidad_nombre;
    }

    public long getRanking_id() {
        return ranking_id;
    }

    public void setRanking_id(long ranking_id) {
        this.ranking_id = ranking_id;
    }
}