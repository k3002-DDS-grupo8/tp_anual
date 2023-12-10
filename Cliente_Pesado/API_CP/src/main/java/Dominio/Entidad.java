package Dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Entidad {
    @JsonProperty("id")
    private long id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("email")
    private String email;
    @JsonProperty("descripcion")
    private String descripcion;

    public Entidad() {
        this.id = 1;
        this.nombre = "hola";
        this.email = "hola@.com";
        this.descripcion = "hola + hola";
    }

    @JsonCreator
    public Entidad(@JsonProperty("id") long id,  @JsonProperty("nombre") String nombre, @JsonProperty("email") String email, @JsonProperty("descripcion") String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.descripcion = descripcion;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
