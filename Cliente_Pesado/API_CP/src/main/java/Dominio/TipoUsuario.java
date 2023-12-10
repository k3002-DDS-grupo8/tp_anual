package Dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoUsuario {
    @JsonProperty("id")
    private long id;
    @JsonProperty("nombre")
    private String nombre;

    @JsonCreator
    public TipoUsuario(@JsonProperty("id") long id, @JsonProperty("nombre") String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
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
