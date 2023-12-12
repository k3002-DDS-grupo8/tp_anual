package Dominio.servicios;

import Dominio.entidad.Establecimiento;
import Dominio.incidente.Incidente;
import javax.persistence.*;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Servicio implements Servicios{
    @JsonProperty("idServicio")
    private long idServicio;
    @JsonProperty("nombre")
    final String nombre;
    @JsonProperty("establecimiento")
    public long establecimiento;
    @JsonProperty("incidentes")
    public ArrayList<Long> incidentes;

    @JsonCreator
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
    
    public void darDeBaja(Establecimiento unEstablecimineto) {

    }
}
