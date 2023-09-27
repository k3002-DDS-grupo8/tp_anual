package Dominio;

public class Usuario {
    private long id;
    private float puntosConfianza;
    private GradoConfianza gradoConfianza;
    private boolean activo;

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

    public Usuario(long id, float puntosConfianza, GradoConfianza gradoConfianza, boolean activo) {
        this.id = id;
        this.puntosConfianza = puntosConfianza;
        this.gradoConfianza = gradoConfianza;
        this.activo = activo;
    }
}
