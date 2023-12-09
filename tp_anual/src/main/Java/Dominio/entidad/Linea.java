package Dominio.entidad;
import Dominio.comunidad.EEO;
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

    public Linea(String nombre, ArrayList<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion, EEO usuarioEEO, TipoMedio tipo, Establecimiento estacionOrigen, Establecimiento estacionDestino,String email, String descripcion ) {
        super(nombre, listaEstablecimientos, localizacion, usuarioEEO, email, descripcion);
        this.tipo = tipo;
        this.estacionOrigen = estacionOrigen;
        this.estacionDestino = estacionDestino;
    }
}