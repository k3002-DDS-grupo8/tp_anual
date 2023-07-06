package main.entidad;
import main.localizacion.Localizacion;

public class Organizacion extends EntidadPrestadora {
    final TipoOrganizacion tipo;

    public Organizacion(String nombre, Establecimiento[] listaEstablecimientos, Localizacion[] localizacion, TipoOrganizacion tipo) {
        super(nombre, listaEstablecimientos, localizacion);
        this.tipo = tipo;
    }
}