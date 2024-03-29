package Dominio.comunidad;
import Dominio.entidad.EntidadPrestadora;
import Dominio.incidente.EstadoIncidente;
import Dominio.incidente.Incidente;
import Dominio.notificacion.AdapterNotificacion;
import Dominio.servicios.Servicio;
import Dominio.localizacion.Localizacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    @Id
    private long id;
    final String nombre;
    final String email;
    private String contrasenia;
    final String telefono;

    //servicio cambia a Servicios
    @ManyToMany //esto en db deberia llamarse serviciosDeInteres
    final List<Servicio> serviciosDeInteres;
    @Transient
    Localizacion localizacionDeInteres;
    @Transient
    Localizacion localizacionActual;
    @OneToMany //esto en db deberia llamarse entidadesPrestadorasFav
    List<EntidadPrestadora> entidadesPrestadorasFav;
    @Transient
    List<Comunidad> comunidades;
    private float puntosConfianza;
    private GradoConfianza gradoConfianza;
    private boolean activo;

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
    
    public String getTelefono() {return telefono;}
    public List<Servicio> getServiciosDeInteres() {
        return serviciosDeInteres;
    }

    public Localizacion getLocalizacionDeInteres() {
        return localizacionDeInteres;
    }

    public void setLocalizacionDeInteres(Localizacion localizacionDeInteres) {
        this.localizacionDeInteres = localizacionDeInteres;
    }

    public void setLocalizacionActual(Localizacion localizacionActual) {
        this.localizacionActual = localizacionActual;
    }

    public List<EntidadPrestadora> getEntidadesPrestadorasFav() {
        return entidadesPrestadorasFav;
    }

    public void setEntidadesPrestadorasFav(List<EntidadPrestadora> entidadesPrestadorasFav) {
        this.entidadesPrestadorasFav = entidadesPrestadorasFav;
    }

    public List<Comunidad> getComunidades() {
        return comunidades;
    }

    public void setComunidades(ArrayList<Comunidad> comunidades) {
        this.comunidades = comunidades;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public Usuario(String nombre, String email, String contrasenia, String telefono, ArrayList<Servicio> serviciosDeInteres, Localizacion localizacionActual, ArrayList<Comunidad> comunidades) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
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
