package Dominio.localizacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    final int id;
    final String nombre;

    public Lugar(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}