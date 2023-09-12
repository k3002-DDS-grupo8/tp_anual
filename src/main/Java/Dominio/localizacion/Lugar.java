package Dominio.localizacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Lugar {
    final String nombre;
    private int id;

    public Lugar(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}