package main.comunidad;
import main.servicio.Servicio;
import main.localizacion.Localizacion;

public class UsuarioPersona extends Usuario {
    final String apellido;

    public UsuarioPersona(String nombre, String email, Servicio[] serviciosDeInteres, Localizacion localizacion, String apellido) {
        super(nombre, email, serviciosDeInteres, localizacion);
        this.apellido = apellido;
    }
}