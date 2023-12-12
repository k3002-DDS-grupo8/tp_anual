package Dominio.comunidad;
import Dominio.servicios.Servicio;
import Dominio.localizacion.Localizacion;
import Dominio.servicios.Servicios;
import persistencia.RepoTipoUsuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioPersona extends Usuario {

    @JsonProperty("id")
    private long id;
    @JsonProperty("apellido")
    final String apellido;
    @JsonProperty("medioComunicacion")
    final MedioComunicacion medioComunicacion;
    @JsonProperty("horarioDeNotificaciones")
    ArrayList<HorariosPosibles> horarioDeNotificaciones;
    @JsonProperty("eeoDeInteres")
    ArrayList<EEO> eeoDeInteres;

    @JsonCreator
    public UsuarioPersona(String nombre, String email, String telefono, ArrayList<Servicios> serviciosDeInteres, Localizacion localizacion, String apellido, ArrayList<Comunidad> comunidades, MedioComunicacion medioComunicacion, ArrayList<HorariosPosibles> horarioDeNotificaciones, ArrayList<EEO> eeoDeInteres, String contrasenia) {
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
        RepoTipoUsuario repoTipos = new RepoTipoUsuario();
        List<TipoUsuario> tipos = repoTipos.obtenerTodos();
        Optional<TipoUsuario> miembro = tipos.stream().filter(t -> t.getNombre() == "Miembro" ).findFirst();
        comunidad.agregarAComunidad(new MiembroComunidad(this, miembro, comunidad));
    }
}