package Dominio.comunidad;
import Dominio.servicios.Servicio;
import Dominio.localizacion.Localizacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


@Entity
public class UsuarioPersona extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    final String apellido;
    final MedioComunicacion medioComunicacion;
    ArrayList<HorariosPosibles> horarioDeNotificaciones;
    ArrayList<EEO> eeoDeInteres;

    public UsuarioPersona(String nombre, String email, String telefono, String contrasenia, ArrayList<Servicio> serviciosDeInteres, Localizacion localizacion, String apellido, ArrayList<Comunidad> comunidades, MedioComunicacion medioComunicacion, ArrayList<HorariosPosibles> horarioDeNotificaciones, ArrayList<EEO> eeoDeInteres) {
        super(nombre, email, contrasenia, telefono, serviciosDeInteres, localizacion, comunidades);
        this.apellido = apellido;
        this.medioComunicacion = medioComunicacion;
        this.horarioDeNotificaciones = horarioDeNotificaciones;
        this.eeoDeInteres = eeoDeInteres;
    }
    public void hacerRevisionManual(){
        //notificar pedido de revision
    }
    public void unirseAComunidad(Comunidad comunidad){
        //comunidad.agregarAComunidad(new MiembroComunidad(this, 1, comunidad));
    }
}