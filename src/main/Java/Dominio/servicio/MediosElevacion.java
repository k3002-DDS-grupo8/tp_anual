package Dominio.servicio;

import Dominio.entidad.Establecimiento;
import Dominio.incidente.Incidente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class MediosElevacion extends Servicio {

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    final String inicio;
    String fin = null;

    public MediosElevacion(String nombre, String inicio, Establecimiento establecimiento, ArrayList<Incidente> incidentes) {
        super(nombre, establecimiento, incidentes);
        this.inicio = inicio;
        this.fin = fin;
    }
}