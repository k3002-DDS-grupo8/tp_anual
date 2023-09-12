package Dominio.entidad;
import Dominio.localizacion.Localizacion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Organizacion extends EntidadPrestadora {
    final TipoOrganizacion tipo;

    public Organizacion(String nombre, ArrayList<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion, TipoOrganizacion tipo) {
        super(nombre, listaEstablecimientos, localizacion);
        this.tipo = tipo;
    }
}