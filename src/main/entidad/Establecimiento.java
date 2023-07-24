package main.entidad;
import main.localizacion.Localizacion;
import main.servicio.Servicio;
import main.servicio.GrupoServicios;
import main.entidad.EntidadPrestadora;

import java.util.ArrayList;


public class Establecimiento {
    final String nombre;
    public final Localizacion ubicacionGeografica;
    final ArrayList<GrupoServicios> grupoServicios;
    public final ArrayList<Servicio> servicios;
    public final EntidadPrestadora entidadPrestadora;

    public Establecimiento(String nombre, Localizacion ubicacionGeografica, ArrayList<GrupoServicios> grupoServicios, ArrayList<Servicio> servicios) {
        this.nombre = nombre;
        this.ubicacionGeografica = ubicacionGeografica;
        this.grupoServicios = grupoServicios;
        this.servicios = servicios;
    }
}