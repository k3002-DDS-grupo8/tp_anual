package Dominio.servicio;

import Dominio.entidad.Establecimiento;
import Dominio.incidente.Incidente;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Servicio {
    final String nombre;
    private long idUsuario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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