package Dominio.comunidad;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Responsable {
    final String nombre;
    @Id
    final String email;

    public Responsable(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}