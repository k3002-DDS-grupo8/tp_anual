package Dominio.entidad;
import Dominio.localizacion.Localizacion;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Linea extends EntidadPrestadora {
    @Enumerated
    final TipoMedio tipo;
    @OneToOne
    final Establecimiento estacionOrigen;
    @OneToOne
    final Establecimiento estacionDestino;

    public Linea(String nombre, ArrayList<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion, TipoMedio tipo, Establecimiento estacionOrigen, Establecimiento estacionDestino) {
        super(nombre, listaEstablecimientos, localizacion);
        this.tipo = tipo;
        this.estacionOrigen = estacionOrigen;
        this.estacionDestino = estacionDestino;
    }
}