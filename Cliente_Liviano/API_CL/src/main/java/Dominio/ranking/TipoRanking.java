package Dominio.ranking;

import Dominio.entidad.EntidadPrestadora;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoRanking {
    @JsonProperty("entidad")
    public final EntidadPrestadora entidad;
    @JsonProperty("numero")
    public  final Float numero;

    @JsonCreator
    public TipoRanking(EntidadPrestadora entidad, Float numero) {
        this.entidad = entidad;
        this.numero = numero;
    }
}
