package Dominio.comunidad;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Comunidad {

    @JsonProperty("id")
    private long id;
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("activo")
    private boolean activo;


    @JsonCreator
    public Comunidad(@JsonProperty("id") long id, @JsonProperty("idComunidad") String nombre, @JsonProperty("activo") boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}