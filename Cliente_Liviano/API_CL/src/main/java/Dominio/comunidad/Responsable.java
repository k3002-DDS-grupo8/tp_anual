package Dominio.comunidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Responsable {

    @JsonProperty("nombre")
    final String nombre;
    @JsonProperty("email")
    final String email;

    @JsonCreator
    public Responsable(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}