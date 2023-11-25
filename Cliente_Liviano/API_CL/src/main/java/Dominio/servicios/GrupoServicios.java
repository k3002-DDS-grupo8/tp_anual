package Dominio.servicios;

import Dominio.entidad.Establecimiento;

import javax.persistence.*;
import java.util.List;

public class GrupoServicios implements Servicios {
    private long idGrupoServicio;
    final String nombre;
    final List<Servicio> servicio;

    public GrupoServicios(String nombre, List<Servicio> servicio) {
        this.nombre = nombre;
        this.servicio = servicio;
    }

    @Override
    public void darDeBaja(Establecimiento unEstablecimineto) {

    }
}