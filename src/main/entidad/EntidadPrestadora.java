package main.entidad;
import main.localizacion.Localizacion;
import java.util.ArrayList;

public class EntidadPrestadora {
    final String nombre;
    public final ArrayList<Establecimiento> listaEstablecimientos;
    final ArrayList<Localizacion> localizacion;

    public EntidadPrestadora(String nombre, ArrayList<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion) {
        this.nombre = nombre;
        this.listaEstablecimientos = listaEstablecimientos;
        this.localizacion = localizacion;
    }
}