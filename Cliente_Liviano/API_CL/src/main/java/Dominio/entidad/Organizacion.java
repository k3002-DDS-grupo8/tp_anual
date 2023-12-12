package Dominio.entidad;
import Dominio.comunidad.EEO;
import Dominio.localizacion.Localizacion;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Organizacion extends EntidadPrestadora {
    @JsonProperty("tipo")
    final TipoOrganizacion tipo;

    @JsonCreator
    public Organizacion(String nombre, ArrayList<Establecimiento> listaEstablecimientos, EEO usuarioEEO , ArrayList<Localizacion> localizacion, TipoOrganizacion tipo) {
        super(nombre, listaEstablecimientos, localizacion, usuarioEEO);
        this.tipo = tipo;
    }
}
