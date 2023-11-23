package Dominio.entidad;
import Dominio.comunidad.EEO;
import Dominio.localizacion.Localizacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EntidadPrestadora {
    @Id
    private long idEntidad;
    final String nombre;
    @OneToMany
    public final List<Establecimiento> listaEstablecimientos;
    @Transient
    final ArrayList<Localizacion> localizacion;
    @OneToOne
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