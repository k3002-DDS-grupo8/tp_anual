package main.comunidad;
import main.incidente.EstadoIncidente;
import main.incidente.Incidente;
import main.notificacion.AdapterNotificacion;
import main.notificacion.Notificacion;
import main.servicio.GrupoServicios;

import java.util.ArrayList;

public class Comunidad {
    final String nombre;
    ArrayList<MiembroComunidad> miembros;
    GrupoServicios[] serviciosDeInteres;
    ArrayList<Incidente> incidentes;

    public Comunidad(String nombre, ArrayList<MiembroComunidad> miembros, GrupoServicios[] serviciosDeInteres) {
        this.nombre = nombre;
        this.miembros = miembros;
        this.serviciosDeInteres = serviciosDeInteres;
    }

    public void notificarIncidente(Incidente incidente) {
        incidentes.add(incidente);
    }

    public ArrayList<Incidente> consultarIncidentesSegunEstado(EstadoIncidente estadoSolicitado) {
        ArrayList<Incidente> incidentesDeseados = (ArrayList<Incidente>) incidentes.stream().filter((Incidente incidenteActual) -> incidenteActual.estado == estadoSolicitado);
        return incidentesDeseados;
    }
    public void notificarIncidenteCercano() {
        ArrayList<Incidente> incidentesAbiertos = consultarIncidentesSegunEstado(EstadoIncidente.ABIERTO);
        miembros.forEach(miembroComunidad -> {
            Usuario usuarioComunidad = miembroComunidad.usuario;
            incidentesAbiertos.forEach(incidenteAbierto -> {
                if(usuarioComunidad.getLocalizacionActual().estaEnCercania(incidenteAbierto.getLocalizacionIncidente())) {
                    AdapterNotificacion notificacion = new AdapterNotificacion();
                    usuarioComunidad.notificar(notificacion);
                }
            });
        });
    }

}





