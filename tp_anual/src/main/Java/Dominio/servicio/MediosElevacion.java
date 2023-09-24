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
    private String inicio;
    private String fin;

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }
    public void setFin(String fin) {
        this.fin = fin;
    }

    public MediosElevacion(String nombre, String inicio, Establecimiento establecimiento, ArrayList<Incidente> incidentes) {
        super(nombre, establecimiento, incidentes);
        this.inicio = inicio;
        this.fin = fin;
    }
}