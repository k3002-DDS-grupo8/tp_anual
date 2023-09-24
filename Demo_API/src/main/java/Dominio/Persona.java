package Dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
    @Id
    long id;
    String Nombre;
}
