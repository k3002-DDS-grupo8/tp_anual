package Dominio.servicios;

import Dominio.entidad.Establecimiento;
import Dominio.incidente.Incidente;

import javax.persistence.Entity;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MediosElevacion extends Servicio {
    @JsonProperty("inicio")
    private String inicio;
    @JsonProperty("fin")
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

    public MediosElevacion(String nombre, String inicio, long establecimiento, ArrayList<Long> incidentes, String fin) {
        super(nombre, establecimiento, incidentes);
        this.inicio = inicio;
        this.fin = fin;
    }
}
