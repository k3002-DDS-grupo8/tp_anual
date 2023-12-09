package Dominio.ranking;

import Dominio.entidad.EntidadPrestadora;
import Dominio.entidad.RepositorioEntidadesPrestadoras;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.persistence.*;
@Entity
public class Informe {
    @EmbeddedId
    private InformePK primaryKey;
    @OneToOne
    private EntidadPrestadora entidad;


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
