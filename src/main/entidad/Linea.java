package main.entidad;
import main.localizacion.Localizacion;

public class Linea extends EntidadPrestadora {
    final TipoMedio tipo;
    final Establecimiento estacionOrigen;
    final Establecimiento estacionDestino;

    public Linea(String nombre, Establecimiento[] listaEstablecimientos, Localizacion[] localizacion, TipoMedio tipo, Establecimiento estacionOrigen, Establecimiento estacionDestino) {
        super(nombre, listaEstablecimientos, localizacion);
        this.tipo = tipo;
        this.estacionOrigen = estacionOrigen;
        this.estacionDestino = estacionDestino;
    }
}