package Dominio.servicios;

import Dominio.entidad.Establecimiento;

import javax.persistence.*;
import java.util.List;

@Entity
public class GrupoServicios implements Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGrupoServicio;
    final String nombre;
    @ManyToMany
    final List<Servicio> servicio;

    public GrupoServicios(String nombre, List<Servicio> servicio) {
        this.nombre = nombre;
        this.servicio = servicio;
    }

    @Override
    public void darDeBaja(Establecimiento unEstablecimineto) {

    }
}