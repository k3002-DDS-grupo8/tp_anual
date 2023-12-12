package Dominio.servicios;

import Dominio.entidad.Establecimiento;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.List;

public class GrupoServicios implements Servicios {
    @JsonProperty("idGrupoServicio")
    private long idGrupoServicio;
    @JsonProperty("nombre")
    final String nombre;
    @JsonProperty("servicio")
    final List<Servicio> servicio;

    @JsonCreator
    public GrupoServicios(String nombre, List<Servicio> servicio) {
        this.nombre = nombre;
        this.servicio = servicio;
    }

    public void darDeBaja(Establecimiento unEstablecimineto) {

    }
}
