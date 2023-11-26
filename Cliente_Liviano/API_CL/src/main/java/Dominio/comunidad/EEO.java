package Dominio.comunidad;
import Dominio.localizacion.Localizacion;
import Dominio.servicios.Servicio;
import Dominio.servicios.Servicios;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.SimpleTimeZone;

@Entity
public class EEO extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    final Responsable responsable;

    final String descripcion;

    public EEO(String nombre, String email, String telefono, ArrayList<Servicios> serviciosDeInteres, Localizacion localizacion, Responsable responsable, String descripcion, ArrayList<Comunidad> comunidades, String contrasenia) {
        super(nombre,
                email,
                contrasenia,
                telefono,
                serviciosDeInteres,
                localizacion,
                comunidades);
        this.responsable = responsable;
        this.descripcion = descripcion;
    }
    public void consultarRankings(){
        // este metodo debe pedir a donde se almacenan los rankings que los muestre
    }

    //a traerUsuariosConEEOdeInteres() necesita bajar una lista de los usuariosPersona de la DB
    private ArrayList<UsuarioPersona> traerUsuariosConEEOdeInteres(){
        ArrayList<UsuarioPersona> interesados = new ArrayList<>();
        return interesados;
    }

    //falta completar
    public void notificarIncidentePropio(){
        ArrayList<UsuarioPersona> usuariosInteresados = new ArrayList<>(traerUsuariosConEEOdeInteres());
    }
}