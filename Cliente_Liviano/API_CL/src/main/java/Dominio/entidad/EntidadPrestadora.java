package Dominio.entidad;
import Dominio.comunidad.EEO;
import Dominio.localizacion.Localizacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class EntidadPrestadora {
    private long idEntidad;
    final String nombre;

    public final List<Establecimiento> listaEstablecimientos;
    final ArrayList<Localizacion> localizacion;
    final EEO usuarioEEO;

    public EntidadPrestadora(String nombre, List<Establecimiento> listaEstablecimientos, ArrayList<Localizacion> localizacion, EEO usuarioEEO) {
        this.nombre = nombre;
        this.listaEstablecimientos = listaEstablecimientos;
        this.localizacion = localizacion;
        this.usuarioEEO = usuarioEEO;
    }

    public void cosultarRankings(){

    }
}