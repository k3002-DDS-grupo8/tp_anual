package Dominio.ranking;

import Dominio.incidente.TipoRanking;

import java.util.ArrayList;

public class TipoInforme {
    ArrayList<TipoRanking> segunCantIncidentes;
    ArrayList<TipoRanking> segunTiempoDeCierre;
    ArrayList<TipoRanking> segunGradoDeImpacto;

    public TipoInforme(ArrayList<TipoRanking> segunCantIncidentes, ArrayList<TipoRanking> segunTiempoDeCierre, ArrayList<TipoRanking> segunGradoDeImpacto) {
        this.segunCantIncidentes = segunCantIncidentes;
        this.segunTiempoDeCierre = segunTiempoDeCierre;
        this.segunGradoDeImpacto = segunGradoDeImpacto;
    }
}
