package Dominio.ranking;

import Dominio.entidad.EntidadPrestadora;
import Dominio.entidad.RepositorioEntidadesPrestadoras;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class RepositorioRankings {
    @JsonProperty("entidades")
    public RepositorioEntidadesPrestadoras entidades;
    @JsonProperty("informeSemanal")
    public TipoInforme informeSemanal;

    public void generarInforme(){
        ArrayList<EntidadPrestadora> entidadesPrestadoras = entidades.getEntidades();
        // ArrayList<TipoRanking> segunCantIncidentes = (new SegunCantIncidentes()).calcular(entidadesPrestadoras);
        // ArrayList<TipoRanking> segunTiempoDeCierre = (new SegunTiempoDeCierre()).calcular(entidadesPrestadoras);
        // ArrayList<TipoRanking> segunGradoDeImpacto = (new SegunGradoDeImpacto()).calcular(entidadesPrestadoras);
        // informeSemanal = new TipoInforme(segunCantIncidentes, segunTiempoDeCierre, segunGradoDeImpacto);
    }
}
