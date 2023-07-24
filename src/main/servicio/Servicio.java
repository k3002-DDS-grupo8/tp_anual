package main.servicio;

import main.entidad.Establecimiento;

public class Servicio {
    final String nombre;
    public Establecimiento establecimiento;

    public Servicio(String nombre, Establecimiento establecimiento) {
        this.nombre = nombre;
        this.establecimiento = establecimiento;
    }

    public boolean prestadoHabitualmente() {
        return false;
    }
}