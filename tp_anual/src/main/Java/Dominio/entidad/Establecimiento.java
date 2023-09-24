package Dominio.entidad;
import Dominio.localizacion.Localizacion;
import Dominio.servicio.Servicio;
import Dominio.servicio.GrupoServicios;
import Dominio.entidad.EntidadPrestadora;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    final String nombre;
    @Transient
    public final Localizacion ubicacionGeografica;
    final ArrayList<GrupoServicios> grupoServicios;
    public final ArrayList<Servicio> servicios;
    @OneToOne
    public EntidadPrestadora entidadPrestadora;

    public Establecimiento(String nombre, Localizacion ubicacionGeografica, ArrayList<GrupoServicios> grupoServicios, ArrayList<Servicio> servicios) {
        this.nombre = nombre;
        this.ubicacionGeografica = ubicacionGeografica;
        this.grupoServicios = grupoServicios;
        this.servicios = servicios;
    }
}