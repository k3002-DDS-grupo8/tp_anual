package Dominio.comunidad;
import Dominio.entidad.EntidadPrestadora;
import Dominio.incidente.EstadoIncidente;
import Dominio.incidente.Incidente;
import Dominio.notificacion.AdapterNotificacion;
import Dominio.servicios.Servicio;
import Dominio.localizacion.Localizacion;
import Dominio.comunidad.TipoUsuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import Dominio.servicios.Servicios;
import kotlin.text.UStringsKt;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String nombre;
    private String email;
    String contrasenia;
    private String telefono;
    private float puntosConfianza;
    private GradoConfianza gradoConfianza;
    private boolean activo;

    //servicio cambia a Servicios
    @ManyToMany
    private List<Servicios> serviciosDeInteres;
    @Transient
    Localizacion localizacionDeInteres;
    @Transient
    Localizacion localizacionActual;
    @OneToMany
    List<EntidadPrestadora> entidadesPrestadorasFav;
    @ManyToMany
    List<Comunidad> comunidades;


    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
    
    public String getTelefono() {return telefono;}
    public List<Servicios> getServiciosDeInteres() {
        return serviciosDeInteres;
    }

    public Localizacion getLocalizacionDeInteres() {
        return localizacionDeInteres;
    }

    public void setGradoConfianza(GradoConfianza gradoConfianza) {
        this.gradoConfianza = gradoConfianza;
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
    
    public Usuario(String nombre, String email, String contrasenia, String telefono, ArrayList<Servicios> serviciosDeInteres, Localizacion localizacionActual, ArrayList<Comunidad> comunidades) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.serviciosDeInteres = serviciosDeInteres;
        this.localizacionActual = localizacionActual;
        this.comunidades = comunidades;
    }

    public void agregarNuevoIncidente(Comunidad comunidad, Servicio servicioAfectado, Usuario usuarioOpen, String observaciones) {
        // Por cada una de las comunidades a las que pertenece el Usuario, creo un incidente.
        comunidades.forEach((comu -> {
            Incidente incidenteReportado = new Incidente(comunidad.getId(), servicioAfectado.getId(), usuarioOpen, observaciones);
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




