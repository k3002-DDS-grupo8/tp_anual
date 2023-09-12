package Dominio.comunidad;
import Dominio.localizacion.Localizacion;
import Dominio.servicio.Servicio;

import java.util.ArrayList;

public class EEO extends Usuario {
    final Responsable responsable;

    public EEO(String nombre, String email, ArrayList<Servicio> serviciosDeInteres, Localizacion localizacion, Responsable responsable, ArrayList<Comunidad> comunidades) {
        super(nombre, email, serviciosDeInteres, localizacion, comunidades);
        this.responsable = responsable;
    }
}