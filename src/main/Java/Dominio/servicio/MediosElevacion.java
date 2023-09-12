package Dominio.servicio;

import Dominio.entidad.Establecimiento;
import Dominio.incidente.Incidente;

import java.util.ArrayList;

public class MediosElevacion extends Servicio {
    final String inicio;
    String fin = null;

    public MediosElevacion(String nombre, String inicio, Establecimiento establecimiento, ArrayList<Incidente> incidentes) {
        super(nombre, establecimiento, incidentes);
        this.inicio = inicio;
        this.fin = fin;
    }
}