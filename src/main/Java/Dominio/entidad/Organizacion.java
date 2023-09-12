package Dominio.entidad;
import Dominio.localizacion.Localizacion;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
@Entity
public class Organizacion extends EntidadPrestadora {
    @Enumerated
    final TipoOrganizacion tipo;

    public Organizacion(String nombre, ArrayList<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion, TipoOrganizacion tipo) {
        super(nombre, listaEstablecimientos, localizacion);
        this.tipo = tipo;
    }
}