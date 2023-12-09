package Dominio.ranking;

import Dominio.Entidad;

public class Informe {
    private InformePK primaryKey;
    private Entidad entidad;

    public Informe(InformePK primaryKey, Entidad entidad) {
        this.primaryKey = primaryKey;
        this.entidad = entidad;
    }

    public long getRankingId(){
        return primaryKey.getRankingId();
    }

    /*
    public RepositorioEntidadesPrestadoras entidades;
    public TipoInforme informeSemanal;

    public void generarInforme(){
        ArrayList<EntidadPrestadora> entidadesPrestadoras = entidades.getEntidades();
        // ArrayList<TipoRanking> segunCantIncidentes = (new SegunCantIncidentes()).calcular(entidadesPrestadoras);
        // ArrayList<TipoRanking> segunTiempoDeCierre = (new SegunTiempoDeCierre()).calcular(entidadesPrestadoras);
        // ArrayList<TipoRanking> segunGradoDeImpacto = (new SegunGradoDeImpacto()).calcular(entidadesPrestadoras);
        // informeSemanal = new TipoInforme(segunCantIncidentes, segunTiempoDeCierre, segunGradoDeImpacto);
    }

     */
}
