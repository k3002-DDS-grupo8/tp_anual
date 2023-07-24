package main.servicio;

import main.entidad.Establecimiento;
import main.incidente.Incidente;

import java.util.ArrayList;

public class Servicio {
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
}