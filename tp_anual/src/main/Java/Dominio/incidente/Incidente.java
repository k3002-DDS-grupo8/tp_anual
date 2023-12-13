package Dominio.incidente;
import Dominio.comunidad.Usuario;
import Dominio.localizacion.Localizacion;
import Dominio.servicios.Servicio;

import Dominio.comunidad.Comunidad;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Incidente {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    Comunidad comunidad;
    @OneToOne
    Servicio servicio;
    @OneToOne //deberia ser idUsuarioApertura (es mas facil cambiarlo en las apis y fue)
    Usuario usuarioApertura;
    @OneToOne //deberia ser idUsuarioCierre (es mas facil cambiarlo en las apis y fue)
    Usuario usuarioCierre;
    public String observaciones;
    public EstadoIncidente estado = EstadoIncidente.ABIERTO;
    public LocalDateTime horarioDeApertura = LocalDateTime.now();
    public LocalDateTime horarioDeCierre;
    public float tiempoFueraDeServicio;

    public Incidente(Comunidad comunidad, String observaciones) {
        this.comunidad = comunidad;
        this.observaciones = observaciones;
    }

    public void cerrar() {
        this.estado = EstadoIncidente.CERRADO;
        tiempoFueraDeServicio = ChronoUnit.SECONDS.between(LocalDateTime.now(), horarioDeApertura);
        horarioDeCierre = LocalDateTime.now();
    }

    public void actualizarEstado(EstadoIncidente nuevoEstado) {
        this.estado = nuevoEstado;
    }
    public void importancia() {}

}
