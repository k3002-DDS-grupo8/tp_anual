package Dominio;
import java.util.List;

public class Comunidad {
    private long id;
    private float puntosConfianza;
    private String gradoConfianza;
    private boolean activo;

    public void setId(long id) {
        this.id = id;
    }

    public void setPuntosConfianza(float puntosConfianza) {
        this.puntosConfianza = puntosConfianza;
    }

    public void setGradoConfianza(String gradoConfianza) {
        this.gradoConfianza = gradoConfianza;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Comunidad() {
        this.id = 0;
        this.puntosConfianza = 0;
        this.gradoConfianza = "";
        this.activo = false;
    }
}
