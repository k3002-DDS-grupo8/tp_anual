package Dominio.entidad;
import Dominio.localizacion.Localizacion;

import java.util.ArrayList;

public class Linea extends EntidadPrestadora {
    final TipoMedio tipo;
    final Establecimiento estacionOrigen;
    final Establecimiento estacionDestino;

    public Linea(String nombre, ArrayList<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion, TipoMedio tipo, Establecimiento estacionOrigen, Establecimiento estacionDestino) {
        super(nombre, listaEstablecimientos, localizacion);
        this.tipo = tipo;
        this.estacionOrigen = estacionOrigen;
        this.estacionDestino = estacionDestino;
    }
}