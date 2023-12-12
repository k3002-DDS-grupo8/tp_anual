package Dominio.entidad;

import Dominio.localizacion.Localizacion;
import Dominio.servicios.GrupoServicios;
import Dominio.servicios.Servicio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Establecimiento {
    @JsonProperty("id")
    long id;
    @JsonProperty("nombre")
    final String nombre;
    @JsonProperty("ubicacionGeografica")
    public final Localizacion ubicacionGeografica;
    // tanto grupoServicios como servicios deberian ser un unico atributo, una lista de tipo interfaz Servicios
    @JsonProperty("grupoServicios")
    final List<GrupoServicios> grupoServicios;
    @JsonProperty("servicios")
    public final List<Servicio> servicios;
    @JsonProperty("entidadPrestadora")
    public EntidadPrestadora entidadPrestadora;

    @JsonCreator
    public Establecimiento(String nombre, Localizacion ubicacionGeografica, List<GrupoServicios> grupoServicios, List<Servicio> servicios) {
        this.nombre = nombre;
        this.ubicacionGeografica = ubicacionGeografica;
        this.grupoServicios = grupoServicios;
        this.servicios = servicios;
    }

}
