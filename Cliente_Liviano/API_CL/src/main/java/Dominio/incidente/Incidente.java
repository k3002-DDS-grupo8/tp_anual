package Dominio.incidente;
import Dominio.comunidad.Usuario;
import Dominio.localizacion.Localizacion;
import Dominio.servicios.Servicio;

import Dominio.comunidad.Comunidad;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    Comunidad comunidad;
    @OneToOne
    Servicio servicio;
    @OneToOne
    Usuario usuarioOpen;
    @OneToOne
    Usuario usuarioClose;
    String observaciones;
    public EstadoIncidente estado = EstadoIncidente.ABIERTO;
    public LocalDateTime horarioDeApertura = LocalDateTime.now();
    public LocalDateTime horarioDeCierre;
    public float tiempoFueraDeServicio;


    public void cerrar() {
        this.estado = EstadoIncidente.CERRADO;
        tiempoFueraDeServicio = ChronoUnit.SECONDS.between(LocalDateTime.now(), horarioDeApertura);
        horarioDeCierre = LocalDateTime.now();
    }

    public void importancia() {}

    public Localizacion getLocalizacionIncidente() {
        return this.servicio.establecimiento.ubicacionGeografica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdComunidad() {
        return comunidad.getId();
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public EstadoIncidente getEstado() {
        return estado;
    }
    public void setEstado(EstadoIncidente estado) {
        this.estado = estado;
    }
    public LocalDateTime getHorarioDeApertura() {
        return horarioDeApertura;
    }

    public void setHorarioDeApertura(LocalDateTime horarioDeApertura) {
        this.horarioDeApertura = horarioDeApertura;
    }

    public LocalDateTime getHorarioDeCierre() {
        return horarioDeCierre;
    }

    public void setHorarioDeCierre(LocalDateTime horarioDeCierre) {
        this.horarioDeCierre = horarioDeCierre;
    }

    public long getIdUsuarioApertura() {
        return usuarioOpen.getId();
    }

    public void setIdUsuarioApertura(Usuario usuarioApertura) {
        this.usuarioOpen = usuarioApertura;
    }

    public long getIdUsuarioCierre() {
        return usuarioClose.getId();
    }

    public void setIdUsuarioCierre(Usuario usuarioCierre) {
        this.usuarioClose = usuarioCierre;
    }


    //  @FEDE para las consultas de sql aca hay algo raro, si nosotros solemos pedir idUsuarioApertura pero aca pide un usuario
    public Incidente(long idComunidad, long idServicio, Usuario usuarioApertura, String observaciones) {
        this.comunidad = comunidad;
        this.servicio = servicio;
        this.observaciones = observaciones;
        this.estado = EstadoIncidente.ABIERTO;
        this.horarioDeApertura = LocalDateTime.now();
        this.horarioDeCierre = null;
        this.usuarioOpen = usuarioApertura;
        this.usuarioClose = null;
    }
    public IncidenteVacio(Comunidad comunidad, Servicio servicio, Usuario usuarioApertura, String observaciones, EstadoIncidente EstadoIncidente, LocalDateTime horarioDeApertura, LocalDateTime horarioDeCierre, Usuario usuarioCierre) {
        this.comunidad = comunidad;
        this.servicio = servicio;
        this.observaciones = observaciones;
        this.estado = EstadoIncidente;
        this.horarioDeApertura = horarioDeApertura;
        this.horarioDeCierre = horarioDeCierre;
        this.usuarioOpen = usuarioApertura;
        this.usuarioClose = usuarioCierre;
    }

    public void actualizarEstado(EstadoIncidente nuevoEstado) {
    }
    /*
        @JsonProperty("id")
        private long id;
        @JsonProperty("idComunidad")
        private long idComunidad;
        @JsonProperty("idServicio")
        private long idServicio;
        @JsonProperty("observaciones")
        String observaciones;
        @JsonProperty("estado")
        private String estado;
        @JsonProperty("horarioDeApertura")
        private LocalDateTime horarioDeApertura;
        @JsonProperty("horarioDeCierre")
        private LocalDateTime horarioDeCierre;
        @JsonProperty("idUsuarioApertura")
        private long idUsuarioApertura;
        @JsonProperty("idUsuarioCierre")
        private long idUsuarioCierre;

        public Incidente() {
            this.id = 1;
            this.idComunidad = 1;
            this.idServicio = 1;
            this.observaciones = "";
            this.estado = "ABIERTO";
            this.horarioDeApertura = null;
            this.horarioDeCierre = null;
            this.idUsuarioApertura = 1;
            this.idUsuarioCierre = 0;
        }

        @JsonCreator
        public Incidente(@JsonProperty("id") long id, @JsonProperty("idComunidad") long idComunidad, @JsonProperty("idServicio") long idServicio, @JsonProperty("observaciones") String observaciones, @JsonProperty("estado") String estado, @JsonProperty("idUsuarioCierre") long idUsuarioCierre) {
            this.id = id;
            this.idComunidad = idComunidad;
            this.idServicio = idServicio;
            this.observaciones = observaciones;
            this.estado = estado;
            this.horarioDeApertura = null;
            this.horarioDeCierre = null;
            this.idUsuarioApertura = idUsuarioCierre;
            this.idUsuarioCierre = 0;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setIdComunidad(long idComunidad) {
            this.idComunidad = idComunidad;
        }

        public void setIdServicio(long idServicio) {
            this.idServicio = idServicio;
        }

        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public void setHorarioDeApertura(LocalDateTime horarioDeApertura) {
            this.horarioDeApertura = horarioDeApertura;
        }

        public void setHorarioDeCierre(LocalDateTime horarioDeCierre) {
            this.horarioDeCierre = horarioDeCierre;
        }

        public void setIdUsuarioApertura(long idUsuarioApertura) {
            this.idUsuarioApertura = idUsuarioApertura;
        }

        public void setIdUsuarioCierre(long idUsuarioCierre) {
            this.idUsuarioCierre = idUsuarioCierre;
        }

        public long getId() {
            return id;
        }

        public long getIdComunidad() {
            return idComunidad;
        }

        public long getIdServicio() {
            return idServicio;
        }

        public String getObservaciones() {
            return observaciones;
        }

        public String getEstado() {
            return estado;
        }

        public LocalDateTime getHorarioDeApertura() {
            return horarioDeApertura;
        }

        public LocalDateTime getHorarioDeCierre() {
            return horarioDeCierre;
        }

        public long getIdUsuarioApertura() {
            return idUsuarioApertura;
        }

        public long getIdUsuarioCierre() {
            return idUsuarioCierre;
        }
    */
}
