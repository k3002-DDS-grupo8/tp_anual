package Dominio.comunidad;
import Dominio.localizacion.Localizacion;
import Dominio.servicio.Servicio;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class EEO extends Usuario {
    @Transient
    final Responsable responsable;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public EEO(String nombre, String email, ArrayList<Servicio> serviciosDeInteres, Localizacion localizacion, Responsable responsable, ArrayList<Comunidad> comunidades) {
        super(nombre, email, serviciosDeInteres, localizacion, comunidades);
        this.responsable = responsable;
    }
}