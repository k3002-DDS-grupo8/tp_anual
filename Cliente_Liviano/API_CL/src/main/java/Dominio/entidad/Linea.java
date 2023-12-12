package Dominio.entidad;
import Dominio.comunidad.EEO;
import Dominio.localizacion.Localizacion;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.ArrayList;

public class Linea extends EntidadPrestadora {
    
    @JsonProperty("tipo")
    final TipoMedio tipo;
    @JsonProperty("estacionOrigen")
    final Establecimiento estacionOrigen;
    @JsonProperty("estacionDestino")
    final Establecimiento estacionDestino;

    @JsonCreator
    public Linea(String nombre, ArrayList<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion, EEO usuarioEEO, TipoMedio tipo, Establecimiento estacionOrigen, Establecimiento estacionDestino) {
        super(nombre, listaEstablecimientos, localizacion, usuarioEEO);
        this.tipo = tipo;
        this.estacionOrigen = estacionOrigen;
        this.estacionDestino = estacionDestino;
    }
}
