package Dominio.comunidad;
import Dominio.incidente.EstadoIncidente;
import Dominio.incidente.Incidente;
import Dominio.notificacion.AdapterNotificacion;
import Dominio.servicios.Servicio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static Dominio.comunidad.Rol.ADMINISTRADOR;

@Entity
public class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    final String nombre;
    ArrayList<MiembroComunidad> miembros;
    Servicio[] serviciosDeInteres;

    @OneToMany
    List<Incidente> incidentes;
    private GradoConfianza gradoConfianza;
    private boolean activo;

    public Comunidad(String nombre, ArrayList<MiembroComunidad> miembros, Servicio[] serviciosDeInteres) {
        this.nombre = nombre;
        this.miembros = miembros;
        this.serviciosDeInteres = serviciosDeInteres;
    }


    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void notificarIncidente(Incidente incidente) {
        incidentes.add(incidente);
    }
// consultarIndcidentesSegunEstado deberia ser private
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

    public void asignarAdministrador(MiembroComunidad miembro){
        miembro.cambiarRol(ADMINISTRADOR);
    }

    public void agregarAComunidad(MiembroComunidad nuevoMiembro){
        miembros.add(nuevoMiembro);
    }
}






