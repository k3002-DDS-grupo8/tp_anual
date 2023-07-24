package main.ranking;

import main.entidad.EntidadPrestadora;
import main.entidad.RepositorioEntidadesPrestadoras;
import main.incidente.TipoRanking;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RepositorioRankings {
    public RepositorioEntidadesPrestadoras entidades;
    public TipoInforme informeSemanal;

    public void generarInforme(){
        ArrayList<EntidadPrestadora> entidadesPrestadoras = entidades.getEntidades();
        ArrayList<TipoRanking> segunCantIncidentes = (new SegunCantIncidentes()).calcular(entidadesPrestadoras);
        ArrayList<TipoRanking> segunTiempoDeCierre = (new SegunTiempoDeCierre()).calcular(entidadesPrestadoras);
        ArrayList<TipoRanking> segunGradoDeImpacto = (new SegunGradoDeImpacto()).calcular(entidadesPrestadoras);
        informeSemanal = new TipoInforme(segunCantIncidentes, segunTiempoDeCierre, segunGradoDeImpacto);
    }
}
