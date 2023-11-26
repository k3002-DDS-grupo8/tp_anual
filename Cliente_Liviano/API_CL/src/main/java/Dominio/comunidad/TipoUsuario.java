package Dominio.comunidad;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoUsuario {
    @Id
    private long id;
    private String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public TipoUsuario(long id, String nombre) {
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