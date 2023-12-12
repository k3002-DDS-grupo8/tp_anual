package Dominio.ranking;

import Dominio.entidad.EntidadPrestadora;

public class TipoRanking {
    public final EntidadPrestadora entidad;
    public  final Float numero;

    public TipoRanking(EntidadPrestadora entidad, Float numero) {
        this.entidad = entidad;
        this.numero = numero;
    }
}
