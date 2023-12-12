package Dominio.comunidad;
import Dominio.comunidad.TipoUsuario;
import Dominio.incidente.EstadoIncidente;
import Dominio.incidente.Incidente;
import Dominio.notificacion.AdapterNotificacion;
import Dominio.servicios.Servicio;
import Dominio.comunidad.GradoConfianza;
import Dominio.servicios.Servicios;
import persistencia.RepoTipoUsuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
public class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nombre;
    ArrayList<MiembroComunidad> miembros;
    ArrayList<Servicios> serviciosDeInteres;

    @OneToMany
    List<Incidente> incidentes;

    private GradoConfianza gradoConfianza;
    private boolean activo;

    public Comunidad() {}

    public Comunidad(String nombre, ArrayList<MiembroComunidad> miembros, ArrayList<Servicios> serviciosDeInteres, List<Incidente> incidentes, GradoConfianza gradoConfianza, boolean activo) {
        this.nombre = nombre;
        this.miembros = miembros;
        this.serviciosDeInteres = serviciosDeInteres;
        this.incidentes = incidentes;
        this.gradoConfianza = gradoConfianza;
        this.activo = activo;
    }

    public long getId() {
        return id;
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
        RepoTipoUsuario repoTipos = new RepoTipoUsuario();
        List<TipoUsuario> tipos = repoTipos.obtenerTodos();
        Optional<TipoUsuario> administrador = tipos.stream().filter(t -> t.getNombre() == "Administrador" ).findFirst();
        miembro.cambiarTipoUsuario(administrador);
    }

    public void agregarAComunidad(MiembroComunidad nuevoMiembro){
        miembros.add(nuevoMiembro);
    }
}






