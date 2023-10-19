package Dominio;

public class Comunidad {
    private long id;
    private GradoConfianza gradoConfianza;
    private boolean activo;

    public String getNombre() {
        return nombre;
    }

    private String nombre;


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

    public Comunidad() {
        this.id = 0;
        this.gradoConfianza = GradoConfianza.NO_CONFIABLE;
        this.activo = false;
    }

    public Comunidad(long id, GradoConfianza gradoConfianza, boolean activo) {
        this.id = id;
        this.gradoConfianza = gradoConfianza;
        this.activo = activo;
    }
}
