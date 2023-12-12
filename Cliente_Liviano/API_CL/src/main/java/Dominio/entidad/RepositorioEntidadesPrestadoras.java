package Dominio.entidad;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

///////////////////
//CHEQUEAR ESTA CLASE
//////////////////

public class RepositorioEntidadesPrestadoras {
    @JsonProperty("entidades")
    public ArrayList<EntidadPrestadora> entidades;

    public ArrayList<EntidadPrestadora> getEntidades() {
        return entidades;
    }
}
