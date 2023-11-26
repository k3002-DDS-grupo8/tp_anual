package Dominio;

import Dominio.comunidad.GradoConfianza;

import java.util.ArrayList;
import java.util.List;

public class Comunidad {
    private long id;
    private GradoConfianza gradoConfianza;
    private List<Long> usuariosIDs;
    private boolean activo;

    public String getNombre() {
        return nombre;
    }

    private String nombre;

    public List<Long> getUsuariosIDs() {
        return usuariosIDs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GradoConfianza getGradoConfianza() {
        return gradoConfianza;
    }

    public void setGradoConfianza(GradoConfianza gradoConfianza) {
        this.gradoConfianza = gradoConfianza;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Comunidad() {}

    public Comunidad(long id, List<Long> usuariosIDs, GradoConfianza gradoConfianza, boolean activo) {
        this.id = id;
        this.gradoConfianza = gradoConfianza;
        this.activo = activo;
        this.usuariosIDs = usuariosIDs;
    }
}
