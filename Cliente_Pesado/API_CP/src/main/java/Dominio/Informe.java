package Dominio;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Informe {
    @JsonProperty("ranking_detalle")
    private String ranking_detalle;
    @JsonProperty("fecha")
    private LocalDateTime fecha;
    @JsonProperty("posicion")
    private Integer posicion;
    @JsonProperty("entidad_id")
    private long entidad_id;
    @JsonProperty("entidad_nombre")
    private String entidad_nombre;

    public Informe() {
        this.ranking_detalle = "";
        this.fecha = null;
        this.posicion = 0;
        this.entidad_id = 0;
        this.entidad_nombre = "";
    }

    @JsonCreator
    public Informe(@JsonProperty("ranking_detalle") String ranking_detalle, @JsonProperty("fecha") LocalDateTime fecha, @JsonProperty("posicion") Integer posicion, @JsonProperty("entidad_id") long entidad_id, @JsonProperty("entidad_nombre") String entidad_nombre) {
        this.ranking_detalle = ranking_detalle;
        this.fecha = fecha;
        this.posicion = posicion;
        this.entidad_id = entidad_id;
        this.entidad_nombre = entidad_nombre;
    }

    public String getRanking_detalle() {
        return ranking_detalle;
    }

    public void setRanking_detalle(String ranking_detalle) {
        this.ranking_detalle = ranking_detalle;
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
}
