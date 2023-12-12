package Dominio.ranking;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TipoInforme {
    @JsonProperty("segunCantIncidentes")
    ArrayList<TipoRanking> segunCantIncidentes;
    @JsonProperty("segunTiempoDeCierre")
    ArrayList<TipoRanking> segunTiempoDeCierre;
    @JsonProperty("segunGradoDeImpacto")
    ArrayList<TipoRanking> segunGradoDeImpacto;

    public TipoInforme(ArrayList<TipoRanking> segunCantIncidentes, ArrayList<TipoRanking> segunTiempoDeCierre, ArrayList<TipoRanking> segunGradoDeImpacto) {
        this.segunCantIncidentes = segunCantIncidentes;
        this.segunTiempoDeCierre = segunTiempoDeCierre;
        this.segunGradoDeImpacto = segunGradoDeImpacto;
    }
}
