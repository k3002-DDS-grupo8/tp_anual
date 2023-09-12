package Dominio.servicio;

import Dominio.entidad.Establecimiento;
import Dominio.incidente.Incidente;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Servicio {
    final String nombre;
    private long idUsuario;
    @Id
    private long idServicio;
    @OneToOne
    public Establecimiento establecimiento;
    public ArrayList<Incidente> incidentes;

    public Servicio(String nombre, Establecimiento establecimiento, ArrayList<Incidente> incidentes) {
        this.nombre = nombre;
        this.establecimiento = establecimiento;
        this.incidentes = incidentes;
    }

    public boolean prestadoHabitualmente() {
        return false;
    }
}