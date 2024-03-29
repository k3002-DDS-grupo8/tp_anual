package Dominio.comunidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    public long getId_TipoUsuario() {
        return id ;
    }

    public void setId_TipoUsuario(long id_TipoUsuario) {
        this.id = id_TipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario(long id_TipoUsuario, String nombre) {
        this.id = id_TipoUsuario;
        this.nombre = nombre;
    }
    public TipoUsuario() {

    }
}
