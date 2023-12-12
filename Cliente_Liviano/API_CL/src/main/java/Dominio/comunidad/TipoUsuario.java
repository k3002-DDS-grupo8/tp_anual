package Dominio.comunidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoUsuario {
    @JsonProperty("id")
    private long id;
    @JsonProperty("nombre")
    private String nombre;

    public String getNombre() {
        return this.nombre;
    }

    @JsonCreator
    public TipoUsuario(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    @JsonCreator
    public TipoUsuario() {
        this.id = 0;
        this.nombre = "";
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}