package Dominio.entidad;

import Dominio.localizacion.Localizacion;
import Dominio.servicios.GrupoServicios;
import Dominio.servicios.Servicio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
public class Establecimiento {
    long id;
    final String nombre;

    public final Localizacion ubicacionGeografica;

    // tanto grupoServicios como servicios deberian ser un unico atributo, una lista de tipo interfaz Servicios
    final List<GrupoServicios> grupoServicios;
    public final List<Servicio> servicios;

    public EntidadPrestadora entidadPrestadora;

    public Establecimiento(String nombre, Localizacion ubicacionGeografica, List<GrupoServicios> grupoServicios, List<Servicio> servicios) {
        this.nombre = nombre;
        this.ubicacionGeografica = ubicacionGeografica;
        this.grupoServicios = grupoServicios;
        this.servicios = servicios;
    }

}