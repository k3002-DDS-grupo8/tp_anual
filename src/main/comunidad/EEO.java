package main.comunidad;
import main.localizacion.Localizacion;
import main.servicio.Servicio;

public class EEO extends Usuario {
    final Responsable responsable;

    public EEO(String nombre, String email, Servicio[] serviciosDeInteres, Localizacion localizacion, Responsable responsable) {
        super(nombre, email, serviciosDeInteres, localizacion);
        this.responsable = responsable;
    }
}