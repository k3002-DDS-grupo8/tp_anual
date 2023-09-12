package Dominio.comunidad;
import Dominio.servicio.Servicio;
import Dominio.localizacion.Localizacion;

import java.util.ArrayList;

public class UsuarioPersona extends Usuario {
    final String apellido;

    public UsuarioPersona(String nombre, String email, ArrayList<Servicio> serviciosDeInteres, Localizacion localizacion, String apellido, ArrayList<Comunidad> comunidades) {
        super(nombre, email, serviciosDeInteres, localizacion, comunidades);
        this.apellido = apellido;
    }
}