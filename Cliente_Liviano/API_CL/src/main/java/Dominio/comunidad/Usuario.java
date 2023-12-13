package Dominio.comunidad;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Usuario {
    @JsonProperty("id")
    long id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("email")
    private String email;
    @JsonProperty("contrasenia")
    private String contrasenia;



    @JsonCreator
    public Usuario(@JsonProperty("id") long id, @JsonProperty("nombre") String nombre, @JsonProperty("email") String email, @JsonProperty("contrasenia") String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}




