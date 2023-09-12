package Dominio.comunidad;
import Dominio.servicio.Servicio;
import Dominio.localizacion.Localizacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class UsuarioPersona extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    final String apellido;

    public UsuarioPersona(String nombre, String email, ArrayList<Servicio> serviciosDeInteres, Localizacion localizacion, String apellido, ArrayList<Comunidad> comunidades) {
        super(nombre, email, serviciosDeInteres, localizacion, comunidades);
        this.apellido = apellido;
    }
}