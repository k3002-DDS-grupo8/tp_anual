package Dominio.localizacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Lugar {
    @JsonProperty("nombre")
    final String nombre;
    @JsonProperty("id")
    private int id;

    @JsonCreator
    public Lugar(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
