package main.comunidad;
import main.servicio.Servicio;
import main.localizacion.Localizacion;

public class Usuario {
    final String nombre;
    final String email;
    final Servicio[] serviciosDeInteres;
    final Localizacion localizacion;

    public Usuario(String nombre, String email, Servicio[] serviciosDeInteres, Localizacion localizacion) {
        this.nombre = nombre;
        this.email = email;
        this.serviciosDeInteres = serviciosDeInteres;
        this.localizacion = localizacion;
    }
}