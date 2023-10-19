package Dominio;

import java.util.ArrayList;

public class Usuario {
    private long id;
    private float puntosConfianza;
    private GradoConfianza gradoConfianza;
    private boolean activo;

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Comunidad> getComunidades() {
        return comunidades;
    }

    private String nombre;
    private String email;
    private ArrayList<Comunidad> comunidades;

    public void setId(long id) {
        this.id = id;
    }

    public void setPuntosConfianza(float puntosConfianza) {
        this.puntosConfianza += puntosConfianza;
    }

    public void setGradoConfianza(GradoConfianza gradoConfianza) {
        this.gradoConfianza = gradoConfianza;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public long getId() {
        return id;
    }

    public float getPuntosConfianza() {
        return puntosConfianza;
    }

    public GradoConfianza getGradoConfianza() {
        return gradoConfianza;
    }

    public boolean isActivo() {
        return activo;
    }

    public Usuario() {
        this.id = 0;
        this.puntosConfianza = 5;
        this.gradoConfianza = GradoConfianza.CONFIABLE_NIVEL_2;
        this.activo = false;
    }

    public Usuario(long id, float puntosConfianza, GradoConfianza gradoConfianza, boolean activo, String nombre, String email) {
        this.id = id;
        this.puntosConfianza = puntosConfianza;
        this.gradoConfianza = gradoConfianza;
        this.activo = activo;
        this.comunidades = null;
        this.nombre = nombre;
        this.email = email;
    }
}
