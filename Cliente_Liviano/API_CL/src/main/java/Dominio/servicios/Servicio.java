package Dominio.servicios;

import Dominio.entidad.Establecimiento;
import Dominio.Incidente;
import javax.persistence.*;
import java.util.ArrayList;

public class Servicio implements Servicios{
    private long idServicio;
    final String nombre;
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

    @Override
    public void darDeBaja(Establecimiento unEstablecimineto) {

    }
}