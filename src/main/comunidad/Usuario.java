package main.comunidad;
import main.entidad.EntidadPrestadora;
import main.incidente.EstadoIncidente;
import main.incidente.Incidente;
import main.notificacion.AdapterNotificacion;
import main.notificacion.Notificacion;
import main.servicio.Servicio;
import main.localizacion.Localizacion;

import java.util.ArrayList;

public class Usuario {
    final String nombre;
    final String email;
    final Servicio[] serviciosDeInteres;
    public Localizacion localizacionDeInteres;
    public Localizacion localizacionActual;
    EntidadPrestadora[] entidadesPrestadorasFav;
    ArrayList<Comunidad> comunidades;

    public Usuario(String nombre, String email, Servicio[] serviciosDeInteres, Localizacion localizacionActual, ArrayList<Comunidad> comunidades) {
        this.nombre = nombre;
        this.email = email;
        this.serviciosDeInteres = serviciosDeInteres;
        this.localizacionActual = localizacionActual;
        this.comunidades = comunidades;
    }

    public void agregarNuevoIncidente(Servicio servicioAfectado, String observaciones) {
        // Por cada una de las comunidades a las que pertenece el Usuario, creo un incidente.
        comunidades.forEach((comunidad -> {
            Incidente incidenteReportado = new Incidente(comunidad, observaciones);
            comunidad.notificarIncidente(incidenteReportado);
        }));
    }
    public void actualizarLocalizacionActual(Localizacion nuevaLocalizacion) {
        localizacionActual = nuevaLocalizacion;
    }

    public void actualizarEstadoIncidente(Incidente incidente, EstadoIncidente nuevoEstado) {
        incidente.actualizarEstado(nuevoEstado);
    }

    public void unirseComunidad(Comunidad comunidad) {
        comunidades.add(comunidad);
    }

    public void notificar(AdapterNotificacion notificacion) {}

    public Localizacion getLocalizacionActual() { return localizacionActual; }

}