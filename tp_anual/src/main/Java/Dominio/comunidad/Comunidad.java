package Dominio.comunidad;
import Dominio.incidente.EstadoIncidente;
import Dominio.incidente.Incidente;
import Dominio.notificacion.AdapterNotificacion;
import Dominio.notificacion.Notificacion;
import Dominio.servicio.GrupoServicios;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    final String nombre;
    ArrayList<MiembroComunidad> miembros;
    GrupoServicios[] serviciosDeInteres;
    @OneToMany
    List<Incidente> incidentes;
    private int puntosConfianza;
    private String gradoConfianza;
    private boolean activo;

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





