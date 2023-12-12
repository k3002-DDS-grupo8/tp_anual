package Dominio.entidad;
import Dominio.comunidad.EEO;
import Dominio.localizacion.Localizacion;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class EntidadPrestadora {
    @JsonProperty("idEntidad")
    private long idEntidad;
    @JsonProperty("nombre")
    final String nombre;
    @JsonProperty("listaEstablecimientos")
    public final List<Establecimiento> listaEstablecimientos;
    @JsonProperty("localizacion")
    final ArrayList<Localizacion> localizacion;
    @JsonProperty("usuarioEEO")
    final EEO usuarioEEO;
    
    @JsonCreator
    public EntidadPrestadora(String nombre, List<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion, EEO usuarioEEO) {
        this.nombre = nombre;
        this.listaEstablecimientos = listaEstablecimientos;
        this.localizacion = localizacion;
        this.usuarioEEO = usuarioEEO;
    }

    public void cosultarRankings(){

    }
}
