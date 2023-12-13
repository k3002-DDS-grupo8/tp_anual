package Dominio.comunidad;
import Dominio.incidente.EstadoIncidente;
import Dominio.incidente.Incidente;
import Dominio.notificacion.AdapterNotificacion;
import Dominio.servicios.Servicio;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    final String nombre;
    @Transient
    List<MiembroComunidad> miembros;
   @OneToMany //en db deberia llamarse serviciosDeInteres
   List<Servicio> serviciosDeInteres;


    @Transient
    List<Incidente> incidentes;
    private GradoConfianza gradoConfianza;
    private boolean activo;

    public Comunidad(String nombre, ArrayList<MiembroComunidad> miembros, ArrayList<Servicio> serviciosDeInteres) {
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

    public void asignarAdministrador(MiembroComunidad miembro){
        //miembro.cambiarTipoUsuario(1);
    }

    public void agregarAComunidad(MiembroComunidad nuevoMiembro){
        miembros.add(nuevoMiembro);
    }
}






