package Dominio.servicios;

import Dominio.entidad.Establecimiento;
import Dominio.incidente.Incidente;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Servicio implements Servicios{
    @Id
    private long idServicio;
    final String nombre;
    @OneToOne
    public long establecimiento;
    public ArrayList<Long> incidentes;

    public Servicio(String nombre, long establecimiento, ArrayList<Long> incidentes) {
        this.nombre = nombre;
        this.establecimiento = establecimiento;
        this.incidentes = incidentes;
    }
    public long getId()  {
        return idServicio;
    }

    public boolean prestadoHabitualmente() {
        return false;
    }

    @Override
    public void darDeBaja(Establecimiento unEstablecimineto) {

    }
}