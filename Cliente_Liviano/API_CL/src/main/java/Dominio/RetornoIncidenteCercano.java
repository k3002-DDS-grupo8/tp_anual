package Dominio;

import java.time.LocalDateTime;

public class RetornoIncidenteCercano {

    private long id;

    private String nombreComunidad;

    private String nombreServicio;

    private LocalDateTime horarioDeApertura;

    private String observaciones;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public void setNombreComunidad(String nombreComunidad) {
        this.nombreComunidad = nombreComunidad;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public LocalDateTime getHorarioDeApertura() {
        return horarioDeApertura;
    }

    public void setHorarioDeApertura(LocalDateTime horarioDeApertura) {
        this.horarioDeApertura = horarioDeApertura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public RetornoIncidenteCercano(long id, String nombreComunidad, String nombreServicio, LocalDateTime horarioDeApertura, String observaciones) {
        this.id = id;
        this.nombreComunidad = nombreComunidad;
        this.nombreServicio = nombreServicio;
        this.horarioDeApertura = horarioDeApertura;
        this.observaciones = observaciones;
    }
}
