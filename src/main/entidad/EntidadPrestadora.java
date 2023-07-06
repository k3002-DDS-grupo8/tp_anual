package main.entidad;
import main.localizacion.Localizacion;

public class EntidadPrestadora {
    final String nombre;
    final Establecimiento[] listaEstablecimientos;
    final Localizacion[] localizacion;

    public EntidadPrestadora(String nombre, Establecimiento[] listaEstablecimientos, Localizacion[] localizacion) {
        this.nombre = nombre;
        this.listaEstablecimientos = listaEstablecimientos;
        this.localizacion = localizacion;
    }
}